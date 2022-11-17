package com.rfcq.utilities

import com.rfcq.utilities.service.DataGeneratorService
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UtilitiesApplicationTests (val dataGeneratorService: DataGeneratorService){

	@Test
	fun cpfReturnTest() {
		println(dataGeneratorService.getCpf())
	}

}
