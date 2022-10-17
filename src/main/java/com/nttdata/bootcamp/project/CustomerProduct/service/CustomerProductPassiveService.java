package com.nttdata.bootcamp.project.CustomerProduct.service;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.repository.ICustomerProductPassiveRepository;
import com.nttdata.bootcamp.project.CustomerProduct.utils.CustomerProductPassiveMapper;
import com.nttdata.bootcamp.project.CustomerProduct.utils.ICustomerProductPassiveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerProductPassiveService implements ICustomerProductPassiveService<CustomerProductPassiveDtoRequest, CustomerProductPassiveDtoResponse> {
    @Value("${message.uri}")
    String uri;
    @Value("${message.uri2}")
    String uri2;
    @Autowired
    private final ICustomerProductPassiveRepository repository;
    @Override
    public Flux<CustomerProductPassiveDtoResponse> getAll() {
        ICustomerProductPassiveMapper mapper = new CustomerProductPassiveMapper(uri, uri2);
        return repository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<CustomerProductPassiveDtoResponse> getById(String id)
    {
        ICustomerProductPassiveMapper mapper = new CustomerProductPassiveMapper(uri, uri2);
        return repository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<CustomerProductPassiveDtoResponse> save(Mono<CustomerProductPassiveDtoRequest> object)
    {
        ICustomerProductPassiveMapper mapper = new CustomerProductPassiveMapper(uri, uri2);
        return object.map(mapper::toEntity)
                .flatMap(repository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<CustomerProductPassiveDtoResponse> update(Mono<CustomerProductPassiveDtoRequest> object, String id)
    {
        ICustomerProductPassiveMapper mapper = new CustomerProductPassiveMapper(uri, uri2);
        return repository.findById(id)
                .flatMap(
                        p -> object.map(mapper::toEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(repository::save)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<Void> delete(String id)
    {
        return repository.deleteById(id);
    }
}