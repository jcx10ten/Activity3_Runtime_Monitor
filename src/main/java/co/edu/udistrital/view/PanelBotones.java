/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author USUARIO
 */
public class PanelBotones extends JPanel {

    private JLabel lblTitulo;
    private JButton btnIniciar;
    private JButton btnFinalizar;
    private JComboBox<String> comboProcesos;
    private DefaultComboBoxModel<String> modeloComboProcesos;

    public PanelBotones() {
        setLayout(new BorderLayout(5, 8));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        inicializarComponentes();
        setVisible(true);

    }

    public void inicializarComponentes() {

        lblTitulo = new JLabel("Runtime Monitor", JLabel.CENTER);
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(210, 210, 210));
        lblTitulo.setForeground(new Color(50, 50, 50));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));

        modeloComboProcesos = new DefaultComboBoxModel<>();
        comboProcesos = new JComboBox<>(modeloComboProcesos);
        comboProcesos.setBackground(Color.WHITE);
        comboProcesos.setPreferredSize(new Dimension(400, 25));
        JPanel pCombo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 150));
        pCombo.setOpaque(false);
        pCombo.add(comboProcesos);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.setBackground(new Color(100, 100, 100));
        btnIniciar.setForeground(Color.WHITE);
        btnIniciar.setPreferredSize(new Dimension(180, 25));

        btnFinalizar = new JButton("Finalizar");
        btnFinalizar.setBackground(new Color(230, 200, 185));
        btnFinalizar.setForeground(new Color(80, 50, 30));
        btnFinalizar.setPreferredSize(new Dimension(180, 25));
        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBtn.setOpaque(false);
        panelBtn.add(btnIniciar);
        panelBtn.add(btnFinalizar);

        JPanel panelCentral = new JPanel(new GridLayout(2, 1, 5, 50));
        panelCentral.setOpaque(false);
        panelCentral.add(pCombo);
        panelCentral.add(panelBtn);

        add(lblTitulo, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }

    public void setBtnIniciar(JButton btnIniciar) {
        this.btnIniciar = btnIniciar;
    }

    public JButton getBtnFinalizar() {
        return btnFinalizar;
    }

    public void setBtnFinalizar(JButton btnFinalizar) {
        this.btnFinalizar = btnFinalizar;
    }

    public JComboBox<String> getComboProcesos() {
        return comboProcesos;
    }

    public void setComboProcesos(JComboBox<String> comboProcesos) {
        this.comboProcesos = comboProcesos;
    }

    public DefaultComboBoxModel<String> getModeloComboProcesos() {
        return modeloComboProcesos;
    }

    public void setModeloComboProcesos(DefaultComboBoxModel<String> modeloComboProcesos) {
        this.modeloComboProcesos = modeloComboProcesos;
    }

}
