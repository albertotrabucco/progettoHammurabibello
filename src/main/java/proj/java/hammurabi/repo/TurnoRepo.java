package proj.java.hammurabi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.java.hammurabi.model.Turno;

import java.util.Random;

public interface TurnoRepo extends JpaRepository<Turno, Integer> {

    void deleteHammurabiById(int id);

    Turno findTurnoById(int id);

    //metodi per aumentare le risorse ogni turno, percentuali di default (in base alla difficoltà magari)
    static int popIncreased(int popolazione, int grano) {
        int aumPop = 0;                                            //valore di aumento della popolazione
        if(grano >= popolazione*2){                                //2 in questo caso è il costo di grano per sfamare una singola persona (può cambiare in base alla difficoltà)
            aumPop = Math.round((popolazione * 30)/100);           //la popolazione aumenta del 30% nel nuovo turno se è tutta sfamata

        }else{
            int popSfamata =  Math.round(grano/2) ;
            aumPop = (Math.round(((popSfamata)*20)/100) - (popolazione - popSfamata));
        }
        return aumPop;
    }
    //in angular mettere che il grano speso per comprare terreno venga scritto nel json di output dal form come terreno*5(esempio);
    static int granoIncreased(int grano, int terrPrecedente) {
        int aumGrano = 0;
        //ogni turno il grano aumenterà del (esempio) 5% per ogni terreno posseduto nel turno precedente
        int aumGranot = (Math.round((grano*5)/100))*terrPrecedente;
        if(aumGranot <= terrPrecedente){
            aumGrano = terrPrecedente;
        }else {
            aumGrano = aumGranot;
        }
        return aumGrano;
    }

    static int terrenoIncreased(int terrPrecedente, int terrAngular) {
        return terrPrecedente + terrAngular;
    }

    //metodi per eventi:
    static int eventPlague(int popPrecedente) {
        Random randGen = new Random();
        int probEvent = randGen.nextInt(100);
        int popAfterEvent = 0;
        if(probEvent >= 80){
            popAfterEvent = Math.round((popPrecedente * 80) / 100);
        }else{
            popAfterEvent = popPrecedente;
        }
        return popAfterEvent;
    }

    static int eventRats(int grPrecedente) {
        Random randGen = new Random();
        int probEvent = randGen.nextInt(100);
        int grAfterEvent = 0;
        if(probEvent >= 70){
            grAfterEvent =Math.round((grPrecedente * 70)/100);
        }else {
            grAfterEvent = grPrecedente;
        }
        return grAfterEvent;
    }
}
