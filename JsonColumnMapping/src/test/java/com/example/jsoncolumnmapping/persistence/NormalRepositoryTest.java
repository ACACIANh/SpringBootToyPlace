package com.example.jsoncolumnmapping.persistence;

import com.example.jsoncolumnmapping.entity.HasListEntity;
import com.example.jsoncolumnmapping.entity.NormalEntity;
import com.example.jsoncolumnmapping.object.NormalObject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class NormalRepositoryTest {

	@Autowired
	NormalRepository normalRepository;
	@Autowired
	HasListRepository hasListRepository;

	@Test
	void autowiredTest() throws Exception {
		Assertions.assertThat( normalRepository ).isNotNull();
	}

	@Test
	void normalJsonTest() throws Exception {
		NormalObject normalObject = new NormalObject( "first", "third" );
		NormalObject normalObject2 = new NormalObject( "first2", "third3" );
		List< NormalObject > normalObjectList = List.of( normalObject, normalObject2 );

		NormalEntity normalEntity = new NormalEntity( 0L, normalObject, "\"key\": \"second\"" );

		normalRepository.save( normalEntity );
	}

	@Test
	void listJsonTest() throws Exception {
		NormalObject normalObject = new NormalObject( "first", "third" );
		NormalObject normalObject2 = new NormalObject( "first2", "third3" );
		List< NormalObject > normalObjectList = List.of( normalObject, normalObject2 );

		HasListEntity normalEntity = new HasListEntity( 0L, normalObjectList, "\"key\": \"second\"" );

		hasListRepository.save( normalEntity );
	}
}