package br.com.projeto.api.controller;

import br.com.projeto.api.entity.Cliente;
import br.com.projeto.api.entity.Pessoa;
import br.com.projeto.api.repository.Repository;
import br.com.projeto.api.service.Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {


    private final Repository acao;

    public ApiController(Repository acao) {
        this.acao = acao;
    }

    @Autowired
    private Service servico;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa pessoa){
        return servico.cadastrar(pessoa);
    }

    @GetMapping("/cadastrar/contem")
    public List<Pessoa> nomeContem() {
        return acao.findByNomeContaining("ses");
    }
    @GetMapping("/listar")
    public ResponseEntity<?> selecionar() {
        return servico.selecionar();
    }

    @GetMapping("/cadastrar/começa")
    public List<Pessoa> nomeInicia() {
        return acao.findByNomeStartsWith("M");
    }
    @GetMapping("/api/somaIdades")
    public int somaIdades() {
        return acao.somaIdades();
    }
    @GetMapping("/cadastrar/termina")
    public List<Pessoa> nomeFim() {
        return acao.findByNomeEndsWith("s");
    }

    @GetMapping("/api/idade-maior")
    public List<Pessoa> idadeMaiorIgual() {
        return acao.idadeMaiorIgual(18);
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<?> selecionarPeloId(@PathVariable Integer id) {
        return servico.selecionarPeloId(id);
    }
    @GetMapping("")
        public String mensagem() {
            return "Hello World!";
        }

        @GetMapping("/boas-vindas/{nome}")
        public String boasVindas(@PathVariable String nome) {
    return "Seja bem vinda " + nome
            ;
        }

        @PutMapping("/atualizar")
        public ResponseEntity<?> editar(@RequestBody Pessoa pessoa) {
        return servico.editar(pessoa);
        }

        @GetMapping("/cadastrar/contar")
        public long contador() {
            return acao.count();
        }

        @GetMapping("/cadastrar/listarnome")
        public List<Pessoa> ordernarNomes() {
        return acao.findByOrderByNomeAsc();
        }

        @GetMapping("/cadastrar/listarnome2")
        public List<Pessoa> orderNomes2() {
        return acao.findByNomeOrderByIdadeDesc("Tatiana");
        }
    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Seja bem vinda"
                ;
    }



    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa pessoa) {

    return pessoa;

    }
    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente cliente ) {

    }
}
