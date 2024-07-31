package uk.co.digitalpenguin.xrp.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;
import uk.co.digitalpenguin.xrp.repos.UserRepository;

@Configuration
@EnableWebSecurity
public class Security 
{
	protected Logger log = LoggerFactory.getLogger(Security.class);
	
	@Autowired
    protected DataSource dataSource;
	
	@Autowired
	protected UserRepository userRepo;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
	{
        http.csrf(CsrfConfigurer::disable);
        
        http.authorizeHttpRequests(requests -> requests
            .dispatcherTypeMatchers(DispatcherType.FORWARD,DispatcherType.ERROR).permitAll()
           	.requestMatchers("/resources/**").permitAll()
            .anyRequest().authenticated()
        );
        
        http.formLogin(formLogin ->	formLogin
        	.loginPage("/login")
        	.permitAll()
        );

		return http.build();
	}

    @Bean
    public PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }
}
