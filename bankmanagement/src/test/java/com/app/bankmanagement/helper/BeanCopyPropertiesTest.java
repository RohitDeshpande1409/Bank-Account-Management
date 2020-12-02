package com.app.bankmanagement.helper;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BeanCopyPropertiesTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCopyPropertyObjectStringObject() {
		//fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testEmptyCopyPropertyObjectStringObject() {
		fail("Not yet implemented");
	}
}
