package com.example.jsoncolumnmapping.persistence;

import com.example.jsoncolumnmapping.entity.HasListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HasListRepository extends JpaRepository< HasListEntity, Long > {
}
