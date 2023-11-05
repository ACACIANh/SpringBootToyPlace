package com.example.redisinheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnimalRepositoryTest {

	@Autowired
	AnimalRepository animalRepository;

	@Test
	void redisTest() throws Exception {
		//given
		Bird bird = new Bird( "crow", "black" );
		animalRepository.save( bird );

		Human human = new Human( "cian", 10 );
		animalRepository.save( human );
		//when

		//then
		animalRepository.findAll().forEach( System.out::println );
	}
}