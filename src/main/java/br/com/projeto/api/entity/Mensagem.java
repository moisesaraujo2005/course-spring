package br.com.projeto.api.entity;

import org.springframework.stereotype.Component;

@Component
public class Mensagem {

    private String mensagem;




    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
