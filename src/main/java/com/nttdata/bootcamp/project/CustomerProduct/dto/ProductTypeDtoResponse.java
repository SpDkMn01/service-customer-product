package com.nttdata.bootcamp.project.CustomerProduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>ProductTypeDto</h1>
 *
 * @version 1.0
 * @Author Grupo06
 * @since 2022-10-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeDtoResponse {
    private String id;
    private String description;
}
