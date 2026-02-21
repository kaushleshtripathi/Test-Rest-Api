package com.example.microservice.controller;

import com.example.microservice.dto.request.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeProtoController {

    @GetMapping(value = "/{id}",produces={"application/json","application/x-protobuf"})
    public String getEmployee(@PathVariable int id) {

        Employee.employee employee = Employee.employee.newBuilder()
                .setId(1)
                .setName("John Doe")
                .setSalary(75000)
                .build();

        return employee.getId()+" "+employee.getName()+" "+employee.getSalary();
    }

    @PostMapping(
            value="/create",
            consumes={"application/json","application/x-protobuf"}
    )
    public String create(@RequestBody Employee employee) {

        return "Saved: " ;
    }
}