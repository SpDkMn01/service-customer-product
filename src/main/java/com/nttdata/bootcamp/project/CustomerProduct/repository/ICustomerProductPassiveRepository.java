package com.nttdata.bootcamp.project.CustomerProduct.repository;

import com.nttdata.bootcamp.project.CustomerProduct.entity.CustomerProductPassive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerProductPassiveRepository extends ReactiveMongoRepository<CustomerProductPassive, String> {
}
