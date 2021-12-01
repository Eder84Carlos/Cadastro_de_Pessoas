package one.digitalInnovation.service;

import com.otestadortecnico.backend.entity.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    List<Pessoa> get();
    Optional<Pessoa> get(Long id);
    Pessoa save(Pessoa pessoa);
    Optional<Pessoa> update(Pessoa pessoa, Long id);
    void deleteByID(Long id);

}
