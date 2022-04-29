package com.example.task01.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sanjarbek Allayev, вс 16:22. 24.04.2022
 */
@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.FORBIDDEN)
@Data
public class ForbiddenException extends RuntimeException{
    private String type;
    private String message;

    public ForbiddenException( String type, String message) {
        this.type = type;
        this.message = message;
    }
}
