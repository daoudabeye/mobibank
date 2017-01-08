package org.wallet.services;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.wallet.models.User;
import org.wallet.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@PostConstruct	
	protected void initialize() {
		save(new User("admin", "admin", "ROLE_ADMIN"));
		//save(new Account("admin", "admin", "ROLE_ADMIN"));
	}
	
	public User save(User user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public User findByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOneByUsername(username);
		return user;
	}
	
	public Boolean checkPassword(String rawPassword, String encodedPassword){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(rawPassword, encodedPassword);
	}
	
	@Transactional
	public void updateLoginDate(Long id, Date date, String ip){
		userRepository.updateLastLogin(id, date, ip);
	}
}
