package one.digitalInnovation.service;

import com.otestadortecnico.backend.entity.Pessoa;
import com.otestadortecnico.backend.exception.PessoaNotFoundException;
import com.otestadortecnico.backend.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service("pessoaService")
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository repository;

    public PessoaServiceImpl(PessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pessoa> get() {
        return repository.findAll();
    }

    @Override
    public Optional<Pessoa> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @Override
    public Optional<Pessoa> update(Pessoa novaPessoa, Long id) {
        return repository.findById(id).
            map(pessoa -> {
                setIfNotNull(pessoa::setNome, novaPessoa.getNome());
                setIfNotNull(pessoa::setEndereco, novaPessoa.getEndereco());
                setIfNotNull(pessoa::setHobbies, novaPessoa.getHobbies());

                return repository.save(pessoa);
            });
    }

    @Override
    public void deleteByID(Long id) {
        Optional<Pessoa> pessoa = get(id);

        if(!pessoa.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new PessoaNotFoundException(id);
        }
    }

    private <T> void setIfNotNull(final Consumer<T> setter, final T value) {
        if (value != null) {
            setter.accept(value);
        }
    }
}