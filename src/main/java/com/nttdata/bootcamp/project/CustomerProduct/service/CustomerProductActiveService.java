package com.nttdata.bootcamp.project.CustomerProduct.service;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.repository.ICustomerProductActiveRepository;
import com.nttdata.bootcamp.project.CustomerProduct.utils.CustomerProductActiveMapper;
import com.nttdata.bootcamp.project.CustomerProduct.utils.ICustomerProductActiveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerProductActiveService implements ICustomerProductPassiveService<CustomerProductActiveDtoRequest, CustomerProductActiveDtoResponse>
{
    @Autowired
    private final ICustomerProductActiveRepository customerProductActiveRepository;
    @Override
    public Flux<CustomerProductActiveDtoResponse> getAll() {
        ICustomerProductActiveMapper mapper = new CustomerProductActiveMapper();
        return customerProductActiveRepository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<CustomerProductActiveDtoResponse> getById(String id)
    {
        ICustomerProductActiveMapper mapper = new CustomerProductActiveMapper();
        return customerProductActiveRepository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<CustomerProductActiveDtoResponse> save(Mono<CustomerProductActiveDtoRequest> object)
    {
        ICustomerProductActiveMapper mapper = new CustomerProductActiveMapper();
        return object.map(mapper::toEntity)
                .flatMap(customerProductActiveRepository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<CustomerProductActiveDtoResponse> update(Mono<CustomerProductActiveDtoRequest> object, String id)
    {
        ICustomerProductActiveMapper mapper = new CustomerProductActiveMapper();
        return customerProductActiveRepository.findById(id)
                .flatMap(
                        p -> object.map(mapper::toEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(customerProductActiveRepository::save)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<Void> delete(String id)
    {
        return customerProductActiveRepository.deleteById(id);
    }
}