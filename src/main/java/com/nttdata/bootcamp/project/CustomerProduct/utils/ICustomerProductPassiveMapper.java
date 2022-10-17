package com.nttdata.bootcamp.project.CustomerProduct.utils;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.entity.CustomerProductPassive;

public interface ICustomerProductPassiveMapper {
    CustomerProductPassiveDtoRequest toDtoRequest(CustomerProductPassive customerProductPassive);
    CustomerProductPassive toEntity(CustomerProductPassiveDtoRequest productDtoRequest);
    CustomerProductPassiveDtoResponse toDtoResponse(CustomerProductPassive customerProductPassive);
}
