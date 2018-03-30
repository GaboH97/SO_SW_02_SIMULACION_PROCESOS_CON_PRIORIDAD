package views;

import controller.Actions;
import controller.Controller;
import javax.swing.JOptionPane;
import logic.ProcessManager;
import logic.Process;

/**
 * Clase que representa una ventana de diálogo mediante la cual el usuario puede
 * crear procesos
 *
 * @author Gabriel Amaya y Cesar Cardozo
 */
public class AddProcessDialog extends javax.swing.JDialog {

    //--------------------- Constructores ----------------
    
    public AddProcessDialog(java.awt.Frame parent, boolean modal, Controller controller) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        //Define los comando de la acción y el escucha de acciones
        createbtn.setActionCommand(Actions.CREATE_PROCESS.name());
        createbtn.addActionListener(controller);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    //------------------- Métodos ------------------------
    /**
     * Limpia los campos a sus valores por defecto
     */
    private void clearFields() {
        this.processNamejtf.setText("");
        this.executionTimejtf.setText("");
        this.isLockjcb.setSelected(false);
    }

    /**
     * Crea un nuevo proceso
     * 
     * @return Una instancia de la clase Proceso
     */
    public Process createProcess() {
        Process process = null;
        String timeInput = executionTimejtf.getText();
        //Verifica que los campos no estén vacíos
        if (!processNamejtf.getText().isEmpty() && !timeInput.isEmpty()) {
            //Verifica que la entrada del tiempo de ejecución sea válida
            if (isNumeric(executionTimejtf.getText())) {
                //Hace una llamada del método estático de la lógica para crear
                //una nueva instancia de la clase Proceso
                process = ProcessManager.createProcess(processNamejtf.getText(), Double.parseDouble(timeInput), isLockjcb.isSelected());
            } else {
                JOptionPane.showMessageDialog(this,
                        GUIUtils.MSG_INVALID_TIME,
                        GUIUtils.APP_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return process;
    }

    /**
     * Verifica si una cadena de texto corresponde a un número decimal positivo
     * 
     * @param str Una cadena de caracteres
     * @return true si la cadena de caracteres encaja con la expresión regular
     *         para un número decimal positivo
     */
    public boolean isNumeric(String str) {
        return str!=null && (str.matches("[+]?\\d*(\\.\\d+)?") && str.equals("") == false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        processNamejtf = new javax.swing.JTextField();
        executionTimejtf = new javax.swing.JTextField();
        isLockjcb = new javax.swing.JCheckBox();
        createbtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Proceso");

        jLabel2.setText("Nombre del Proceso");

        jLabel3.setText("Tiempo de Ejecución");

        isLockjcb.setText("¿Está Bloqueado?");
        isLockjcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isLockjcbActionPerformed(evt);
            }
        });

        createbtn.setText("Crear");

        cancelbtn.setText("Cancelar");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(isLockjcb)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(processNamejtf, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(executionTimejtf, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(createbtn)
                                .addGap(18, 18, 18)
                                .addComponent(cancelbtn)))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(processNamejtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(executionTimejtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(isLockjcb)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createbtn)
                    .addComponent(cancelbtn))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Limpia los campos y desaparece la ventana
     *
     * @param evt Evento generado
     */
    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        clearFields();
        setVisible(false);
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void isLockjcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isLockjcbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isLockjcbActionPerformed

    /**
     * Limpia los campos y desaparece la ventana
     */
    public void close() {
        clearFields();
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbtn;
    private javax.swing.JButton createbtn;
    private javax.swing.JTextField executionTimejtf;
    private javax.swing.JCheckBox isLockjcb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField processNamejtf;
    // End of variables declaration//GEN-END:variables
}
