package br.com.pucgo.repository.exceptions;

public class EmptyListException extends Exception {
    public EmptyListException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyListException(String message) {
        super(message);
    }

    public EmptyListException() {
        super();
    }
}