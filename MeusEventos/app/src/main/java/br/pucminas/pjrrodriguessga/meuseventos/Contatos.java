package br.pucminas.pjrrodriguessga.meuseventos;

import java.io.Serializable;

/**
 * Created by Titio on 14/09/2017.
 */

class Contatos implements Serializable{

    private String nomeDoContato;
    private String teleDoContato;
    private String emailDoContato;

    public Contatos()
    {


    }
    public Contatos(String nomeDoContato, String teleDoContato, String emailDoContato) {
        this.nomeDoContato = nomeDoContato;
        this.teleDoContato = teleDoContato;
        this.emailDoContato = emailDoContato;
    }

    public String getNomeDoContato() {
        return nomeDoContato;
    }

    public void setNomeDoContato(String nomeDoContato) {
        this.nomeDoContato = nomeDoContato;
    }

    public String getTeleDoContato() {
        return teleDoContato;
    }

    public void setTeleDoContato(String teleDoContato) {
        this.teleDoContato = teleDoContato;
    }

    public String getEmailDoContato() {
        return emailDoContato;
    }

    public void setEmailDoContato(String emailDoContato) {
        this.emailDoContato = emailDoContato;
    }
}
