/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ed_terminalautobuses.visitas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/**
 *
 * @author Familiar
 */
public class PanelAsiento extends javax.swing.JPanel {
    
    private boolean[] asientosOcupados = new boolean[21];

    /**
     * Creates new form PanelAsiento
     */
    public PanelAsiento() {
        initComponents();
        
        configurarBotones();
        configurarAparienciaInicial();
    }
    
    private void configurarBotones() {
        // Columna izquierda (1, 5, 9, 13, 17)
        btnAsiento1.addActionListener((ActionEvent e) -> manejarAsiento(1));
        btnAsiento5.addActionListener((ActionEvent e) -> manejarAsiento(5));
        btnAsiento9.addActionListener((ActionEvent e) -> manejarAsiento(9));
        btnAsiento13.addActionListener((ActionEvent e) -> manejarAsiento(13));
        btnAsiento17.addActionListener((ActionEvent e) -> manejarAsiento(17));
        
        // Columna izquierda (2, 6, 10, 14, 18)
        btnAsiento2.addActionListener((ActionEvent e) -> manejarAsiento(2));
        btnAsiento6.addActionListener((ActionEvent e) -> manejarAsiento(6));
        btnAsiento10.addActionListener((ActionEvent e) -> manejarAsiento(10));
        btnAsiento14.addActionListener((ActionEvent e) -> manejarAsiento(14));
        btnAsiento18.addActionListener((ActionEvent e) -> manejarAsiento(18));
        
        // Columna derecha (3, 7, 11, 15, 19)
        btnAsiento3.addActionListener((ActionEvent e) -> manejarAsiento(3));
        btnAsiento7.addActionListener((ActionEvent e) -> manejarAsiento(7));
        btnAsiento11.addActionListener((ActionEvent e) -> manejarAsiento(11));
        btnAsiento15.addActionListener((ActionEvent e) -> manejarAsiento(15));
        btnAsiento19.addActionListener((ActionEvent e) -> manejarAsiento(19));
        
        // Columna derecha (4, 8, 12, 16, 20)
        btnAsiento4.addActionListener((ActionEvent e) -> manejarAsiento(4));
        btnAsiento8.addActionListener((ActionEvent e) -> manejarAsiento(8));
        btnAsiento12.addActionListener((ActionEvent e) -> manejarAsiento(12));
        btnAsiento16.addActionListener((ActionEvent e) -> manejarAsiento(16));
        btnAsiento20.addActionListener((ActionEvent e) -> manejarAsiento(20));
    }
    
    // 2. Manejar clic en asiento
    private void manejarAsiento(int numero) {
        if (!asientosOcupados[numero]) {
            // Mostrar mensaje (aquí después conectarás con DialogVenta)
            JOptionPane.showMessageDialog(this,
                "Seleccionaste el asiento #" + numero,
                "Selección de Asiento",
                JOptionPane.INFORMATION_MESSAGE);
            
            // Cambiar a ocupado
            asientosOcupados[numero] = true;
            actualizarBoton(numero);
        } else {
            JOptionPane.showMessageDialog(this,
                "El asiento #" + numero + " ya está ocupado",
                "Asiento no disponible",
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // 3. Actualizar apariencia de un botón específico
    private void actualizarBoton(int numero) {
        JButton boton = obtenerBotonPorNumero(numero);
        if (boton != null) {
            if (asientosOcupados[numero]) {
                boton.setBackground(Color.RED);
                boton.setForeground(Color.WHITE);
                boton.setText(numero + " (O)");
            } else {
                boton.setBackground(Color.GREEN);
                boton.setForeground(Color.BLACK);
                boton.setText(String.valueOf(numero));
            }
        }
    }
    
    // 4. Obtener botón por número
    private JButton obtenerBotonPorNumero(int numero) {
        switch (numero) {
            case 1: return btnAsiento1;
            case 2: return btnAsiento2;
            case 3: return btnAsiento3;
            case 4: return btnAsiento4;
            case 5: return btnAsiento5;
            case 6: return btnAsiento6;
            case 7: return btnAsiento7;
            case 8: return btnAsiento8;
            case 9: return btnAsiento9;
            case 10: return btnAsiento10;
            case 11: return btnAsiento11;
            case 12: return btnAsiento12;
            case 13: return btnAsiento13;
            case 14: return btnAsiento14;
            case 15: return btnAsiento15;
            case 16: return btnAsiento16;
            case 17: return btnAsiento17;
            case 18: return btnAsiento18;
            case 19: return btnAsiento19;
            case 20: return btnAsiento20;
            default: return null;
        }
    }
    
    // 5. Configurar apariencia inicial
    private void configurarAparienciaInicial() {
        // Hacer todos los botones verdes inicialmente
        JButton[] todosBotones = {
            btnAsiento1, btnAsiento2, btnAsiento3, btnAsiento4,
            btnAsiento5, btnAsiento6, btnAsiento7, btnAsiento8,
            btnAsiento9, btnAsiento10, btnAsiento11, btnAsiento12,
            btnAsiento13, btnAsiento14, btnAsiento15, btnAsiento16,
            btnAsiento17, btnAsiento18, btnAsiento19, btnAsiento20
        };
        
        for (JButton boton : todosBotones) {
            boton.setBackground(Color.GREEN);
            boton.setForeground(Color.BLACK);
        }
    }
    
    // 6. Métodos públicos para que VentanaPrincipal los use
    
    public void ocuparAsiento(int numero) {
        if (numero >= 1 && numero <= 20) {
            asientosOcupados[numero] = true;
            actualizarBoton(numero);
        }
    }
    
    public void liberarAsiento(int numero) {
        if (numero >= 1 && numero <= 20) {
            asientosOcupados[numero] = false;
            actualizarBoton(numero);
        }
    }
    
    public boolean estaOcupado(int numero) {
        if (numero >= 1 && numero <= 20) {
            return asientosOcupados[numero];
        }
        return false;
    }
    
    public int getAsientosDisponibles() {
        int count = 0;
        for (int i = 1; i <= 20; i++) {
            if (!asientosOcupados[i]) count++;
        }
        return count;
    }
    
    public void liberarTodosAsientos() {
        for (int i = 1; i <= 20; i++) {
            asientosOcupados[i] = false;
            actualizarBoton(i);
        }}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAsiento1 = new javax.swing.JButton();
        btnAsiento2 = new javax.swing.JButton();
        btnAsiento3 = new javax.swing.JButton();
        btnAsiento4 = new javax.swing.JButton();
        btnAsiento5 = new javax.swing.JButton();
        btnAsiento6 = new javax.swing.JButton();
        btnAsiento7 = new javax.swing.JButton();
        btnAsiento8 = new javax.swing.JButton();
        btnAsiento9 = new javax.swing.JButton();
        btnAsiento10 = new javax.swing.JButton();
        btnAsiento11 = new javax.swing.JButton();
        btnAsiento12 = new javax.swing.JButton();
        btnAsiento13 = new javax.swing.JButton();
        btnAsiento14 = new javax.swing.JButton();
        btnAsiento15 = new javax.swing.JButton();
        btnAsiento16 = new javax.swing.JButton();
        btnAsiento17 = new javax.swing.JButton();
        btnAsiento18 = new javax.swing.JButton();
        btnAsiento19 = new javax.swing.JButton();
        btnAsiento20 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        btnAsiento1.setText("1");

        btnAsiento2.setText("2");
        btnAsiento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsiento2ActionPerformed(evt);
            }
        });

