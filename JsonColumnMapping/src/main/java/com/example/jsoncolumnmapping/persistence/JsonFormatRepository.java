package com.example.jsoncolumnmapping.persistence;

import com.example.jsoncolumnmapping.entity.JsonFormatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JsonFormatRepository extends JpaRepository< JsonFormatEntity, Long > {
}
