package com.breno.exercise;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ExerciseApplicationTest {

	@Test
	public void RunWithNullParameterTest() {

		ExerciseApplication app = new ExerciseApplication();
		app.run(null);
		Assert.fail("Please provide file path.");
	}

	@Test
	public void RunWithNullParameter2Test() {
		String[] bla = new String[3];

		ExerciseApplication app = new ExerciseApplication();
		app.run(bla);
		Assert.fail("Please provide file path.");
	}
	
}
