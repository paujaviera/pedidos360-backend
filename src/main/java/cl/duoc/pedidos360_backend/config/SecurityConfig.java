package cl.duoc.pedidos360_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // Consultar pedidos
                .requestMatchers("/api/pedidos")
                .hasAuthority("SCOPE_pedidos360-api/pedidos360-api-read")

                // Consultar productos
                .requestMatchers("/api/productos")
                .hasAuthority("SCOPE_pedidos360-api/productos-read")

                // Cualquier otra ruta
                .anyRequest().permitAll()
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {}));

        return http.build();
    }
}