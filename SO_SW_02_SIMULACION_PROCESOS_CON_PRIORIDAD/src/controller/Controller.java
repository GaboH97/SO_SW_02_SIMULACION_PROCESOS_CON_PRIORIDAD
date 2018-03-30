package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import logic.ProcessManager;
import views.AddProcessDialog;
import views.GUIUtils;
import static views.GUIUtils.APP_TITLE;
import views.MainWindow;

/**
 * Clase que funciona como intermediaria entre la capa Lógica y la capa de Vista
 * Enruta las acciones generadas desde la vista para la ejecución de ciertas
 * tareas en la lógica y muestra un conjunto de datos procesados en la GUI
 *
 * @author Cesar Cardozo y Gabriel Amaya
 */
public class Controller implements ActionListener {

    //----------------- Atributos ------------------------
    /**
     * Clase lógica principal manejadora de enventos
     */
    private ProcessManager processManager;

    /**
     * Ventana de diálogo para crear y agregar un nuevo proceso
     */
    private AddProcessDialog addProcessDialog;

    /**
     * GUI principal
     */
    private MainWindow mainWindow;

    //-------------------- Constructores -------------------------
    /**
     * Crea una nueva instancia de la clase Controller
     */
    public Controller() {
        processManager = new ProcessManager();
        mainWindow = new MainWindow(this);
        addProcessDialog = new AddProcessDialog(mainWindow, true, this);
    }

    public Controller(ProcessManager processManager) {
        this.processManager = processManager;
        mainWindow = new MainWindow(this);
        addProcessDialog = new AddProcessDialog(mainWindow, true, this);
    }

    //----------------------- Métodos -------------------------
    /**
     * Método implementado de la clase ActionListener que define una estructura
     * para el manejo de eventos provenientes de la GUI y que permite
     * interactuar con la capa lógica del programa
     *
     * @param e intancia de ActionEvent lanzada por el objeto que genero dicho
     * evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Evalúa el comando que generó dicha acción dentro de la lista de comandos
        //del enumerado Actions
        switch (Actions.valueOf(e.getActionCommand())) {
            case OPEN_CREATE_PROCESS:
                addProcessDialog.setVisible(true);
                break;
            case CREATE_PROCESS:
                createProcess();
                break;
            case START:
                start();
                break;
            case SHOW_IO_PROCESSES:
                showIOProcesses();
                break;
            case SHOW_STATES:
                showStates();
                break;
            case SHOW_TRANSITIONS:
                showTransitions();
                break;
            case OPEN_DEFINE_QUANTUM:
                openDefineQuantum();
                break;
        }
    }

    /**
     * Agrega un proceso
     */
    private void createProcess() {
        //Crea una nuevo Proceso, si no es nulo, significa que ha sido creado
        //Exitosamente, es decir
        logic.Process process = addProcessDialog.createProcess();
        if (process != null) {
            //Agrega el proceso en la lógica y si ha sido agregado correctamente,
            //Lo agrega a la GUI y cierra el diálogo de agregar proceso
            if (processManager.addProcess(process)) {
                mainWindow.addProcess(process);
                addProcessDialog.close();
            } else {
                //Muestra un mensaje de error indicando que el proceso
                //Ya existe en la lógica
                JOptionPane.showMessageDialog(addProcessDialog,
                        GUIUtils.MSG_PROCESS_ALREADY_EXISTS,
                        APP_TITLE,
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //Muestra un mensaje de error indicando que en el diálogo para agregar
            //Procesos hay campos vacíos
            JOptionPane.showMessageDialog(addProcessDialog,
                    GUIUtils.MSG_EMPTY_FIELDS,
                    APP_TITLE,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Comienza la ejecución de los procesos
     */
    private void start() {
        //Revisa que la lista no esté vacía, si no lo está, inicia la ejecución 
        //de los procesos, cambia la perspectiva de la GUI principal y muestra
        //los procesos E/S
        if (!processManager.getInputProcessList().isEmpty()) {
            processManager.processProcesses();
            mainWindow.showOptions(false);
            showIOProcesses();
        } else {
            //Muestra un mensaje de error indicando que no hay procesos para eje-
            //cutarse
            JOptionPane.showMessageDialog(mainWindow,
                    GUIUtils.MSG_NO_PROCESS,
                    APP_TITLE,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Muestra una tabla los procesos de entrada y de salida
     */
    private void showIOProcesses() {
        mainWindow.showIOProcesses(processManager.getInputProcessList(), processManager.getOutputProcessList());
    }

    /**
     * Muestra una tabla con los estados de los procesos (Listos, En Ejecución y
     * Bloqueados)
     */
    private void showStates() {
        mainWindow.showStates(processManager.getReadyProcessList(), processManager.getExecutionProcessList(), processManager.getLockedProcessList());
    }

    /**
     * Muestra una tabla con las transiciones de los procesos (Expirados,
     * Despiertos)
     */
    private void showTransitions() {
        mainWindow.showTransitions(processManager.getExpiredProcessList(), processManager.getAwakenProcessList());
    }

    /**
     * Define un nuevo Quantum para el manejador de procesos
     */
    private void openDefineQuantum() {
        String input = JOptionPane.showInputDialog(mainWindow, "Indique el nuevo valor del quantum");
        //Verifica que el String de entrada sea numérico y que no esté vacío
        //Si es así, cambia el Quantum del manejador de procesos
        if (addProcessDialog.isNumeric(input) && !input.isEmpty()) {
            processManager.setQuantum(Double.parseDouble(input));
        } else {
            //Muestra un mensaje de error que indica que el tiempo ingresado es
            //inválido
            JOptionPane.showMessageDialog(mainWindow,
                    GUIUtils.MSG_INVALID_TIME,
                    GUIUtils.APP_TITLE,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setProcessManager(ProcessManager processManager) {
        this.processManager = processManager;
    }

}
