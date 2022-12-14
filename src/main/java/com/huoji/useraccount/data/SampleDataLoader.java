package com.huoji.useraccount.data;

import com.github.javafaker.Faker;
import com.huoji.useraccount.dao.UserRepository;
import com.huoji.useraccount.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {


	private final UserRepository userRepository;

	private final Faker faker;

	private final PasswordEncoder encoder;

	public SampleDataLoader(UserRepository userRepository, Faker faker, PasswordEncoder encoder) {
		this.userRepository = userRepository;
		this.faker = faker;
		this.encoder = encoder;
	}


	@Override
	public void run(String... args) throws Exception {

		List<User> users = IntStream.rangeClosed(1, 20)
				.mapToObj(i -> new User(encoder.encode(faker.beer()
						.name()), faker.internet()
						.emailAddress(), faker.name()
						.firstName(), faker.name()
						.lastName()))
				.toList();

		userRepository.saveAll(users);
		userRepository.save(new User(encoder.encode("password"), "huoji@gmail.com", "huoji", "huoji"));

	}
}
