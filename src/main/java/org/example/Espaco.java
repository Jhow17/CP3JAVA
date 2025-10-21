package org.example;

import java.util.Set;

abstract public class Espaco {
    private int id ;
    private Local localizacao;
    private int capacidade;
    private Set<Reserva> agenda;

    public Espaco(Local localizacao, int capacidade, Set<Reserva> agenda, int id) {
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.agenda = agenda;
        this.id = id;
    }

    public Local getLocalizacao() {
        return localizacao;
    }

    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public Set<Reserva> getAgenda() {
        return agenda;
    }




}
