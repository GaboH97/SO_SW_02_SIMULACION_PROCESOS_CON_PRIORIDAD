package views;

import controller.Actions;
import controller.Controller;
import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import logic.Process;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static views.GUIUtils.APP_TITLE;

/**
 * Esta clase representa la GUI principal sobre la cual el usuario realizará la
 * mayoría de las operaciones, podrá visualizar los procesos creados, iniciar la
 * ejecución de los procesos y visualizar las tablas de Procesos E/S, Estados y
 * transiciones
 *
 * @author Gabriel Huertas y Cesar Cardozo
 */
public class MainWindow extends javax.swing.JFrame {

    //---------------------- Attributes -------------------------------
    /**
     * Modelo de tabla utilizado para manipular la tabla
     */
    private DefaultTableModel tableModel;

    //---------------------- Constructores -------------------------
    /**
     * Crea una nueva instancia de MainWindow
     *
     * @param controller referencia al controlador que manejará los eventos
     */
    public MainWindow(Controller controller) {
        tableModel = new DefaultTableModel(GUIUtils.ADD_PROCESSES_TABLE_HEADERS, 0);
        this.setTitle(APP_TITLE);
        this.setUndecorated(true);
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setActions(controller);
        showOptions(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //-------------------------- Métodos ---------------------------

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        createProcessbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        startbtn = new javax.swing.JButton();
        processesESbtn = new javax.swing.JButton();
        statesbtn = new javax.swing.JButton();
        transitionsbtn = new javax.swing.JButton();
        eventsbtn = new javax.swing.JButton();
        processesbtn = new javax.swing.JButton();
        menulbl = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        tableHeaderlbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        defineQuantumjmi = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        checkManualjmi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        createProcessbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        createProcessbtn.setText("Crear Proceso");

        exitbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        exitbtn.setText("Salir");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        startbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        startbtn.setText("Iniciar");

        processesESbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        processesESbtn.setText("Procesos E/S");

        statesbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        statesbtn.setText("Estados");

        transitionsbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        transitionsbtn.setText("Transiciones");

        eventsbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        eventsbtn.setText("Eventos");

        processesbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        processesbtn.setText("Procesos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statesbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(processesESbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transitionsbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eventsbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(processesbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(createProcessbtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createProcessbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(processesbtn)
                .addGap(18, 18, 18)
                .addComponent(processesESbtn)
                .addGap(18, 18, 18)
                .addComponent(statesbtn)
                .addGap(18, 18, 18)
                .addComponent(transitionsbtn)
                .addGap(18, 18, 18)
                .addComponent(eventsbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitbtn)
                .addContainerGap())
        );

        menulbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        menulbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menulbl.setText("Menú");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(menulbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(menulbl)
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tableHeaderlbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tableHeaderlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tableHeaderlbl.setText("Procesos Agregados");

        resultsTable.setModel(tableModel);
        jScrollPane1.setViewportView(resultsTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(tableHeaderlbl, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableHeaderlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
        );

        jMenu1.setText("Configuración");

        defineQuantumjmi.setText("Definir Quantum");
        jMenu1.add(defineQuantumjmi);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        checkManualjmi.setText("Ver Manual");
        checkManualjmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkManualjmiActionPerformed(evt);
            }
        });
        jMenu2.add(checkManualjmi);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Define el comando de acción para cada botón utilizado y agrega como
     * escuchador de eventos a la referencia de la clase Controller
     *
     * @param controller Referencia al manejador de eventos
     */
    private void setActions(Controller controller) {
        createProcessbtn.setActionCommand(Actions.OPEN_CREATE_PROCESS.name());
        createProcessbtn.addActionListener(controller);
        startbtn.setActionCommand(Actions.START.name());
        startbtn.addActionListener(controller);
        processesbtn.setActionCommand(Actions.SHOW_SORTED_PROCESSES.name());
        processesbtn.addActionListener(controller);
        processesESbtn.setActionCommand(Actions.SHOW_IO_PROCESSES.name());
        processesESbtn.addActionListener(controller);
        transitionsbtn.setActionCommand(Actions.SHOW_STATES_TRANSITIONS.name());
        transitionsbtn.addActionListener(controller);
        statesbtn.setActionCommand(Actions.SHOW_STATES.name());
        statesbtn.addActionListener(controller);
        eventsbtn.setActionCommand(Actions.SHOW_PROCESSES_EVENTS.name());
        eventsbtn.addActionListener(controller);
        defineQuantumjmi.setActionCommand(Actions.OPEN_DEFINE_QUANTUM.name());
        defineQuantumjmi.addActionListener(controller);
    }

