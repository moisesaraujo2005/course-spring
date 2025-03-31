package br.com.projeto.api.service;

import br.com.projeto.api.entity.Mensagem;
import br.com.projeto.api.entity.Pessoa;
import br.com.projeto.api.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repository acao;

    public ResponseEntity<?> cadastrar(Pessoa pessoa) {
        if(pessoa.getNome().equals("")) {
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }

        else if(pessoa.getIdade() <0) {
            mensagem.setMensagem("Informe uma idade valida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }

        else {
            return new ResponseEntity<>(acao.save(pessoa), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> selecionar() {
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<?> selecionarPeloId(Integer id) {

        if(acao.countById(id) == 0) {
            mensagem.setMensagem("Não foi encontrada nenhuma pessoa");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }

        else{
            return new ResponseEntity<>(acao.findById(id), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> editar(Pessoa pessoa) {
        if(acao.countById(pessoa.getId()) == 0) {
            mensagem.setMensagem("Usuário não existente");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else if(pessoa.getNome().equals("")) {
            mensagem.setMensagem("É necessário informar um nome");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        }

        else if(pessoa.getIdade() <0) {
            mensagem.setMensagem("Insira uma idade válida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }

        else {
            return new ResponseEntity<>(acao.save(pessoa), HttpStatus.OK);
        }
    }


}
