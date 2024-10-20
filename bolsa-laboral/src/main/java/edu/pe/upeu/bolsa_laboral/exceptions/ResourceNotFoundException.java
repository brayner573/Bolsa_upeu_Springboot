package edu.pe.upeu.bolsa_laboral.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception to handle resources not found scenarios.
 * This exception will result in a 404 Not Found HTTP response status.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for ResourceNotFoundException.
     *
     * @param message the detail message to be shown when the exception is thrown.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