    /**
     * Elimina todos los valores de la tabla sin sus encabezados
     */
    private void clearTable() {
        tableModel.getDataVector().removeAllElements();
    }

    /**
     * Agrega un nuevo proceso a la tabla
     *
     * @param p El proceso a agregar a la tabla
     */
    public void addProcess(Process p) {
        //Define el número de filas como el número de filas actual + 1, esto para
        //Dar espacio para agregar el proceso
        tableModel.setRowCount(tableModel.getRowCount() + 1);
        //Agrega los datos del proceso en las columnas correspondientes
        tableModel.setValueAt(p.getName(), tableModel.getRowCount() - 1, 0);
        tableModel.setValueAt(p.getOldexecutionTime(), tableModel.getRowCount() - 1, 1);
        tableModel.setValueAt(p.getOldPriority(), tableModel.getRowCount() - 1, 2);
        tableModel.setValueAt((p.isIsLock()) ? "Sí" : "No", tableModel.getRowCount() - 1, 3);
        tableModel.setValueAt((p.isDestruct()) ? "Sí" : "No", tableModel.getRowCount() - 1, 4);
        tableModel.setValueAt((p.isDoesComunicate()) ? "Sí" : "No", tableModel.getRowCount() - 1, 5);
        tableModel.setValueAt((p.getPriority() == p.getOldPriority()) ? "" : p.getPriority(), tableModel.getRowCount() - 1, 6);

        this.repaint();
    }

