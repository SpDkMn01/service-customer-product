package com.nttdata.bootcamp.project.CustomerProduct.controller;

import com.nttdata.bootcamp.project.CustomerProduct.dto.*;
import com.nttdata.bootcamp.project.CustomerProduct.service.CustomerProductActiveService;
import com.nttdata.bootcamp.project.CustomerProduct.service.ICustomerProductActiveService;
import com.nttdata.bootcamp.project.CustomerProduct.utils.CustomerProductPassiveMapper;
import com.nttdata.bootcamp.project.CustomerProduct.utils.ICustomerProductActiveMapper;
import com.nttdata.bootcamp.project.CustomerProduct.utils.ICustomerProductPassiveMapper;
import com.nttdata.bootcamp.project.CustomerProduct.utils.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${message.path-customerProductActive}")
@RefreshScope
public class CustomerProductActiveController {
    @Autowired
    private ICustomerProductActiveService service;
    @Autowired
    private final ICustomerProductActiveMapper mapper;
    @Value("${message.endPointCustomer}")
    String endPointCustomer;
    @GetMapping
    public Flux<CustomerProductActiveDtoResponse> getAll()
    {
        return service.getAll();
    }
    @GetMapping(path="/{id}")
    public Mono<CustomerProductActiveDtoResponse> getById(@PathVariable String id)
    {
        return service.getById(id);
    }
    @PostMapping
    public Mono<CustomerProductActiveDtoResponse> save(@RequestBody Mono<CustomerProductActiveDtoRequest> requestMono)
    {
        //String uri = endPointCustomer + requestMono.map(mapper::toEntity).doOnNext(e -> e.getCustomerId());
        String uri = endPointCustomer + requestMono.doOnNext(p -> p.getCustomerId());
        RestTemplate restTemplate = new RestTemplate();
        CustomerGetByIdResponse result = restTemplate.getForObject(uri, CustomerGetByIdResponse.class);
        if (Objects.isNull(result)) {
            throw new EntityNotFoundException("Customer not found");
        }
        return service.save(requestMono);
    }
    @PutMapping("/update/{id}")
    public Mono<CustomerProductActiveDtoResponse> update(@RequestBody Mono<CustomerProductActiveDtoRequest> requestMono, @PathVariable String id)
    {
        return service.update(requestMono,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable String id)
    {
        return service.delete(id);
    }
}
