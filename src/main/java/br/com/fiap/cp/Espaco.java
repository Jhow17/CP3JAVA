package br.com.fiap.cp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Iterator;

abstract public class Espaco {
    private final UUID id ;
    private Local localizacao;
    private final int capacidade;
    private final Set<Reserva> agenda;
    private final String tipo;
    private boolean emManutencao = false;


    public Espaco(Local localizacao, int capacidade, String tipo) {
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.agenda = new TreeSet<>();
        this.id = UUID.randomUUID();
        this.tipo = tipo;
    }

    public boolean isEmManutencao() {
        return emManutencao;
    }

    public void setEmManutencao(boolean emManutencao) {
        this.emManutencao = emManutencao;
        System.out.println("LOG: Espaço " + this.tipo + " (ID: " + this.id.toString().substring(0, 4) + ") alterado para Manutenção: " + emManutencao);
    }

    public Local getLocalizacao() {

        return localizacao;
    }

    public UUID getId() {

        return id;
    }

    public int getCapacidade() {

        return capacidade;
    }


    public String getTipo() {
        return tipo;
    }

    public Set<Reserva> getAgenda() {
        return agenda;
    }

    public boolean isFree(LocalTime iniVerificar, LocalTime fimVerificar, LocalDate diaVeri){

        if (this.emManutencao) {
            return false;
        }

        for (Reserva r : agenda){
            // sobreposicao de intervalos
           if (r.getDia().equals(diaVeri)){
               if (!(r.getFim().isBefore(iniVerificar) || fimVerificar.isBefore(r.getIni()))){
                   return false;
               }
           }
        }
        return true;

    }

    public void addReserva(Reserva novaReserva){
        if (isFree(novaReserva.getIni(), novaReserva.getFim(), novaReserva.getDia())){
            this.agenda.add(novaReserva);
            System.out.println("Reserva adicionada com sucesso");
        }
        else {
            System.out.println("Não é Possivel reservar o espaço nessa Data");
        }



    }



    public void cancelaReserva(UUID idReser){

        Boolean removido = false;
        Iterator<Reserva> iterador = agenda.iterator();

        while(iterador.hasNext()){
           Reserva r = iterador.next();
           if (r.getIdReserva().equals(idReser)){
               iterador.remove();
               removido = true;
               break;
           }
       }
       if(removido){
           System.out.println("Reserva removida com sucesso!");
       }
       else {
           System.out.println("Reserva não encontrada");

       }

    }

    public void consultarAgenda(LocalDate reservasDia){

        System.out.println("Consultando Agenda para: " + reservasDia);
        boolean encontrou = false;
        for (Reserva r : agenda) {
            if (r.getDia().equals(reservasDia)) {
                System.out.println(r.toString());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma reserva encontrada para esta data.");
        }
    }

}
