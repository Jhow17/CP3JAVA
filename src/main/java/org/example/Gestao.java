package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Gestao {
    private final Map<String, Espaco> espacos = new HashMap<>();

    public void registraEspaco(Espaco novoEspaco) {
        if (novoEspaco != null && !espacos.containsKey(novoEspaco.getNome())) {
            espacos.put(novoEspaco.getNome(), novoEspaco);
        }
    }

    public class RegistraAgenda {
        private final int id;
        private final int mesa;
        private final String espaco;
        private final int capacidade;
        private final String reserva;
        private final String participante;
        private final int numParticipantes;
        private final int dataVerificar;
        private boolean agendaAtiva;
        private static final Set<String> reservasRegistradas = new HashSet<>();

        public RegistraAgenda(int id, int mesa, String reserva, String espaco, int dataVerificar,
                              String participante, int numParticipantes, int capacidade) {
            this.id = id;
            this.mesa = mesa;
            this.reserva = reserva;
            this.espaco = espaco;
            this.dataVerificar = dataVerificar;
            this.participante = participante;
            this.numParticipantes = numParticipantes;
            this.capacidade = capacidade;
            this.agendaAtiva = true;
        }

        public boolean registrarAgenda() {
            if (!agendaAtiva) {
                return false;
            }
            if (numParticipantes > capacidade) {
                return false;
            }
            if (reserva == null || reserva.isEmpty()) {
                return false;
            }
            if (mesa <= 0) {
                return false;
            }
            if (dataVerificar <= 0) {
                return false;
            }
            String chave = espaco + "-" + dataVerificar;
            if (reservasRegistradas.contains(chave)) {
                return false;
            }
            reservasRegistradas.add(chave);
            return true;
        }

            public int getId() { return id; }
            public String getEspaco() { return espaco; }
            public boolean isAgendaAtiva() { return agendaAtiva; }
            public void setAgendaAtiva(boolean status) { this.agendaAtiva = status; }
        }



    }
