package com.nttdata.bootcamp.project.CustomerProduct.service;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.repository.ICustomerProductPassiveRepository;
import com.nttdata.bootcamp.project.CustomerProduct.utils.CustomerProductPassiveMapper;
import com.nttdata.bootcamp.project.CustomerProduct.utils.ICustomerProductPassiveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerProductPassiveService
        implements ICustomerProductPassiveService<CustomerProductPassiveDtoRequest, CustomerProductPassiveDtoResponse> {
    @Autowired
    private final ICustomerProductPassiveRepository customerProductPassiveRepository;
    @Override
    public Flux<CustomerProductPassiveDtoResponse> getAll() {
        ICustomerProductPassiveMapper mapper = new CustomerProductPassiveMapper();
        return customerProductPassiveRepository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<CustomerProductPassiveDtoResponse> getById(String id)
    {
        ICustomerProductPassiveMapper mapper = new CustomerProductPassiveMapper();
        return customerProductPassiveRepository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<CustomerProductPassiveDtoResponse> save(Mono<CustomerProductPassiveDtoRequest> object)
    {
        ICustomerProductPassiveMapper mapper = new CustomerProductPassiveMapper();
        return object.map(mapper::toEntity)
                .flatMap(customerProductPassiveRepository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<CustomerProductPassiveDtoResponse> update(Mono<CustomerProductPassiveDtoRequest> object, String id)
    {
        ICustomerProductPassiveMapper mapper = new CustomerProductPassiveMapper();
        return customerProductPassiveRepository.findById(id)
                .flatMap(
                        p -> object.map(mapper::toEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(customerProductPassiveRepository::save)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<Void> delete(String id)
    {
        return customerProductPassiveRepository.deleteById(id);
    }
}