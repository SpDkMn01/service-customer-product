package com.nttdata.bootcamp.project.CustomerProduct.controller;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.service.CustomerProductPassiveService;
import com.nttdata.bootcamp.project.CustomerProduct.service.ICustomerProductPassiveService;
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
@RequestMapping("${message.path-customerProductPassive}")
@RefreshScope
public class CustomerProductPassiveController {
    @Autowired
    private ICustomerProductPassiveService service;
    @GetMapping
    public Flux<CustomerProductPassiveDtoResponse> getAll()
    {
        return service.getAll();
    }
    @GetMapping(path="/{id}")
    public Mono<CustomerProductPassiveDtoResponse> getById(@PathVariable String id)
    {
        return service.getById(id);
    }
    @PostMapping
    public Mono<CustomerProductPassiveDtoResponse> save(@RequestBody Mono<CustomerProductPassiveDtoRequest> requestMono)
    {
        return service.save(requestMono);
    }
    @PutMapping("/update/{id}")
    public Mono<CustomerProductPassiveDtoResponse> update(@RequestBody Mono<CustomerProductPassiveDtoRequest> requestMono, @PathVariable String id)
    {
        return service.update(requestMono,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable String id)
    {
        return service.delete(id);
    }
}
