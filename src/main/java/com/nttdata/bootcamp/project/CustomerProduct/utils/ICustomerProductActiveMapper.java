package com.nttdata.bootcamp.project.CustomerProduct.utils;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.entity.CustomerProductActive;

public interface ICustomerProductActiveMapper {
    CustomerProductActiveDtoRequest toDtoRequest(CustomerProductActive customerProductActive);
    CustomerProductActive toEntity(CustomerProductActiveDtoRequest customerProductActiveDtoRequest);
    CustomerProductActiveDtoResponse toDtoResponse(CustomerProductActive customerProductActive);
}
