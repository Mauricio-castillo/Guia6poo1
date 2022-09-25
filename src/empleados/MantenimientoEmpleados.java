package empleados;

import sv.edu.ujmd.util.Conexion;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sv.edu.ujmd.util.CheckPassword;

public class MantenimientoEmpleados extends javax.swing.JInternalFrame {

    ResultSet empleados;
    ResultSet llenarcombo;
    public static int bandera = 0;
    Conexion con = new Conexion();

    public MantenimientoEmpleados() throws SQLException {
        initComponents();
        //permite inicializar valores
        iniciarValores();
    }

    public void iniciarValores() throws SQLException {
        con.setRs("Select * from usuarios");
        //atributo resultset obtiene los valores de la clase conexion

        //devuealtos por el metodo getRs()
        empleados = (ResultSet) con.GetRs();

        //nos permite ir al ultimo registro
        empleados.last();

        //nos permite volver al registro inicial
        empleados.beforeFirst();

        //movemos al primer registro
        empleados.next();

        //creacion del objeto con2 que permite llenar con valores
        //el Jcomboboc y tambien para el ingreso de datos
        Conexion con2 = new Conexion();

        //obtenemos todos los campos de la tabla tipo_usuarios
        con2.setRs("Select * from tipo_usuarios");

        cmbtipousuario.removeAllItems();
        //atributo resultset que obtiene los valores de la clase conexion

        //devueltos por el metodo getRs()
        llenarcombo = (ResultSet) con2.GetRs();

        while (llenarcombo.next()) {
            //agregamos los item de los tipos de usuarios que se encuentran en el campo 2
            cmbtipousuario.addItem(llenarcombo.getString(2));
        }

        con2.cerrarConexion();
        llenartxtbox();
        btnanterior.setEnabled(false);
        btnsiguiente.setEnabled(true);
    }

    private void siguiente() throws SQLException {
        //si el cursor no esta despues del ultimo registro se podra mover al siguiente
        if (empleados.isAfterLast() == false) {
            btnanterior.setEnabled(true);
            empleados.next();
            llenartxtbox();
        } else {
            //si estamos despues del ultimo registro desactivaremos el boton y regresaremos al ultimo registro valido
            JOptionPane.showMessageDialog(this, "Ya no existen mas registros para recorrer");
            empleados.previous();
            btnsiguiente.setEnabled(false);
        }
    }

    private void anterior() throws SQLException {
        //si el cursor no esta antes del ultimo registro se podra mover al anterior
        if (empleados.isBeforeFirst() == false) {
            btnsiguiente.setEnabled(true);
            empleados.previous();
            llenartxtbox();
        }
    }

    private void limpiarText() {
        txtid.setText("");
        txtnombres.setText("");
        txtapellidos.setText("");
        txtedad.setText("");
        txtnombreusuario.setText("");
        cmbtipousuario.setSelectedIndex(0);
        txtpassword.setText("");
    }

