package org.example;

import java.util.Set;

public class Mesa extends Espaco{
    private String tipo;
    public Mesa(Local localizacao, int capacidade, Set<Reserva> agenda, int id, String tipo) {
        super(localizacao, capacidade, agenda, id);

        tipo = this.tipo;

    }
}