        btnAsiento3.setText("3");

        btnAsiento4.setText("4");

        btnAsiento5.setText("5");

        btnAsiento6.setText("6");

        btnAsiento7.setText("7");

        btnAsiento8.setText("8");

        btnAsiento9.setText("9");

        btnAsiento10.setText("10");

        btnAsiento11.setText("11");

        btnAsiento12.setText("12");

        btnAsiento13.setText("13");

        btnAsiento14.setText("14");

        btnAsiento15.setText("15");

        btnAsiento16.setText("16");

        btnAsiento17.setText("17");

        btnAsiento18.setText("18");

        btnAsiento19.setText("19");

        btnAsiento20.setText("20");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAsiento17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAsiento18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAsiento13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsiento9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsiento5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsiento1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAsiento10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsiento14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsiento6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsiento2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAsiento19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAsiento20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAsiento15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAsiento16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAsiento11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsiento7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsiento3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAsiento12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsiento8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsiento4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsiento1)
                    .addComponent(btnAsiento2)
                    .addComponent(btnAsiento3)
                    .addComponent(btnAsiento4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsiento5)
                    .addComponent(btnAsiento6)
                    .addComponent(btnAsiento7)
                    .addComponent(btnAsiento8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsiento9)
                    .addComponent(btnAsiento10)
                    .addComponent(btnAsiento11)
                    .addComponent(btnAsiento12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsiento13)
                    .addComponent(btnAsiento14)
                    .addComponent(btnAsiento15)
                    .addComponent(btnAsiento16))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsiento17)
                    .addComponent(btnAsiento18)
                    .addComponent(btnAsiento19)
                    .addComponent(btnAsiento20))
                .addContainerGap(300, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsiento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsiento2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsiento2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsiento1;
    private javax.swing.JButton btnAsiento10;
    private javax.swing.JButton btnAsiento11;
    private javax.swing.JButton btnAsiento12;
    private javax.swing.JButton btnAsiento13;
    private javax.swing.JButton btnAsiento14;
    private javax.swing.JButton btnAsiento15;
    private javax.swing.JButton btnAsiento16;
    private javax.swing.JButton btnAsiento17;
    private javax.swing.JButton btnAsiento18;
    private javax.swing.JButton btnAsiento19;
    private javax.swing.JButton btnAsiento2;
    private javax.swing.JButton btnAsiento20;
    private javax.swing.JButton btnAsiento3;
    private javax.swing.JButton btnAsiento4;
    private javax.swing.JButton btnAsiento5;
    private javax.swing.JButton btnAsiento6;
    private javax.swing.JButton btnAsiento7;
    private javax.swing.JButton btnAsiento8;
    private javax.swing.JButton btnAsiento9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
