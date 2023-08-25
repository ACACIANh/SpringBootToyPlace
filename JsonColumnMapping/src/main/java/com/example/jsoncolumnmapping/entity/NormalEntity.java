package com.example.jsoncolumnmapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class NormalEntity {

	@Id
	private Long id;
}
