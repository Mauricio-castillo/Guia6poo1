/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import mdi.MDI_Form;
import sv.edu.ujmd.util.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sv.edu.ujmd.util.CheckPassword;

public class Logueo extends javax.swing.JFrame {

    public Logueo() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btningresar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        txtpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese su Nombre");

        jLabel2.setText("Ingrese su Password");

        jLabel3.setText("INICIO DE SESIÓN");

        btningresar.setText("Ingresar");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btningresar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnombre)
                                    .addComponent(txtpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btningresar)
                    .addComponent(btnlimpiar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        String id_tipo = "";
        String usuario = "";
        String pass = "";
        try{
            CheckPassword verificar = new CheckPassword();
            char passArray[] = txtpassword.getPassword();
            if(verificar.verificarPassword(passArray)){
                String pas = new String(passArray);
                //creando objeto de conexion
                Conexion con = new Conexion();
                //consulta
                con.setRs("select id_tipo_usuario, usuario, password from usuarios where usuario = '" + txtnombre.getText() + "'");
                //se obtienen los valores
                ResultSet valor = (ResultSet) con.GetRs();
                //Se mueve al unico registro devuelto
                valor.next();
                //se obtiene el id del tipo de usuario
                id_tipo = valor.getString(1);
                //se obtiene el usuario
                usuario = valor.getString(2);
                //se obtiene el password
                pass = valor.getString(3);
                
                System.out.println("Password: " + pas + " " + pass);
                System.out.println("Usuario: " + txtnombre.getText() + " " + usuario);
                //se verifica que el usuario y el password de la base son iguales a los que se ingresaron
                if(txtnombre.getText().equals(usuario) && pas.equals(pass)){
                    //si el usuario es tipo administrador
                    System.out.println("Id: " + id_tipo);
                    if(id_tipo.equals("0")){
                        new MDI_Form().setVisible(true);
                        this.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Usted es un empleado");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Usuario o Password incorrecto");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "El password contiene caracteres invalidos");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Logueo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btningresarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        txtnombre.setText("");
        txtpassword.setText("");
    }//GEN-LAST:event_btnlimpiarActionPerformed

    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logueo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
