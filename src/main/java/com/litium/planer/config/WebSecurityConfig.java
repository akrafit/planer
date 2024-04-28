//package com.litium.planer.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//    //private final UserDetailsService userDetailsService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers().permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout((logout) -> logout.permitAll());
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//
////    @Autowired
////    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
////        this.userDetailsService = userDetailsService;
////    }
////
////    @Bean
////    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
////        return authenticationConfiguration.getAuthenticationManager();
////    }
////
//////    @Override
//////    protected void configure(HttpSecurity http) throws Exception {
//////        http
//////                .csrf().disable()
//////                .authorizeRequests()
//////                .antMatchers("/").permitAll()
//////                //.antMatchers("/api/addcow").anonymous()
//////                .anyRequest()
//////                .authenticated()
//////                .and()
//////                .formLogin()
//////                .loginPage("/auth/login").permitAll()
//////                .defaultSuccessUrl("/cow")
//////                .and()
//////                .logout()
//////                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
//////                .invalidateHttpSession(true)
//////                .clearAuthentication(true)
//////                .deleteCookies("JSESSIONID")
//////                .logoutSuccessUrl("/auth/login");
//////    }
////
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http
////                .csrf().disable()
////                .authorizeRequests()
////                .antMatchers("/").permitAll()
////                //.antMatchers("/api/addcow").anonymous()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/auth/login").permitAll()
////                .defaultSuccessUrl("/cow")
////                .and()
////                .logout()
////                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
////                .invalidateHttpSession(true)
////                .clearAuthentication(true)
////                .deleteCookies("JSESSIONID")
////                .logoutSuccessUrl("/auth/login");
////        return http.build();
////    }
////
////    @Bean
////    protected PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder(12);
////    }
////
////    @Bean
////    protected DaoAuthenticationProvider daoAuthenticationProvider() {
////        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
////        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
////        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
////        return daoAuthenticationProvider;
////    }
//}
