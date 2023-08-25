package com.example.jsoncolumnmapping.persistence;

import com.example.jsoncolumnmapping.entity.NormalEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class NormalRepositoryTest {

	@Autowired
	NormalRepository normalRepository;

	@Test
	void autowiredTest() throws Exception {
		Assertions.assertThat( normalRepository ).isNotNull();
	}


	@Test
	void repositoryTest() throws Exception {

//		NormalEntity normalEntity = new NormalEntity( 0L, "\"key\": \"first\"", "\"key\": \"second\"" );
//
//		normalRepository.save( normalEntity );
	}
}