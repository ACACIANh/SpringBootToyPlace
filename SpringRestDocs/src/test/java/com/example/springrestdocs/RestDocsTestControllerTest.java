package com.example.springrestdocs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest( RestDocsTestController.class )
class RestDocsTestControllerTest extends AbstractRestDocsTests {

	@Test
	void RestDocsTest() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders.get( "/v1/restDocsTest" ) )
				.andExpect( MockMvcResultMatchers.status().isOk() );
	}

}