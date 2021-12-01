package one.digitalInnovation.personapi;

import one.digitalInnovation.entity.Pessoa;
import one.digitalInnovation.repositories.PessoaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PessoaRepository repository) {
        return args -> {
            repository.save(new Pessoa("Elias Nogueira", "Porto Alegre", "Automatizar testes"));
            repository.save(new Pessoa("Julio de Lima", "SÃ£o Paulo", "Coordenar eventos de teste"));
        };
    }
}