    /**
     * Finaliza la ejecución del programa cerrando la ventana y liberando
     * recursos
     *
     * @param evt Evento causado
     */
    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void checkManualjmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkManualjmiActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("./Manual_de_Usuario.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir el PDF desde la aplicación. Lo puede encontrar en la" + ""
                        + " \n carpeta SO_SW_02_SIMULACION_PROCESOS_CON_PRIORIDAD ",
                        APP_TITLE,
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_checkManualjmiActionPerformed

    /**
     * Muestra las opciones en el menú de acuerdo a
     *
     * @param isInitial Bandera que indica si la ventana se muestra con opciones
     * iniciales o con las opciones disponibles después de iniciar la ejecución
     * de los procesos
     */
    public void showOptions(boolean isInitial) {
        createProcessbtn.setVisible(isInitial);
        startbtn.setVisible(isInitial);
        processesESbtn.setVisible(!isInitial);
        statesbtn.setVisible(!isInitial);
        transitionsbtn.setVisible(!isInitial);
        eventsbtn.setVisible(!isInitial);
        processesbtn.setVisible(!isInitial);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem checkManualjmi;
    private javax.swing.JButton createProcessbtn;
    private javax.swing.JMenuItem defineQuantumjmi;
    private javax.swing.JButton eventsbtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel menulbl;
    private javax.swing.JButton processesESbtn;
    private javax.swing.JButton processesbtn;
    private javax.swing.JTable resultsTable;
    private javax.swing.JButton startbtn;
    private javax.swing.JButton statesbtn;
    private javax.swing.JLabel tableHeaderlbl;
    private javax.swing.JButton transitionsbtn;
    // End of variables declaration//GEN-END:variables

    /**
     * Muestra los procesos de entrada y de salida en una tabla
     *
     * @param inputProcessList Lista de procesos de entrada
     * @param outputProcessList Lista de Procesos de salida
     */
    public void showIOProcesses(ArrayList<Process> inputProcessList, ArrayList<Process> outputProcessList) {
        //Limpia la tabla, define los encabezados de la tabla y el título del panel
        clearTable();
        tableHeaderlbl.setText(GUIUtils.IO_PROCESSES_LABEL_HEADER);
        tableModel.setColumnIdentifiers(GUIUtils.IO_PROCESSES_TABLE_HEADERS);

        int sizeArrayA = inputProcessList.size();
        int sizeArrayB = outputProcessList.size();
        int major = (sizeArrayA > sizeArrayB) ? sizeArrayA : sizeArrayB;
        tableModel.setRowCount(major);
        //Agrega los valores iterando sobre la columna determinada
        for (int i = 0; i < inputProcessList.size(); i++) {
            tableModel.setValueAt(inputProcessList.get(i).getName(), i, 0);
        }
        for (int i = 0; i < outputProcessList.size(); i++) {
            tableModel.setValueAt(outputProcessList.get(i).getName(), i, 1);
        }
    }

    public void showStates(ArrayList<Process> readyProcessList, ArrayList<Process> executionProcessList, ArrayList<Process> lockedProcessList) {
        //Limpia la tabla, define los encabezados de la tabla y el título del panel
        clearTable();
        tableHeaderlbl.setText(GUIUtils.PROCESSES_STATES_LABEL_HEADER);
        tableModel.setColumnIdentifiers(GUIUtils.PROCESSES_STATES_TABLE_HEADERS);
        int sizeArrayA = readyProcessList.size();
        int sizeArrayB = executionProcessList.size();
        int sizeArrayC = lockedProcessList.size();
        tableModel.setRowCount((sizeArrayA > sizeArrayB) ? ((sizeArrayA > sizeArrayC)
                ? sizeArrayA : sizeArrayC)
                : ((sizeArrayB > sizeArrayC) ? sizeArrayB : sizeArrayC));
        //Agrega los valores iterando sobre la columna determinada
        for (int i = 0; i < readyProcessList.size(); i++) {
            tableModel.setValueAt(readyProcessList.get(i).getName(), i, 0);
        }
        for (int i = 0; i < executionProcessList.size(); i++) {
            tableModel.setValueAt(executionProcessList.get(i).getName(), i, 1);
        }
        for (int i = 0; i < lockedProcessList.size(); i++) {
            tableModel.setValueAt(lockedProcessList.get(i).getName(), i, 2);
        }
    }

    public void showTransitions(ArrayList<Process> expiredProcessList, ArrayList<Process> awakenProcessList) {
        //Limpia la tabla, define los encabezados de la tabla y el título del panel
        clearTable();
        tableHeaderlbl.setText(GUIUtils.PROCESSES_TRANSITIONS_LABEL_HEADER);
        tableModel.setColumnIdentifiers(GUIUtils.PROCESSES_TRANSITIONS_TABLE_HEADERS);
        int sizeArrayA = expiredProcessList.size();
        int sizeArrayB = awakenProcessList.size();
        int major = (sizeArrayA > sizeArrayB) ? sizeArrayA : sizeArrayB;
        tableModel.setRowCount(major);
        //Agrega los valores iterando sobre la columna determinada
        for (int i = 0; i < expiredProcessList.size(); i++) {
            tableModel.setValueAt(expiredProcessList.get(i).getName(), i, 0);
        }
        for (int i = 0; i < awakenProcessList.size(); i++) {
            tableModel.setValueAt(awakenProcessList.get(i).getName(), i, 1);
        }
    }

    public void showProcessesEvents(ArrayList<Process> destroyedProcessList, ArrayList<Process> communicatedProcessList) {
        //Limpia la tabla, define los encabezados de la tabla y el título del panel
        clearTable();
        tableHeaderlbl.setText(GUIUtils.PROCESSES_EVENTS_LABEL_HEADER);
        tableModel.setColumnIdentifiers(GUIUtils.PROCESSES_EVENTS_TABLE_HEADERS);
        int sizeArrayA = destroyedProcessList.size();
        int sizeArrayB = communicatedProcessList.size();
        int major = (sizeArrayA > sizeArrayB) ? sizeArrayA : sizeArrayB;
        tableModel.setRowCount(major);
        //Agrega los valores iterando sobre la columna determinada
        for (int i = 0; i < destroyedProcessList.size(); i++) {
            tableModel.setValueAt(destroyedProcessList.get(i).getName(), i, 0);
        }
        for (int i = 0; i < communicatedProcessList.size(); i++) {
            tableModel.setValueAt(communicatedProcessList.get(i).getName(), i, 1);
        }
    }

    public void showSortedProcesses(ArrayList<Process> inputProcessList) {
        clearTable();
        tableHeaderlbl.setText(GUIUtils.SORTED_PROCESSES_LABEL_HEADER);
        tableModel.setColumnIdentifiers(GUIUtils.ADD_PROCESSES_TABLE_HEADERS);
        for (Process process : inputProcessList) {
            addProcess(process);
        }
    }

}