    private void llenartxtbox() throws SQLException {
        txtid.setText(String.valueOf(empleados.getInt(1)));
        txtnombres.setText(String.valueOf(empleados.getString(2)));
        txtapellidos.setText(String.valueOf(empleados.getString(3)));
        txtedad.setText(String.valueOf(empleados.getInt(4)));
        cmbtipousuario.setSelectedIndex(empleados.getInt(5));
        txtnombreusuario.setText(String.valueOf(empleados.getString(6)));
        txtpassword.setText(String.valueOf(empleados.getString(7)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtedad = new javax.swing.JTextField();
        txtnombreusuario = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        cmbtipousuario = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btningresar = new javax.swing.JButton();
        btnanterior = new javax.swing.JButton();
        btnsiguiente = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion de empleados"));

        jLabel1.setText("ID");

        jLabel2.setText("Ingrese los nombres");

        jLabel3.setText("Ingrese los apellidos");

        jLabel4.setText("Ingrese la edad");

        jLabel5.setText("Nombre de usuario");

        jLabel6.setText("Password");

        jLabel7.setText("Tipo de usuarios");

        txtedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombreusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(txtpassword)
                            .addComponent(cmbtipousuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtnombreusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbtipousuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

        btningresar.setText("Ingresar");
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });

        btnanterior.setText("Anterior");
        btnanterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanteriorActionPerformed(evt);
            }
        });

        btnsiguiente.setText("Siguiente");
        btnsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsiguienteActionPerformed(evt);
            }
        });

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btningresar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnsiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btningresar)
                    .addComponent(btnanterior)
                    .addComponent(btnsiguiente)
                    .addComponent(btnlimpiar)
                    .addComponent(btneliminar)
                    .addComponent(btnmodificar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnanteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanteriorActionPerformed
        try {
            anterior();
        } catch (SQLException ex) {
            try {
                anterior();
            } catch (SQLException ex1) {
                Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }//GEN-LAST:event_btnanteriorActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiarText();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguienteActionPerformed
        try {
            siguiente();
        } catch (SQLException ex) {
            try {
                siguiente();
            } catch (SQLException ex1) {
                Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }//GEN-LAST:event_btnsiguienteActionPerformed

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        try {
            if (btningresar.getText().equals("Ingresar")) {
                btningresar.setText("Guardar");
                btnanterior.setEnabled(false);
                btnsiguiente.setEnabled(false);
                //limpiarText(); 
            } else {
                Conexion con2 = new Conexion();

                CheckPassword verificar = new CheckPassword();
                char passArray[] = txtpassword.getPassword();

                if (verificar.verificarPassword(passArray)) {
                    String password = new String(txtpassword.getPassword());
                    con2.setQuery("Insert into usuarios values("
                            + Integer.parseInt(txtid.getText())
                            + ",\"" + txtnombres.getText() + "\",\""
                            + txtapellidos.getText() + "\","
                            + Integer.parseInt(txtedad.getText()) + ","
                            + cmbtipousuario.getSelectedIndex() + ",\""
                            + txtnombreusuario.getText()
                            + "\",\"" + password + "\")");
                    con2.cerrarConexion();
                    btningresar.setText("Ingresar");
                    JOptionPane.showMessageDialog(this, "Usuario Ingresado Exitosamente");
                    limpiarText();
                    con2.cerrarConexion();
                    iniciarValores();
                } else {
                    JOptionPane.showMessageDialog(this, "El passwor Contiene Caracteres Invalidos");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btningresarActionPerformed

    private void txtedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtedadKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtedadKeyTyped

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        try {
            bandera = 0;
            this.dispose();
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        try {
            if (!txtid.getText().equals("")) {
                int id = Integer.parseInt(txtid.getText());
                Conexion cone = new Conexion();
                cone.setQuery("delete from usuarios where id_usuario = " + id);
                cone.cerrarConexion();
                JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente");
                limpiarText();
                iniciarValores();
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese el ID primero papa");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR SQL: " + ex.getMessage());
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        try {
            if (!txtid.getText().equals("")) {
                int id = Integer.parseInt(txtid.getText());
                Conexion cone = new Conexion();

                if (!txtnombres.getText().equals("") && !txtapellidos.getText().equals("") && !txtedad.getText().equals("") && !txtnombreusuario.getText().equals("") && !txtpassword.getText().equals("")) {
                    cone.setQuery("update usuarios set  nombres = '" + txtnombres.getText() + "', apellidos = '" + txtapellidos.getText() + "', edad = " + Integer.parseInt(txtedad.getText())
                            + ", usuario = '" + txtnombreusuario.getText() + "', password = '" + txtpassword.getText() + "' where id_usuario = " + id);
                } else if (txtnombres.getText().equals("") && !txtapellidos.getText().equals("") && !txtedad.getText().equals("") && !txtnombreusuario.getText().equals("") && !txtpassword.getText().equals("")) {
                    cone.setQuery("update usuarios set apellidos = '" + txtapellidos + "', edad = " + Integer.parseInt(txtedad.getText())
                            + ", usuario = '" + txtnombreusuario.getText() + "', password = '" + txtpassword.getText() + "' where id_usuario = " + id);
                } else if (!txtnombres.getText().equals("") && txtapellidos.getText().equals("") && !txtedad.getText().equals("") && !txtnombreusuario.getText().equals("") && !txtpassword.getText().equals("")) {
                    cone.setQuery("update usuarios set  nombres = '" + txtnombres.getText() + "', edad = " + Integer.parseInt(txtedad.getText())
                            + ", usuario = '" + txtnombreusuario.getText() + "', password = '" + txtpassword.getText() + "' where id_usuario = " + id);
                } else if (!txtnombres.getText().equals("") && !txtapellidos.getText().equals("") && txtedad.getText().equals("") && !txtnombreusuario.getText().equals("") && !txtpassword.getText().equals("")) {
                    cone.setQuery("update usuarios set  nombres = '" + txtnombres.getText() + "', apellidos = '" + txtapellidos + "', usuario = '" + txtnombreusuario.getText()
                            + "', password = '" + txtpassword.getText() + "' where id_usuario = " + id);
                } else if (!txtnombres.getText().equals("") && !txtapellidos.getText().equals("") && !txtedad.getText().equals("") && txtnombreusuario.getText().equals("") && !txtpassword.getText().equals("")) {
                    cone.setQuery("update usuarios set  nombres = '" + txtnombres.getText() + "', apellidos = '" + txtapellidos + "', edad = " + Integer.parseInt(txtedad.getText())
                            + ", password = '" + txtpassword.getText() + "' where id_usuario = " + id);
                } else if (!txtnombres.getText().equals("") && !txtapellidos.getText().equals("") && !txtedad.getText().equals("") && !txtnombreusuario.getText().equals("") && txtpassword.getText().equals("")) {
                    cone.setQuery("update usuarios set  nombres = '" + txtnombres.getText() + "', apellidos = '" + txtapellidos + "', edad = " + Integer.parseInt(txtedad.getText())
                            + ", usuario = '" + txtnombreusuario.getText() + "' where id_usuario = " + id);
                } else if (!txtnombres.getText().equals("") && txtapellidos.getText().equals("") && txtedad.getText().equals("") && txtnombreusuario.getText().equals("") && txtpassword.getText().equals("")) {
                    cone.setQuery("update usuarios set  nombres = '" + txtnombres.getText() + " where id_usuario = " + id);
                } else if (txtnombres.getText().equals("") && !txtapellidos.getText().equals("") && txtedad.getText().equals("") && txtnombreusuario.getText().equals("") && txtpassword.getText().equals("")) {
                    cone.setQuery("update usuarios set apellidos = '" + txtapellidos + "' where id_usuario = " + id);
                } else if (txtnombres.getText().equals("") && txtapellidos.getText().equals("") && !txtedad.getText().equals("") && txtnombreusuario.getText().equals("") && txtpassword.getText().equals("")) {
                    cone.setQuery("update usuarios set edad = " + Integer.parseInt(txtedad.getText()) + "' where id_usuario = " + id);
                } else if (txtnombres.getText().equals("") && txtapellidos.getText().equals("") && txtedad.getText().equals("") && !txtnombreusuario.getText().equals("") && txtpassword.getText().equals("")) {
                    cone.setQuery("update usuarios set usuario = '" + txtnombreusuario.getText() + "' where id_usuario = " + id);
                } else if (txtnombres.getText().equals("") && txtapellidos.getText().equals("") && txtedad.getText().equals("") && txtnombreusuario.getText().equals("") && !txtpassword.getText().equals("")) {
                    cone.setQuery("update usuarios set password = '" + txtpassword.getText() + "' where id_usuario = " + id);
                }
                cone.cerrarConexion();
                JOptionPane.showMessageDialog(this, "Usuario modificado exitosamente exitosamente");
                limpiarText();
                iniciarValores();
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese el ID primero papa");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR SQL: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnmodificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnanterior;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnsiguiente;
    private javax.swing.JComboBox<String> cmbtipousuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txtnombreusuario;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
