package uk.co.digitalpenguin.xrp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import uk.co.digitalpenguin.xrp.config.Security;
import uk.co.digitalpenguin.xrp.models.User;
import uk.co.digitalpenguin.xrp.repos.UserRepository;

@Service
public class UserService implements UserDetailsService
{
	protected Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	protected UserRepository userRepository;
	  
	@Autowired
	protected JdbcTemplate jdbc;
	
	@Autowired 
	protected PasswordEncoder passwordEncoder;
	  
	@PostConstruct
	public void initUserPasswords()  // For testing only
	{
		jdbc.update("UPDATE users set password = ?", passwordEncoder.encode("tomato"));		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User Not found: " +username);
		  
		return user;
	}
}
