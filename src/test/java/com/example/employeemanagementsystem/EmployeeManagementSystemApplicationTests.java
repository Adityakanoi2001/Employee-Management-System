package com.example.employeemanagementsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {


	private Calculator c = new Calculator();

	@Test
	void contextLoads() {
	}

	@Test
	void testsum()
	{

		int expectedresult = 15;
		int actulResult = c.doSum(12,3,5);
		assertThat(actulResult).isEqualTo(expectedresult);
	}



}
