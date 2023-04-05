package com.epicminds.training.exception;

/**
 * @author Sidharth
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
