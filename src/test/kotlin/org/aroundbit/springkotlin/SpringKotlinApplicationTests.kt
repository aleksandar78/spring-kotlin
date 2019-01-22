package org.aroundbit.springkotlin

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringKotlinApplicationTests(@Autowired val restTemplate: TestRestTemplate) {

	@Test
	fun contextLoads() {
		val ent = restTemplate.getForEntity<String>("/api/v1/currentdate")
		assertThat(ent.statusCode, equalTo(HttpStatus.OK))
		val body = ent.body
		assertThat(body.isNullOrEmpty(), equalTo(false))
		LoggerFactory.getLogger(this::class.java).info("Test ended correctly: " + body)
	}

}

