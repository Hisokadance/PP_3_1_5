package ru.igor.PP_3_1_3.util;

import java.util.List;

public class UserNotCreatedException extends RuntimeException {

    private List<String> errors;

    public UserNotCreatedException(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
