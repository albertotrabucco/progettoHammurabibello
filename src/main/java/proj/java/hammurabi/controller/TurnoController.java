package proj.java.hammurabi.controller;


import nonapi.io.github.classgraph.json.JSONSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.java.hammurabi.model.Turno;
import proj.java.hammurabi.service.TurnoService;

import java.util.List;

@RestController
@RequestMapping("/hammurabi")
public class TurnoController {
    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService){
        this.turnoService = turnoService;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Turno> getAllTurni(){
        List<Turno> partita = turnoService.getAllTurni();
        return partita;
    }

    @RequestMapping(value = "/turno/{id}", method = RequestMethod.GET)
    public ResponseEntity<Turno> getTurnobyId(@PathVariable(value = "id") int id){
        Turno turni = turnoService.findTurnobyId(id);
        return new ResponseEntity<>(turni, HttpStatus.OK);
    }

    @RequestMapping(value =  "/start", method = RequestMethod.POST)
    public ResponseEntity<Turno> startTurno(Turno turno){
        Turno newTurno = turnoService.startTurno(turno);
        return new ResponseEntity<>(newTurno, HttpStatus.OK);
    }

    @RequestMapping(value = "/next", method = RequestMethod.POST)
    public ResponseEntity nextTurno(@RequestBody Turno turno){
        Turno newTurno = turnoService.nextTurno(turno);
        List<Turno> finePartita = turnoService.getAllTurni();
        String json = JSONSerializer.serializeObject(finePartita, 1, false);
        String vinto = "Hai Vinto!" +"\n"+ json;
        String perso = "Hai Perso!" +"\n"+ json;
        Turno turnoPrec = turnoService.findTurnobyId(newTurno.getId()-2);
        if(newTurno.getId() >= 10 && turnoPrec.getPopolazione() != 0) {
            return new ResponseEntity(vinto, HttpStatus.OK);
        } else if(turnoPrec.getPopolazione() <= 0 && newTurno.getId() != 10) {
            return new ResponseEntity(perso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(newTurno, HttpStatus.OK);
        }
    }


}
