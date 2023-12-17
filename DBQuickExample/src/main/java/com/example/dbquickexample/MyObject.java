package com.example.dbquickexample;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class MyObject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@ColumnDefault("false")
	@Column(columnDefinition = "tinyint(1)")
	private boolean isRead;
}
