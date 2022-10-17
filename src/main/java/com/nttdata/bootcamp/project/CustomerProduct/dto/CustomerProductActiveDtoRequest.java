package com.nttdata.bootcamp.project.CustomerProduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProductActiveDtoRequest
{
    private String customerId;
    private String productId;
    private double monto;
    private double deuda;
    private double limiteCredito;
}
