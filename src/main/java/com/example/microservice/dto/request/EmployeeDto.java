package com.example.microservice.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {
    private Integer id;
    private String name;
    private Integer salary;
}
