package com.nttdata.bootcamp.project.CustomerProduct.controller;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductActiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoResponse;
import com.nttdata.bootcamp.project.CustomerProduct.service.CustomerProductActiveService;
import com.nttdata.bootcamp.project.CustomerProduct.service.CustomerProductPassiveService;
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
    private CustomerProductActiveService customerProductActiveService;
    @GetMapping
    public Flux<CustomerProductActiveDtoResponse> getCustomerProductActives()
    {
        return customerProductActiveService.getAll();
    }
    @GetMapping(path="/{id}")
    public Mono<CustomerProductActiveDtoResponse> getCustomerProductActive(@PathVariable String id)
    {
        return customerProductActiveService.getById(id);
    }
    @PostMapping
    public Mono<CustomerProductActiveDtoResponse> saveCustomerProductActive(@RequestBody Mono<CustomerProductActiveDtoRequest> customerProductActiveDtoRequestMono)
    {
        return customerProductActiveService.save(customerProductActiveDtoRequestMono);
    }
    @PutMapping("/update/{id}")
    public Mono<CustomerProductActiveDtoResponse> updateCustomerProductActive(@RequestBody Mono<CustomerProductActiveDtoRequest> customerProductActiveDtoRequestMono, @PathVariable String id)
    {
        return customerProductActiveService.update(customerProductActiveDtoRequestMono,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteCustomerProductActive(@PathVariable String id)
    {
        return customerProductActiveService.delete(id);
    }
}
