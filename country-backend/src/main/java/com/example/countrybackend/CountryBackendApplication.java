package com.example.countrybackend;

import com.example.countrybackend.domain.Role;
import com.example.countrybackend.domain.User;
import com.example.countrybackend.repository.RoleRepository;
import com.example.countrybackend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CountryBackendApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CountryBackendApplication.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(CountryBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (!this.userRepository.existsByUsername("helder")) {
			CountryBackendApplication.logger.info("Going to add new user to data base");
			Role role = new Role();
			role.setName("ROLE_ADMIN");
			role = this.roleRepository.save(role);
			Set<Role> roles = new HashSet<>();
			roles.add(role);

			final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			final String encodedPassword = passwordEncoder.encode("ribeiro");

			final User user = new User();
			user.setUsername("helder");
			user.setPassword(encodedPassword);
			user.setRoles(roles);
			this.userRepository.save(user);
		} else {
			CountryBackendApplication.logger.info("User already exists in database");
		}
	}
}
