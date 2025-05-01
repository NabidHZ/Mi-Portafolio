package com.clotfilms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Clase de configuración de seguridad para la aplicación.
 * Configura la autenticación y autorización utilizando Spring Security.
 */
@Configuration
public class SecurityConfig {

    /**
     * Configura la cadena de filtros de seguridad para la aplicación.
     * Define las reglas de autorización, el inicio de sesión con OAuth2 y el cierre de sesión.
     *
     * @param http Objeto {@link HttpSecurity} para configurar la seguridad HTTP.
     * @return Un {@link SecurityFilterChain} configurado.
     * @throws Exception Si ocurre un error durante la configuración de seguridad.
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Permite el acceso sin autenticación a las rutas especificadas
                        .requestMatchers("/", "/login", "/css/**", "/js/**").permitAll()
                        // Requiere autenticación para cualquier otra solicitud
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        // Configura la URL de redirección tras un inicio de sesión exitoso
                        .defaultSuccessUrl("/dashboard", true)
                )
                .logout(logout -> logout
                        // Configura la URL de redirección tras un cierre de sesión exitoso
                        .logoutSuccessUrl("/").permitAll()
                );
        return http.build();
    }
}