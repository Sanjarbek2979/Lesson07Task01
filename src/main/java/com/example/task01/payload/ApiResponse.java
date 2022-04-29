package com.example.task01.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sanjarbek Allayev, вс 12:44. 24.04.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private boolean success;
    private T data;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
