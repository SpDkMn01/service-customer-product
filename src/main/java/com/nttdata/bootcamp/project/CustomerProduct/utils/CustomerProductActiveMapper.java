package com.nttdata.bootcamp.project.CustomerProduct.utils;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.entity.CustomerProductActive;
import org.springframework.beans.BeanUtils;

public class CustomerProductActiveMapper implements ICustomerProductActiveMapper
{
    @Override
    public CustomerProductActiveDtoRequest toDtoRequest(CustomerProductActive customerProductActive) {
        CustomerProductActiveDtoRequest customerProductPassiveDtoRequest = new CustomerProductActiveDtoRequest();
        BeanUtils.copyProperties(customerProductActive, customerProductPassiveDtoRequest);
        return customerProductPassiveDtoRequest;
    }

    @Override
    public CustomerProductActive toEntity(CustomerProductActiveDtoRequest customerProductActiveDtoRequest) {
        CustomerProductActive customerProductActive = new CustomerProductActive();
        BeanUtils.copyProperties(customerProductActiveDtoRequest, customerProductActive);
        return customerProductActive;
    }

    @Override
    public CustomerProductActiveDtoResponse toDtoResponse(CustomerProductActive customerProductActive) {
        CustomerProductActiveDtoResponse customerProductActiveDtoResponse = new CustomerProductActiveDtoResponse();
        BeanUtils.copyProperties(customerProductActive, customerProductActiveDtoResponse);
        customerProductActiveDtoResponse.setCustomerUrl("/api/v1/customers/" + customerProductActive.getCustomerId());
        customerProductActiveDtoResponse.setProductUrl("/api/v1/products/" + customerProductActive.getProductId());
        return customerProductActiveDtoResponse;
    }
}
