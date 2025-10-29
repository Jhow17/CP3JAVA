package org.example;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Reserva {
    private int idEspaco;
    private LocalDate ini;
    private LocalDate fim;
    private String solicitante;
    private String finalidade;
    private int participantes;
    private String agenda;
    private static Set<String> reservasFeitas = new HashSet<>();

    public Reserva(int idEspaco, LocalDate ini, LocalDate fim, String solicitante, String finalidade, int participantes, String agenda) {
        this.idEspaco = idEspaco;
        this.ini = ini;
        this.fim = fim;
        this.solicitante = solicitante;
        this.finalidade = finalidade;
        this.participantes = participantes;
        this.agenda = agenda;
    }

    public boolean fazReserva() {
        if (idEspaco <= 0) {
            return false;
        }
        if (ini == null || fim == null || !ini.isBefore(fim)) {
            return false;
        }
        if (solicitante == null || solicitante.isEmpty()) {
            return false;
        }
        if (finalidade == null || finalidade.isEmpty()) {
            return false;
        }
        if (participantes <= 0) {
            return false;
        }
        String chaveReserva = idEspaco + "-" + ini + "-" + fim;
        if (reservasFeitas.contains(chaveReserva)) {
            return false;
        }
        reservasFeitas.add(chaveReserva);
        return true;
    }

    public int getIdEspaco() { return idEspaco; }
    public LocalDate getIni() { return ini; }
    public LocalDate getFim() { return fim; }
    public String getSolicitante() { return solicitante; }
}
