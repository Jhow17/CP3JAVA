package br.com.fiap.cp;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Gestao {
    private Map<UUID, Espaco> espacos = new HashMap<>();

    public void addEspaco(Espaco newEspaco){
        if(newEspaco != null){
            espacos.put(newEspaco.getId(), newEspaco);
            System.out.println("Espaço ID " + newEspaco.getId() + " adicionado ao sistema.");
        } else {
            System.out.println("Sem espaço para ser adicionado");
        }



    }

    public void solicitarReserva(Reserva newReserva){
        Espaco espacoLivre ;
        if (newReserva != null & newReserva.getParticipantes() > 1){
            if (newReserva.getParticipantes() <= 2 ){
                espacoLivre = this.buscarEspaco("Mesa", newReserva);
                if (espacoLivre != null){
                    espacoLivre.addReserva(newReserva);
                }
                else {
                    System.out.println("Nenhum espaço disponivel para a requisição");
                }
            }
            else if (newReserva.getParticipantes() <= 8){
                espacoLivre = this.buscarEspaco("Sala",newReserva);
                if (espacoLivre != null){
                    espacoLivre.addReserva(newReserva);
                }
                else {
                    System.out.println("Nenhum espaço disponivel para a requisição");
                }
            }
            else if (newReserva.getParticipantes() <= 30){
                espacoLivre =  this.buscarEspaco("Auditorio",newReserva);
                if (espacoLivre != null){
                    espacoLivre.addReserva(newReserva);
                }
                else {
                    System.out.println("Nenhum espaço disponivel para a requisição");
                }
            }


        }

    }

    private void sugerirEspaco(){

    }

    private Espaco buscarEspaco(String tipo, Reserva reservaInfo){
        for (Map.Entry<UUID, Espaco> entry : espacos.entrySet()){
            if(entry.getValue().getTipo().equals(tipo)){
                if (entry.getValue().isFree(reservaInfo.getIni(), reservaInfo.getFim(), reservaInfo.getDia())){
                    return entry.getValue();
                }
            }
        }

        return null;
    }

}
