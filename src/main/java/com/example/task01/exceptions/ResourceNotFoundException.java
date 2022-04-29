package com.example.task01.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sanjarbek Allayev, вс 13:49. 24.04.2022
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;  //lavozim table

    private String resourceField;// name

    private Object object;  // USER, ADMIN

}
