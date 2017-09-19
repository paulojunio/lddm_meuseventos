package br.pucminas.pjrrodriguessga.meuseventos;

import android.widget.ArrayAdapter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Titio on 03/09/2017.
 */

public class Eventos implements Serializable{

    private String nomeDoEvento;
    private String dataDeInicio;
    private String dataDeTermino;
    private String horarioInicio;
    private String horarioFinal;
    private String nomeDoOrga;
    private String telefoneDoOrga;
    private String emailDoOrga;
    public ArrayList<Contatos> contatos = new ArrayList<Contatos>();

    public Eventos (){


    }


    public Eventos(String nomeDoEvento, String dataDeInicio, String nomeDoOrga , String horarioInicio , String telefoneDoOrga , ArrayList<Contatos> contatos) {
        this.nomeDoEvento = nomeDoEvento;
        this.dataDeInicio = dataDeInicio;
        this.nomeDoOrga = nomeDoOrga;
        this.horarioInicio = horarioInicio;
        this.telefoneDoOrga = telefoneDoOrga;
        this.contatos = contatos;
    }

    public Eventos(String nomeDoEvento, String dataDeInicio, String horarioInicio ,String dataDeTermino,String horarioFinal, String nomeDoOrga,  String emailDoOrga ,String telefoneDoOrga) {
        this.nomeDoEvento = nomeDoEvento;
        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.nomeDoOrga = nomeDoOrga;
        this.telefoneDoOrga = telefoneDoOrga;
        this.emailDoOrga = emailDoOrga;
    }

    public ArrayList<Contatos> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contatos> contatos) {
        this.contatos = contatos;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }

    public String getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(String dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public String getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(String dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public String getNomeDoOrga() {
        return nomeDoOrga;
    }

    public void setNomeDoOrga(String nomeDoOrga) {
        this.nomeDoOrga = nomeDoOrga;
    }

    public String getTelefoneDoOrga() {
        return telefoneDoOrga;
    }

    public void setTelefoneDoOrga(String telefoneDoOrga) {
        this.telefoneDoOrga = telefoneDoOrga;
    }

    public String getEmailDoOrga() {
        return emailDoOrga;
    }

    public void setEmailDoOrga(String emailDoOrga) {
        this.emailDoOrga = emailDoOrga;
    }
}
