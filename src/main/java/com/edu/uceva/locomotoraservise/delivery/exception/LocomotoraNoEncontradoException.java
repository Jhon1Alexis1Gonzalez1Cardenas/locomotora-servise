package com.edu.uceva.locomotoraservise.delivery.exception;

public class LocomotoraNoEncontradoException extends RuntimeException {
    public LocomotoraNoEncontradoException(long id) {
        super("Locomotora con id: " + id + " no encontrado");
    }
}
