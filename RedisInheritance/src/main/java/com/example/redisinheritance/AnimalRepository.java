package com.example.redisinheritance;

import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository< Animal, String > {
}
