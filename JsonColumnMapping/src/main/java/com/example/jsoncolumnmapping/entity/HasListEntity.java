package com.example.jsoncolumnmapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "has_list" )
public class HasListEntity {
	@Id
	private Long id;
}
