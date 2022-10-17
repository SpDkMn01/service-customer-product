package com.nttdata.bootcamp.project.CustomerProduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customerProductActive")
public class CustomerProductActive {
    @Id
    private String id;
    private String customerId;
    private String productId;
    private double monto;
    private double deuda;
    private double limiteCredito;
}
