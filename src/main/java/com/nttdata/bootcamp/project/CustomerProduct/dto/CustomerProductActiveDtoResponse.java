package com.nttdata.bootcamp.project.CustomerProduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProductActiveDtoResponse
{
    private String id;
    private String customerUrl;
    private String productUrl;
    private double monto;
    private double deuda;
    private double limiteCredito;
}
