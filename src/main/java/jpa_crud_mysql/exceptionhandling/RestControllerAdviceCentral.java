package jpa_crud_mysql.exceptionhandling;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdviceCentral {



    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String IllegalArgumentExceptionHandler(IllegalArgumentException illegalArgumentException)
    {
        return illegalArgumentException.getMessage();
    }
}
