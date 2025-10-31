package br.com.fiap.cp;

import java.rmi.server.UID;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Reserva implements Comparable<Reserva> {
    private final UUID idReserva;
    private final UUID idEspaco;
    private LocalDate dia;
    private LocalTime ini;
    private LocalTime fim;
    private String representate;
    private String finalidade;
    private int participantes;

    public Reserva(UUID idEspaco , LocalTime ini, LocalTime fim, String solicitante, String finalidade, int participantes, LocalDate dia) {
        this.idReserva = UUID.randomUUID();
        this.idEspaco = idEspaco;
        this.dia = dia;
        this.ini = ini;
        this.fim = fim;
        this.representate = solicitante;
        this.finalidade = finalidade;
        this.participantes = participantes;
    }

    public void setParticipantes(int participantes) {
        if (participantes >= 1){
            this.participantes = participantes;
        }else {
            System.out.println("Não é possivel criar uma reserva para menos de uma pessoa");
        }
    }

    public int getParticipantes() {
        return participantes;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getFim() {
        return fim;
    }

    public void setFim(LocalTime fim) {
        this.fim = fim;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public UUID getIdEspaco() {
        return idEspaco;
    }


    public UUID getIdReserva() {
        return idReserva;
    }

    public LocalTime getIni() {
        return ini;
    }

    public void setIni(LocalTime ini) {
        this.ini = ini;
    }

    public String getRepresentate() {
        return representate;
    }

    public void setRepresentate(String representate) {
        if (representate != null && representate.length() > 3){
            this.representate = representate;
        }
        else {
            System.out.println("Nome do representante é muito curto");
        }

    }

    @Override
    public String toString() {
        return "Reserva{" +
                "dia=" + dia +
                ", idEspaco=" + idEspaco +
                ", ini=" + ini +
                ", fim=" + fim +
                ", solicitante='" + representate + '\'' +
                ", finalidade='" + finalidade + '\'' +
                ", participantes=" + participantes +
                '}';
    }

    @Override
    public int compareTo(Reserva o) {
        int compDia = this.dia.compareTo(o.dia);
        if (compDia != 0) return compDia;
        int compIni = this.ini.compareTo(o.ini);
        if (compIni != 0) return compIni;
        return this.idReserva.compareTo(o.idReserva);
    }
}
