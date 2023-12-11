package com.example.movie_rental_system.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {
    private int code;
    private boolean success;
    private String message;

    private T data;
    private List<ErrorDto> errors;

}
