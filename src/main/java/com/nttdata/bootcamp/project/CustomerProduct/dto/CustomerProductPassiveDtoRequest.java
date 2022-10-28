package com.nttdata.bootcamp.project.CustomerProduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProductPassiveDtoRequest {
    private String customerId;
    private String productId;
    private int maintenance;
    private int maxOperationMonth;
    private String dateOperation;
}
