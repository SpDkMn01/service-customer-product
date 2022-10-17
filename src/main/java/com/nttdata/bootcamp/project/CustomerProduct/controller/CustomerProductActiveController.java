package com.nttdata.bootcamp.project.CustomerProduct.controller;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.service.CustomerProductActiveService;
import com.nttdata.bootcamp.project.CustomerProduct.service.ICustomerProductActiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${message.path-customerProductActive}")
@RefreshScope
public class CustomerProductActiveController {
    @Autowired
    private ICustomerProductActiveService service;
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
