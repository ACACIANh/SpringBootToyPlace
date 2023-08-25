package com.example.jsoncolumnmapping.object;

import com.example.jsoncolumnmapping.enums.NonJsonFormatEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@JsonInclude( JsonInclude.Include.NON_NULL )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalObject {

	//	private NonJsonFormatEnum nonJsonFormatEnum;
	private String first;
	private String second;

}
