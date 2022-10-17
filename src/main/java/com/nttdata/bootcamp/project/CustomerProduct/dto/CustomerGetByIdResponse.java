package com.nttdata.bootcamp.project.CustomerProduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerGetByIdResponse {
    private String id;
    private String firstname;
    private String lastname;
    private String customerTypeUrl;
}
