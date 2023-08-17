package ru.netology.rest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.rest.exception.InvalidCredentials;

@RestControllerAdvice
public class ExceptionHandler {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEnity<String> emptyUserHandler(InvalidCredentials e){
        return new ResponseEnity<>("Не заполнено имя пользователя или пароль", HttpStatus.BAD_REQUEST);
    }
}
