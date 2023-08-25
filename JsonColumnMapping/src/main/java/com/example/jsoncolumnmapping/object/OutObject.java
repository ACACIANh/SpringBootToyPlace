package com.example.jsoncolumnmapping.object;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude( JsonInclude.Include.NON_NULL )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutObject {

	private String first;
	private InObject second;

	@JsonInclude( JsonInclude.Include.NON_NULL )
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class InObject {

		private String third;
		private String fourth;
	}
}
