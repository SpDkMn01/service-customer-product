package com.nttdata.bootcamp.project.CustomerProduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customerProductPassive")
public class CustomerProductPassive
{
    @Id
    private String id;
    private String customerId;
    private String productId;
    private int mantenimiento;
    private int maxOperationMonth;
    private String dateOperation;
}
