/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udsitrital.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class VentanaPrincipal extends JFrame {
    
    private PanelBotones panelBotones;
    private PanelMonitor panelMonitor;

    public VentanaPrincipal() {
        
         setTitle("Runtime Monitor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().setBackground(Color.GRAY);
        getContentPane().setLayout(new BorderLayout(10, 10));
        ((JComponent) getContentPane()).setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        inicializarComponentes();
    
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true); 
    }
    
    public void inicializarComponentes() {
        
        panelBotones = new PanelBotones();
        getContentPane().add(panelBotones, BorderLayout.WEST);
        panelMonitor = new PanelMonitor();
        getContentPane().add(panelMonitor, BorderLayout.CENTER);
        
    }

    public PanelBotones getPanelBotones() {
        return panelBotones;
    }

    public void setPanelBotones(PanelBotones panelBotones) {
        this.panelBotones = panelBotones;
    }

    public PanelMonitor getPanelMonitor() {
        return panelMonitor;
    }

    public void setPanelMonitor(PanelMonitor panelMonitor) {
        this.panelMonitor = panelMonitor;
    }
    
    
    
}
