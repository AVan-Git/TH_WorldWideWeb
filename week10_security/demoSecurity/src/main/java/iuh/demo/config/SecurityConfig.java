package iuh.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public void globalConfig(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception{
        auth.inMemoryAuthentication()
                .withUser(User.withUsername("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles("ADMIN")
                        .build())
                .withUser(User.withUsername("user")
                        .password(passwordEncoder.encode("user"))
                        .roles("USER")
                        .build())
                .withUser(User.withUsername("RoleA")
                        .password(passwordEncoder.encode("123"))
                        .roles("ROLEA")
                        .build())
                ;



    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/home","/index" ).permitAll() // nhung link nay khong can authen
                .requestMatchers("/api/**").hasAnyRole("ADMIN", "USER", "ROLEA")// nhung uri bat dau vs api thi phai dang nhap vs cac quyen tren
                .requestMatchers("/admin/**").hasRole("ADMIN") // uri bat dau vs Role ADmin thi phai dang nhap vs quyen admin
                .anyRequest().authenticated()//uri khac thi phai dang nhap
        );
        http.httpBasic(Customizer.withDefaults());// cac thiet lap khac thi de mac dinh
        return http.build();
    }
    //
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
