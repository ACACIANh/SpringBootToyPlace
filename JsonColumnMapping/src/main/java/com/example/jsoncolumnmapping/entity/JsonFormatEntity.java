package com.example.jsoncolumnmapping.entity;

import com.example.jsoncolumnmapping.object.JsonFormatObject;
import com.example.jsoncolumnmapping.object.NormalObject;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Table( name = "jformat" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonFormatEntity {

	@Id
	private Long id;

	@Type( JsonType.class )
	@Column( columnDefinition = "longtext" )
	private JsonFormatObject first;

	//	@Type( JsonType.class )
	@Column( columnDefinition = "longtext" )
	private String second;
}
