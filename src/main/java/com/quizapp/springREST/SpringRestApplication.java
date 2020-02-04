package com.quizapp.springREST;

import com.quizapp.springREST.Repositories.QuestionRepository;
import com.quizapp.springREST.Repositories.RoleRepository;
import com.quizapp.springREST.Repositories.SocietyRepository;
import com.quizapp.springREST.model.objects.Question;
import com.quizapp.springREST.model.objects.QuestionEntity;
import com.quizapp.springREST.model.objects.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;


@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

	@Bean
	CommandLineRunner init(RoleRepository roleRepository, QuestionRepository questionRepository, SocietyRepository societyRepository) {

		return args -> {

			Role adminRole = roleRepository.findByRole("ADMIN");
			if (adminRole == null) {
				Role newAdminRole = new Role();
				newAdminRole.setRole("ADMIN");
				roleRepository.save(newAdminRole);
			}
			if(questionRepository.findAll() == null){

				for(int i = 0; i<12 ; i++)
				{
					HashMap<Character,String> answers = new HashMap<>();
					answers.put('a',"xd");
					answers.put('b',"xd");
					answers.put('c',"xd");
					answers.put('d',"xd");

					QuestionEntity questionEntity = new QuestionEntity("5e2efc94361ea9364894d7cf",new Question("xd" + i,answers,'a'));
					questionRepository.save(questionEntity);
				}

			}
		};

	}
}
