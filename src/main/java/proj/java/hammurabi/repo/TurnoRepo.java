package proj.java.hammurabi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.java.hammurabi.model.Turno;

public interface TurnoRepo extends JpaRepository<Turno, Integer> {




    void deleteHammurabiById(int id);

    Turno findTurnoById(int id);

    //metodi per aumentare le risorse ogni turno, percentuali di default (in base alla difficoltà magari)
    static int popIncreased(int popolazione, int grano) {
        int aumPop = 0;         //valore di aumento della popolazione
        if(grano == popolazione*2){ //2 in questo caso è il costo di grano per sfamare una singola persona (può cambiare in base alla difficoltà)
            //la popolazione aumenta del 25% nel nuovo turno se è tutta sfamata
            aumPop = (popolazione * 20)/100;
        }
        return aumPop;
    }

    static int granoIncreased(int grano, int popolazione, int terreno) { //in angular mettere che il grano speso per comprare terreno venga scritto nel json di output dal form come terreno*5(esempio eh);
        int aumGrano = 0;
        if(grano == popolazione*2){

        }
    }


    //metodi per eventi:
    static int eventPlague(int popPrecedente) {
        return 0;
    }
    static int eventRats(int grano) {
        return 0;
    }
}
