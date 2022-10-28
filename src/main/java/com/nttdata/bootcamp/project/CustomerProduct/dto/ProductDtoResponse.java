package com.nttdata.bootcamp.project.CustomerProduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>ProductDtoResponse</h1>
 *
 * @version 1.0
 * @Author Grupo06
 * @since 2022-10-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoResponse {
    private String id;
    private String productTypeUrl;
    private String description;
}
