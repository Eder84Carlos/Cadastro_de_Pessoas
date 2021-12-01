package one.digitalInnovation.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.*;
import one.digitalInnovation.domain.MessageDTO;
import one.digitalInnovation.domain.PessoaDTO;
import one.digitalInnovation.entity.Pessoa;
import one.digitalInnovation.exception.PessoaNotFoundException;
import one.digitalInnovation.service.PessoaService;

@RestController
class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @ApiOperation(value = "Lista todas as pessoas cadastradas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Pessoas encontradas")
    })
    @GetMapping("/api/v1/pessoas")
    List<Pessoa> getPessoa() {
        return pessoaService.get();
    }

    @ApiOperation(value = "Retorna uma pessoa pelo seu id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Pessoa encontrada", response = PessoaDTO.class),
            @ApiResponse(code = 404, message = "Pessoa nÃ£o encontrada", response = MessageDTO.class)
        })
    @GetMapping("/api/v1/pessoas/{id}")
    ResponseEntity<Pessoa> one(@PathVariable Long id) {
        return pessoaService.get(id)
                .map(pessoa -> ResponseEntity.ok().body(pessoa))
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }

    @ApiOperation(value = "Adiciona uma pessoa")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Pessoa criada com sucesso", response = PessoaDTO.class),
            @ApiResponse(code = 404, message = "Pessoa nÃ£o encontrada", response = MessageDTO.class)
        })
    @PostMapping("/api/v1/pessoas")
    Pessoa novaPessoa(@Valid @RequestBody PessoaDTO pessoa) {
        return pessoaService.save(new ModelMapper().map(pessoa, Pessoa.class));
    }

    @ApiOperation(value = "Altera uma pessoa")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Pessoa criada com sucesso", response = PessoaDTO.class),
            @ApiResponse(code = 404, message = "Pessoa nÃ£o encontrada", response = MessageDTO.class)
        })
    @PutMapping("/api/v1/pessoas/{id}")
    Pessoa updatePessoa(@RequestBody PessoaDTO pessoaAlterada, @PathVariable Long id) {
        return pessoaService.update(new ModelMapper()
                .map(pessoaAlterada, Pessoa.class), id)
                .orElseThrow(() -> { throw new PessoaNotFoundException(id); });
    }

    @ApiOperation(value = "Remove uma pessoa pelo seu id")
    @ApiResponses( {
            @ApiResponse(code = 204, message = "Pessoa removida com sucesso"),
            @ApiResponse(code = 404, message = "Pessoa nÃ£o encontrada", response = MessageDTO.class)
        })
    @DeleteMapping("/api/v1/pessoas/{id}")
    void delete(@PathVariable Long id) {
        pessoaService.deleteByID(id);
    }
}