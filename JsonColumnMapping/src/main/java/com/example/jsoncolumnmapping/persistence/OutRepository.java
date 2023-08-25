package com.example.jsoncolumnmapping.persistence;

import com.example.jsoncolumnmapping.entity.OutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutRepository extends JpaRepository< OutEntity, Long > {
}
