package co.com.bancolombia.config;

import co.com.bancolombia.model.cinema.gateways.CinemaRepository;
import co.com.bancolombia.usecase.cinema.CinemaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

        @Bean
        public CinemaUseCase cinemaUseCase(CinemaRepository cinemaRepository){
                return new CinemaUseCase(cinemaRepository);
        }

}
