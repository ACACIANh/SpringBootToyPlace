package com.example.jsoncolumnmapping.persistence;

import com.example.jsoncolumnmapping.entity.OutEntity;
import com.example.jsoncolumnmapping.object.OutObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OutRepositoryTest {
	@Autowired
	OutRepository outRepository;

	@Test
	void outTest() throws Exception {

		OutObject.InObject inObject = new OutObject.InObject( "third", "4" );
		OutObject outObject = new OutObject( "first", inObject );
		OutEntity outEntity = new OutEntity( 0L, outObject );
		outRepository.save( outEntity );
	}
}