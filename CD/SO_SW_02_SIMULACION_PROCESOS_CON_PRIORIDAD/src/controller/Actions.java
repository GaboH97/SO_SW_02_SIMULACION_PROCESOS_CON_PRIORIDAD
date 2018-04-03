package controller;

/**
 * Este enumerado representa el conjunto de acciones que el usuario puede
 * realizar mediante la GUI, cada elemento del enumerado está enlazado con un
 * componente javax.swing que dispara una acción específica.
 *
 * @author Cesar Cardozo y Gabriel Amaya
 */
public enum Actions {
    OPEN_CREATE_PROCESS,
    CREATE_PROCESS,
    START,
    SHOW_SORTED_PROCESSES,
    SHOW_IO_PROCESSES,
    SHOW_STATES,
    SHOW_STATES_TRANSITIONS,
    SHOW_PROCESSES_EVENTS,
    OPEN_DEFINE_QUANTUM;
}
