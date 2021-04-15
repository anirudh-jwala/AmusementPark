package com.cg.AmusementPark;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.AmusementPark.controller.ActivityController;

@RunWith(SpringRunner.class)
@SpringBootTest
@EntityScan("com.cg.AmusementPark")
@EnableJpaRepositories(basePackages = { "com.cg.*" })
@ContextConfiguration(classes = { AmusementParkApplication.class })
class AmusementParkApplicationTests {

	@Autowired
	ActivityController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
