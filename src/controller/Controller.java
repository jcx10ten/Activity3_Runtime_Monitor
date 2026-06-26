/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.JvmConnector;
import model.MemoData;
import model.MemoMonitor;
import javax.swing.Timer;

public class Controller {
    private JvmConnector connector;
    private MemoMonitor monitor;
    private Timer timer;

    public Controller() {
        this.connector = new JvmConnector();
        this.monitor = new MemoMonitor(connector);
    }

    public void conectar() {
    //    String host = vista.getHost();
    //    int port = vista.getPort();

        try {
            connector.conectar(host, port);
       //     vista.mostrarMensaje("Conectado a " + host + ":" + port);
            iniciarMonitoreo();
        } catch (Exception e) {
      //      vista.mostrarError("No se pudo conectar: " + e.getMessage());
        }
    }

    public void desconectar() {
        detenerMonitoreo();
        try {
            connector.desconectar();
      //      vista.mostrarMensaje("Desconectado.");
        } catch (Exception e) {
      //      vista.mostrarError("Error al desconectar: " + e.getMessage());
        }
    }

    private void iniciarMonitoreo() {
        timer = new Timer(2000, e -> {
            try {
                MemoData data = monitor.leerMemoria();
           //     vista.agregarFila(data);
            } catch (Exception ex) {
                detenerMonitoreo();
        //        vista.mostrarError("Se perdió la conexión: " + ex.getMessage());
            }
        });
        timer.start();
    }

    private void detenerMonitoreo() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }
}
