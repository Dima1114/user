package com.starter.user;

import com.starter.user.entity.User;
import com.starter.user.repository.UserRepository;
import com.starter.user.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@ConditionalOnClass(User.class)
public class UserApplication {

    @Autowired
    private UserRepository userRepository;

    @Bean
    @ConditionalOnMissingBean
    public UserDetailsService detailsService(){
        return new JwtUserDetailsService(userRepository);
    }
}
