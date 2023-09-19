package com.example.instancetypecheck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InstanceTypeCheckApplicationTests {

	Shape shape = new Triangle();
	Triangle triangle = new Triangle();
	IsoscelesTriangle isoscelesTriangle = new IsoscelesTriangle();
	Triangle isoscelesTriangle2 = new IsoscelesTriangle();
	Shape nonspecificShape = null;

	@Test
	void instanceOf() throws Exception {

		Assertions.assertTrue( shape instanceof Shape );
		Assertions.assertTrue( triangle instanceof Shape );
		Assertions.assertTrue( isoscelesTriangle instanceof Shape );
		Assertions.assertFalse( nonspecificShape instanceof Shape );

		Assertions.assertTrue( shape instanceof Triangle );
		Assertions.assertTrue( triangle instanceof Triangle );
		Assertions.assertTrue( isoscelesTriangle instanceof Triangle );
		Assertions.assertFalse( nonspecificShape instanceof Triangle );

		Assertions.assertFalse( shape instanceof IsoscelesTriangle );
		Assertions.assertFalse( triangle instanceof IsoscelesTriangle );
		Assertions.assertTrue( isoscelesTriangle instanceof IsoscelesTriangle );
		Assertions.assertFalse( nonspecificShape instanceof IsoscelesTriangle );
	}

	@Test
	void classInstance() throws Exception {

		Assertions.assertTrue( Shape.class.isInstance( shape ) );
		Assertions.assertTrue( Shape.class.isInstance( triangle ) );
		Assertions.assertTrue( Shape.class.isInstance( isoscelesTriangle ) );
		Assertions.assertTrue( Shape.class.isInstance( isoscelesTriangle2 ) );
		Assertions.assertFalse( Shape.class.isInstance( nonspecificShape ) );

		Assertions.assertTrue( Triangle.class.isInstance( shape ) );
		Assertions.assertTrue( Triangle.class.isInstance( triangle ) );
		Assertions.assertTrue( Triangle.class.isInstance( isoscelesTriangle ) );
		Assertions.assertTrue( Triangle.class.isInstance( isoscelesTriangle2 ) );

		Assertions.assertFalse( IsoscelesTriangle.class.isInstance( shape ) );
		Assertions.assertFalse( IsoscelesTriangle.class.isInstance( triangle ) );
		Assertions.assertTrue( IsoscelesTriangle.class.isInstance( isoscelesTriangle ) );
		Assertions.assertTrue( IsoscelesTriangle.class.isInstance( isoscelesTriangle2 ) );
	}

	@Test
	void classIsAssignableFrom() throws Exception {

		Assertions.assertFalse( shape.getClass().isAssignableFrom( Shape.class ) );
		Assertions.assertTrue( shape.getClass().isAssignableFrom( shape.getClass() ) );
		Assertions.assertTrue( shape.getClass().isAssignableFrom( triangle.getClass() ) );
		Assertions.assertTrue( shape.getClass().isAssignableFrom( isoscelesTriangle.getClass() ) );
		Assertions.assertTrue( shape.getClass().isAssignableFrom( isoscelesTriangle2.getClass() ) );

		Assertions.assertFalse( triangle.getClass().isAssignableFrom( Shape.class ) );
		Assertions.assertTrue( triangle.getClass().isAssignableFrom( shape.getClass() ) );
		Assertions.assertTrue( triangle.getClass().isAssignableFrom( triangle.getClass() ) );
		Assertions.assertTrue( triangle.getClass().isAssignableFrom( isoscelesTriangle.getClass() ) );
		Assertions.assertTrue( triangle.getClass().isAssignableFrom( isoscelesTriangle2.getClass() ) );

		Assertions.assertFalse( isoscelesTriangle.getClass().isAssignableFrom( Shape.class ) );
		Assertions.assertFalse( isoscelesTriangle.getClass().isAssignableFrom( shape.getClass() ) );
		Assertions.assertFalse( isoscelesTriangle.getClass().isAssignableFrom( triangle.getClass() ) );
		Assertions.assertTrue( isoscelesTriangle.getClass().isAssignableFrom( isoscelesTriangle.getClass() ) );
		Assertions.assertTrue( isoscelesTriangle.getClass().isAssignableFrom( isoscelesTriangle2.getClass() ) );

		Assertions.assertFalse( isoscelesTriangle2.getClass().isAssignableFrom( Shape.class ) );
		Assertions.assertFalse( isoscelesTriangle2.getClass().isAssignableFrom( shape.getClass() ) );
		Assertions.assertFalse( isoscelesTriangle2.getClass().isAssignableFrom( triangle.getClass() ) );
		Assertions.assertTrue( isoscelesTriangle2.getClass().isAssignableFrom( isoscelesTriangle.getClass() ) );
		Assertions.assertTrue( isoscelesTriangle2.getClass().isAssignableFrom( isoscelesTriangle2.getClass() ) );

		Assertions.assertThrows( Exception.class, () -> shape.getClass().isAssignableFrom( null ) );
	}
}
