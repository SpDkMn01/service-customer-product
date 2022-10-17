package com.nttdata.bootcamp.project.CustomerProduct.controller;

import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoRequest;
import com.nttdata.bootcamp.project.CustomerProduct.dto.CustomerProductPassiveDtoResponse;
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
@RequestMapping("${message.path-customerProductPassive}")
@RefreshScope
public class CustomerProductPassiveController {
    /*
    @GetMapping
    public Mono<List<ProductDtoResponse>> getCustomerProducts()
    {
        WebClient client = WebClient.create("http://localhost:8001/");
        return client.get()
                .uri("api/v1/products")
                .retrieve()
                .bodyToFlux(ProductDtoResponse.class)
                .collectionList()
                .block();
    }
     */
    @Autowired
    private CustomerProductPassiveService customerProductPassiveService;
    @GetMapping
    public Flux<CustomerProductPassiveDtoResponse> getCustomerProductPassives()
    {
        return customerProductPassiveService.getAll();
    }
    @GetMapping(path="/{id}")
    public Mono<CustomerProductPassiveDtoResponse> getCustomerProductPassive(@PathVariable String id)
    {
        return customerProductPassiveService.getById(id);
    }
    @PostMapping
    public Mono<CustomerProductPassiveDtoResponse> saveCustomerProductPassive(@RequestBody Mono<CustomerProductPassiveDtoRequest> customerProductPassiveDtoRequest)
    {
        return customerProductPassiveService.save(customerProductPassiveDtoRequest);
    }
    @PutMapping("/update/{id}")
    public Mono<CustomerProductPassiveDtoResponse> updateCustomerProductPassives(@RequestBody Mono<CustomerProductPassiveDtoRequest> CustomerDtoMono, @PathVariable String id)
    {
        return customerProductPassiveService.update(CustomerDtoMono,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteCustomerProductPassives(@PathVariable String id)
    {
        return customerProductPassiveService.delete(id);
    }
}
