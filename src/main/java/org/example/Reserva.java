package org.example;

import java.time.LocalDate;

public class Reserva {
    private int idEspaco;
    private LocalDate ini;
    private LocalDate fim;
    private String solicitante;
    private String finalidade;
    private int participantes;

    public Reserva(int idEspaco, LocalDate ini, LocalDate fim, String solicitante, String finalidade, int participantes) {
        this.idEspaco = idEspaco;
        this.ini = ini;
        this.fim = fim;
        this.solicitante = solicitante;
        this.finalidade = finalidade;
        this.participantes = participantes;
    }

    public
}
