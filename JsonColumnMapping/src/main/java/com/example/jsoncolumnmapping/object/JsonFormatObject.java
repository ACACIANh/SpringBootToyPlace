package com.example.jsoncolumnmapping.object;

import com.example.jsoncolumnmapping.enums.JsonFormatEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@EqualsAndHashCode
@JsonInclude( JsonInclude.Include.NON_NULL )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonFormatObject {

	@Type( JsonType.class )
	private JsonFormatEnum formatEnum;
	private String first;
}
