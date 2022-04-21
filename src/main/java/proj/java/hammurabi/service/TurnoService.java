package proj.java.hammurabi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.java.hammurabi.model.Turno;
import proj.java.hammurabi.repo.TurnoRepo;


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

    //da fare
    //metodo di continue al nuovo turno con utilizzo dei metodi dei vari eventi e incremento e decremento delle risorse
    public Turno nextTurno(Turno valoriAngular) {
        Turno nuovoTurno = new Turno();
        updateTurno(nuovoTurno);
        Turno turnoPrecedente = turnoRepo.findTurnoById(nuovoTurno.getId()-1);

        nuovoTurno.setPopolazione(((turnoPrecedente.getPopolazione() - valoriAngular.getPopolazione())
                - TurnoRepo.eventPlague(turnoPrecedente.getPopolazione()))
                + TurnoRepo.popIncreased(TurnoRepo.eventPlague(turnoPrecedente.getPopolazione()), turnoPrecedente.getGrano()));

        nuovoTurno.setGrano((turnoPrecedente.getGrano() - TurnoRepo.eventRats(turnoPrecedente.getGrano()))
                + TurnoRepo.granoIncreased(TurnoRepo.eventRats(turnoPrecedente.getGrano()), turnoPrecedente.getPopolazione(), valoriAngular.getTerreno()));


        nuovoTurno.setTerreno(turnoPrecedente.getTerreno() + valoriAngular.getTerreno());


        return turnoRepo.save(nuovoTurno);
    }
}
