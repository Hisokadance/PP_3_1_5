package ru.igor.PP_3_1_3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.igor.PP_3_1_3.util.UserErrorResponse;
import ru.igor.PP_3_1_3.util.UserNotCreatedException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserErrorResponse.class)
    public ResponseEntity<String> handleUserNotAuthorizedException() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Ошибка авторизации");
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UserNotCreatedException userNotCreatedException) {
        UserErrorResponse response = new UserErrorResponse(userNotCreatedException.getErrors());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
