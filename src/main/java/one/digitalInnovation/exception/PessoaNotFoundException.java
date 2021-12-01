package one.digitalInnovation.exception;


public class PessoaNotFoundException extends RuntimeException {

    private Long id;

    public PessoaNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "A pessoa com id="+ id + " nÃ£o foi encontrada";
    }
}