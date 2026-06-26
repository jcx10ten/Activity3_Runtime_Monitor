package co.edu.udistrital.controller;

import co.edu.udistrital.model.JvmConnector;
import co.edu.udistrital.model.MemoData;
import co.edu.udistrital.model.MemoMonitor;
import co.edu.udistrital.model.ProcesosJvm;
import co.edu.udsitrital.view.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Timer;

public class Controller implements ActionListener {

    private JvmConnector connector;
    private MemoMonitor monitor;
    private Timer timer;
    private VentanaPrincipal ventanaPrincipal;
    private ProcesosJvm procesosJvm;
    private long minHeap = Long.MAX_VALUE;
    private long maxHeap = Long.MIN_VALUE;

    public Controller() {
        this.connector = new JvmConnector();
        this.monitor = new MemoMonitor(connector);
        this.procesosJvm = new ProcesosJvm();
        ventanaPrincipal = new VentanaPrincipal();

        cargarProcesosEnCombo();
        asignarOyentes();
    }

    private void cargarProcesosEnCombo() {
        procesosJvm.actualizar();
        DefaultComboBoxModel<String> modelo = ventanaPrincipal.getPanelBotones().getModeloComboProcesos();
        modelo.removeAllElements();
        for (String nombre : procesosJvm.getProcesos().keySet()) {
            modelo.addElement(nombre);
        }
    }

    private String getProcesoSeleccionado() {
        return (String) ventanaPrincipal.getPanelBotones().getComboProcesos().getSelectedItem();
    }

    public void asignarOyentes() {
        ventanaPrincipal.getPanelBotones().getBtnIniciar().addActionListener(this);
        ventanaPrincipal.getPanelBotones().getBtnFinalizar().setActionCommand("fin");

    }

    public void conectar() {
        String seleccionado = getProcesoSeleccionado();
        if (seleccionado == null) {
            return;
        }

        minHeap = Long.MAX_VALUE;
        maxHeap = Long.MIN_VALUE;

        try {
            String url = procesosJvm.obtenerUrlJmx(seleccionado);
            connector.conectarConUrl(url);
            iniciarMonitoreo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void desconectar() {
        detenerMonitoreo();
        try {
            connector.desconectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void iniciarMonitoreo() {
        timer = new Timer(2000, e -> {
            try {
                MemoData data = monitor.leerMemoria();
                javax.swing.SwingUtilities.invokeLater(() -> actualizarVista(data));
            } catch (Exception ex) {                // El proceso murió — detener y avisar en la vista
                detenerMonitoreo();
                javax.swing.SwingUtilities.invokeLater(() -> {
                    ventanaPrincipal.getPanelMonitor().getLblTituloTarea().setText("Conexión perdida");
                    ventanaPrincipal.getPanelMonitor().getLblPorcentaje().setText("—");
                    ventanaPrincipal.getPanelMonitor().getLblMemoriaTotal().setText("Total: —");
                    ventanaPrincipal.getPanelMonitor().getLblMinPorcentaje().setText("Mín: —");
                    ventanaPrincipal.getPanelMonitor().getLblMaxPorcentaje().setText("Máx: —");
                });
            }
        });
        timer.start();
    }

    private void actualizarVista(MemoData data) {
        if (data.getHeapUsed() < minHeap) {
            minHeap = data.getHeapUsed();
        }
        if (data.getHeapUsed() > maxHeap) {
            maxHeap = data.getHeapUsed();
        }
        double porcentaje = (data.getHeapUsed() * 100.0) / data.getHeapMax();
        ventanaPrincipal.getPanelMonitor().getLblTituloTarea().setText(getProcesoSeleccionado());
        ventanaPrincipal.getPanelMonitor().getLblPorcentaje().setText(String.format("%.1f%%", porcentaje));
        ventanaPrincipal.getPanelMonitor().getLblMemoriaTotal().setText(data.getHeapMax() + " MB");
        ventanaPrincipal.getPanelMonitor().getLblMinPorcentaje().setText(minHeap + " MB");
        ventanaPrincipal.getPanelMonitor().getLblMaxPorcentaje().setText(maxHeap + " MB");
    }

    private void detenerMonitoreo() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("iniciar")) {
            conectar();
        }
        if (comando.equals("fin")) {
            desconectar();
        }
    }
}
