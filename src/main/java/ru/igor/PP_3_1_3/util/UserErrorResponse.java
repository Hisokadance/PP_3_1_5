package ru.igor.PP_3_1_3.util;

import java.util.List;

public class UserErrorResponse {

    private List<String> errors;

    public UserErrorResponse(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
