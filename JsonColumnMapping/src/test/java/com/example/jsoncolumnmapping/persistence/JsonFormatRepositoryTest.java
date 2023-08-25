package com.example.jsoncolumnmapping.persistence;

import com.example.jsoncolumnmapping.entity.JsonFormatEntity;
import com.example.jsoncolumnmapping.entity.NormalEntity;
import com.example.jsoncolumnmapping.enums.JsonFormatEnum;
import com.example.jsoncolumnmapping.object.JsonFormatObject;
import com.example.jsoncolumnmapping.object.NormalObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JsonFormatRepositoryTest {

	@Autowired
	JsonFormatRepository jsonFormatRepository;

	@Test
	void autowiredTest() throws Exception {
		Assertions.assertThat( jsonFormatRepository ).isNotNull();
	}

	@Test
	void objectMapperTest() throws Exception {

		JsonFormatObject jsonFormatObject = new JsonFormatObject( JsonFormatEnum.FIRST, "second" );

		JsonFormatEntity jsonFormatEntity = new JsonFormatEntity( 0L, jsonFormatObject, "\"key\": \"second\"" );

		ObjectMapper objectMapper = new ObjectMapper();

		String s = objectMapper.writeValueAsString( jsonFormatEntity );

		System.out.println( s );
	}

	@Test
	void jsonFormatTest() throws Exception {

		JsonFormatObject jsonFormatObject = new JsonFormatObject( JsonFormatEnum.FIRST, "second" );

		JsonFormatEntity jsonFormatEntity = new JsonFormatEntity( 0L, jsonFormatObject, "\"key\": \"second\"" );

		jsonFormatRepository.save( jsonFormatEntity );
	}

}