package com.nttdata.bootcamp.project.CustomerProduct.controller;

import com.nttdata.bootcamp.project.CustomerProduct.dto.*;
import com.nttdata.bootcamp.project.CustomerProduct.service.CustomerProductActiveService;
import com.nttdata.bootcamp.project.CustomerProduct.service.CustomerProductPassiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        String uri = "http://localhost:8094/api/v1/customers/63484f54098ba16f2bbe2439";
        RestTemplate restTemplate = new RestTemplate();
        CustomerGetByIdResponse result = restTemplate.getForObject(uri, CustomerGetByIdResponse.class);
        if (Objects.isNull(result)) {
            //lanzar throw personalizado
        }
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
