package br.com.peopleregister.peopleregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
//@ComponentScan({"br.com.peopleregister.peopleregister", "br.com.peopleregister.peopleregister.services",
//		"br.com.peopleregister.peopleregister.controllers"})
//@EntityScan("br.com.peopleregister.peopleregister.models")
@EnableJpaRepositories("br.com.peopleregister.peopleregister.repositories")
public class PeopleRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleRegisterApplication.class, args);
	}

}
