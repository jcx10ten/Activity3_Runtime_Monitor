/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProcesosJvm {

    // Mapa de "nombre visible" -> descriptor completo
    // Lo usamos para que el combo muestre nombre legible
    // y el controlador pueda obtener el pid real
    private Map<String, VirtualMachineDescriptor> procesos = new LinkedHashMap<>();

    public void actualizar() {
        procesos.clear();
        String pidPropio = String.valueOf(ProcessHandle.current().pid());
        List<VirtualMachineDescriptor> lista = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd : lista) {
            // Saltar el proceso propio
            if (vmd.id().equals(pidPropio)) {
                continue;
            }

            String nombre = vmd.displayName().isEmpty()
                    ? "PID " + vmd.id()
                    : vmd.displayName() + " (PID " + vmd.id() + ")";
            procesos.put(nombre, vmd);
        }
    }

    public Map<String, VirtualMachineDescriptor> getProcesos() {
        return procesos;
    }

    // Devuelve el puerto JMX de un proceso dado su nombre visible
    // Adjunta la JVM temporalmente para leer el puerto
    public String obtenerUrlJmx(String nombreVisible) throws Exception {
        VirtualMachineDescriptor vmd = procesos.get(nombreVisible);
        VirtualMachine vm = VirtualMachine.attach(vmd);
        vm.startLocalManagementAgent();
        String jmxUrl = vm.getAgentProperties()
                .getProperty("com.sun.management.jmxremote.localConnectorAddress");
        vm.detach();
        return jmxUrl; // devuelve la URL completa, no solo el puerto
    }
}
