package com.nttdata.bootcamp.project.CustomerProduct.utils;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.entity.CustomerProductPassive;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
@AllArgsConstructor
public class CustomerProductPassiveMapper implements ICustomerProductPassiveMapper
{
    private String uri;
    private String uri2;
    @Override
    public CustomerProductPassiveDtoRequest toDtoRequest(CustomerProductPassive customerProductPassive) {
        CustomerProductPassiveDtoRequest customerProductPassiveDtoRequest = new CustomerProductPassiveDtoRequest();
        BeanUtils.copyProperties(customerProductPassive, customerProductPassiveDtoRequest);
        return customerProductPassiveDtoRequest;
    }

    @Override
    public CustomerProductPassive toEntity(CustomerProductPassiveDtoRequest customerProductPassiveDtoRequest) {
        CustomerProductPassive customerProductPassive = new CustomerProductPassive();
        BeanUtils.copyProperties(customerProductPassiveDtoRequest, customerProductPassive);
        return customerProductPassive;
    }

    @Override
    public CustomerProductPassiveDtoResponse toDtoResponse(CustomerProductPassive customerProductPassive) {
        CustomerProductPassiveDtoResponse customerProductPassiveDtoResponse = new CustomerProductPassiveDtoResponse();
        BeanUtils.copyProperties(customerProductPassive, customerProductPassiveDtoResponse);
        customerProductPassiveDtoResponse.setCustomerUrl(uri + customerProductPassive.getCustomerId());
        customerProductPassiveDtoResponse.setProductUrl(uri2 + customerProductPassive.getProductId());
        return customerProductPassiveDtoResponse;
    }
}
