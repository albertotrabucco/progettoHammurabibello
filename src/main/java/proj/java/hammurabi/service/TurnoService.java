package proj.java.hammurabi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.java.hammurabi.model.Turno;
import proj.java.hammurabi.repo.TurnoRepo;

import java.util.List;


@Service
public class TurnoService {

    private final TurnoRepo turnoRepo;




    @Autowired
    public TurnoService(TurnoRepo turnoRepo){
        this.turnoRepo = turnoRepo;
    }

    /*GETDATA()*/
    public Turno findTurnobyId(int id){
        return turnoRepo.findTurnoById(id);
    }
    
    public List<Turno> getAllTurni(){return turnoRepo.findAll();}

    /*UPDATEDATA()*/
    public Turno updateTurno(Turno turno){
        return turnoRepo.save(turno);
    }

    /*DELETEDATA()byID*/
    public void deleteTurno(int id){
        turnoRepo.deleteHammurabiById(id);
    }

    /*SETDATA() turno1*/
    public Turno startTurno(Turno turno){

        turno.setPopolazione(10);
        turno.setGrano(30);
        turno.setTerreno(1);

        return turnoRepo.save(turno);
    }

    //metodo di continue al nuovo turno con utilizzo dei metodi dei vari eventi e incremento e decremento delle risorse
    public Turno nextTurno(Turno valoriAngular) {
        Turno nuovoTurno = new Turno();
        updateTurno(nuovoTurno);
        Turno turnoPrecedente = turnoRepo.findTurnoById(nuovoTurno.getId()-1);

        //dati per i calcoli
        int popPrecedente = turnoPrecedente.getPopolazione();
        int popAngular = valoriAngular.getPopolazione();
        int grPrecedente = turnoPrecedente.getGrano();
        int grAngular = valoriAngular.getGrano();
        int terrPrecedente = turnoPrecedente.getTerreno();
        int terrAngular = valoriAngular.getTerreno();

        //calcoli popolazione
        int resultPop = popPrecedente - popAngular;
        resultPop = TurnoRepo.eventPlague(resultPop);
        int finalPop = resultPop + TurnoRepo.popIncreased(resultPop, grPrecedente);

        //calcoli grano
        int resultGr = grPrecedente - grAngular;        //grAngular = su angular fare in modo che il
        resultGr = TurnoRepo.eventRats(resultGr);       //grano usato per comprare terreno e sfamare la pop vengano sommati
        int finalGr = resultGr + TurnoRepo.granoIncreased(resultGr, popAngular, terrPrecedente,terrAngular);                                  // in un singolo dato prima di essere mandato in post tramite form

        //calcoli terreno -> non diminuiscono mai
        int finalTerr = TurnoRepo.terrenoIncreased(terrPrecedente, terrAngular);

        //set dei nuovi dati
        nuovoTurno.setPopolazione(finalPop);
        nuovoTurno.setGrano(finalGr);
        nuovoTurno.setTerreno(finalTerr);

        return turnoRepo.save(nuovoTurno);
    }
}
