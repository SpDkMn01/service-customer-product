package com.nttdata.bootcamp.project.CustomerProduct.utils;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.entity.CustomerProductActive;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerProductActiveMapper implements ICustomerProductActiveMapper
{
    private String uri;
    private String uri2;
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
        customerProductActiveDtoResponse.setCustomerUrl(uri + customerProductActive.getCustomerId());
        customerProductActiveDtoResponse.setProductUrl(uri2 + customerProductActive.getProductId());
        return customerProductActiveDtoResponse;
    }
}
