package com.nttdata.bootcamp.project.CustomerProduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProductPassiveDtoResponse
{
    private String id;
    private String customerUrl;
    private String productUrl;
    private int maintenance;
    private int maxOperationMonth;
    private String dateOperation;
}
