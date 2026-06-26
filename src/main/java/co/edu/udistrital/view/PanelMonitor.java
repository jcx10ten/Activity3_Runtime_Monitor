/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author USUARIO
 */
public class PanelMonitor extends JPanel {

    private JLabel lblTituloTarea;
    private JLabel lblPorcentaje;
    private JLabel lblMinPorcentaje;
    private JLabel lblMaxPorcentaje;
    private JLabel lblMemoriaTotal;

    public PanelMonitor() {
        setLayout(new BorderLayout(5, 10));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        inicializarComponentes();
        setVisible(true);

    }

    public void inicializarComponentes() {
        lblTituloTarea = new JLabel("—", JLabel.CENTER);
        lblTituloTarea.setOpaque(true);
        lblTituloTarea.setBackground(new Color(190, 225, 240));
        lblTituloTarea.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));

        lblPorcentaje = new JLabel("0%", JLabel.CENTER);
        lblPorcentaje.setOpaque(true);
        lblPorcentaje.setBackground(new Color(210, 235, 210));
        lblPorcentaje.setFont(lblPorcentaje.getFont().deriveFont(Font.BOLD, 36f));
        lblPorcentaje.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblMemoriaTotal = new JLabel("Total: —", JLabel.CENTER);
        lblMemoriaTotal.setOpaque(true);
        lblMemoriaTotal.setBackground(new Color(210, 235, 210));
        lblMemoriaTotal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblMinPorcentaje = new JLabel("Mín: —", JLabel.CENTER);
        lblMinPorcentaje.setOpaque(true);
        lblMinPorcentaje.setBackground(new Color(210, 235, 210));
        lblMinPorcentaje.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblMaxPorcentaje = new JLabel("Máx: —", JLabel.CENTER);
        lblMaxPorcentaje.setOpaque(true);
        lblMaxPorcentaje.setBackground(new Color(210, 235, 210));
        lblMaxPorcentaje.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelMemoria = new JPanel(new GridLayout(1, 3, 5, 0));
        panelMemoria.setOpaque(false);
        panelMemoria.add(lblMaxPorcentaje);
        panelMemoria.add(lblMinPorcentaje);
        panelMemoria.add(lblMemoriaTotal);

        add(lblTituloTarea, BorderLayout.NORTH);
        add(lblPorcentaje, BorderLayout.CENTER);
        add(panelMemoria, BorderLayout.SOUTH);
    }

    public JLabel getLblTituloTarea() {
        return lblTituloTarea;
    }

    public void setLblTituloTarea(JLabel lblTituloTarea) {
        this.lblTituloTarea = lblTituloTarea;
    }

    public JLabel getLblPorcentaje() {
        return lblPorcentaje;
    }

    public void setLblPorcentaje(JLabel lblPorcentaje) {
        this.lblPorcentaje = lblPorcentaje;
    }

    public JLabel getLblMinPorcentaje() {
        return lblMinPorcentaje;
    }

    public void setLblMinPorcentaje(JLabel lblMinPorcentaje) {
        this.lblMinPorcentaje = lblMinPorcentaje;
    }

    public JLabel getLblMaxPorcentaje() {
        return lblMaxPorcentaje;
    }

    public void setLblMaxPorcentaje(JLabel lblMaxPorcentaje) {
        this.lblMaxPorcentaje = lblMaxPorcentaje;
    }

    public JLabel getLblMemoriaTotal() {
        return lblMemoriaTotal;
    }

    public void setLblMemoriaTotal(JLabel lblMemoriaTotal) {
        this.lblMemoriaTotal = lblMemoriaTotal;
    }

}
