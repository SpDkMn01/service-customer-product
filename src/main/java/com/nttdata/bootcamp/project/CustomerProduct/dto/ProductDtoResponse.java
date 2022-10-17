package com.nttdata.bootcamp.project.CustomerProduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoResponse {
    private String id;
    private String productTypeUrl;
    private String description;
}
