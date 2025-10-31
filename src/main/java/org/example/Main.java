package org.example;

import br.com.fiap.cp.*;

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Gestao gestao = new Gestao();
        Local localPadrao = new Local("Bloco A", "Andar 1");
        LocalDate hoje = LocalDate.now();

        Mesa mesa1 = new Mesa(localPadrao);
        Sala sala1 = new Sala(localPadrao);
        Auditorio auditorio1 = new Auditorio(localPadrao);

        gestao.addEspaco(mesa1);
        gestao.addEspaco(sala1);
        gestao.addEspaco(auditorio1);

        Reserva r1Base = new Reserva(mesa1.getId(),
                LocalTime.of(10, 0), LocalTime.of(11, 0),
                "Ana", "Reunião Rápida", 2, hoje);
        gestao.solicitarReserva(r1Base);

        Reserva r1Conflito = new Reserva(mesa1.getId(),
                LocalTime.of(10, 30), LocalTime.of(11, 30),
                "Bruno", "Conflito", 2, hoje);

        gestao.solicitarReserva(r1Conflito);

        auditorio1.setEmManutencao(true);

        Reserva r2Manutencao = new Reserva(auditorio1.getId(),
                LocalTime.of(14, 0), LocalTime.of(16, 0),
                "Carlos", "Palestra", 25, hoje);

        gestao.solicitarReserva(r2Manutencao);

        auditorio1.setEmManutencao(false);

        Reserva r3Teste = new Reserva(sala1.getId(),
                LocalTime.of(10, 0), LocalTime.of(11, 0),
                "Daniela", "Reunião de Sala", 5, hoje);
        gestao.solicitarReserva(r3Teste);

        mesa1.consultarAgenda(hoje);
        sala1.consultarAgenda(hoje);
        auditorio1.consultarAgenda(hoje);
    }
}


