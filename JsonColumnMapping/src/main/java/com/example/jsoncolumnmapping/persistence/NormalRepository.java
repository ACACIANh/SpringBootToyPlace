package com.example.jsoncolumnmapping.persistence;

import com.example.jsoncolumnmapping.entity.NormalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NormalRepository extends JpaRepository< NormalEntity, Long > {
}
