package proj.java.hammurabi.controller;

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

    @GetMapping("/all")
    public List<Turno> getAllTurni(){
        List<Turno> partita = turnoService.getAllTurni();
        return partita;
    }

    @GetMapping("/turno/{id}")
    public ResponseEntity<Turno> getTurnobyId(@PathVariable(value = "id") int id){
        Turno turni = turnoService.findTurnobyId(id);
        return new ResponseEntity<>(turni, HttpStatus.OK);
    }

    @PostMapping("/start")
    public ResponseEntity<Turno> startTurno(Turno turno){
        Turno newTurno = turnoService.startTurno(turno);
        return new ResponseEntity<>(turno, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Turno> updateTurno(@RequestBody Turno turno){
        Turno updateTurno = turnoService.updateTurno(turno);
        return new ResponseEntity<>(turno, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}") // rimuovere o rendere privato
    public ResponseEntity<?> deleteTurno(@PathVariable(value = "id") int id){
        turnoService.deleteTurno(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/next")
    public ResponseEntity<Turno> nextTurno(@RequestBody Turno turno){
        Turno newTurno = turnoService.nextTurno(turno);
        return new ResponseEntity<>(turno, HttpStatus.OK);
    }
}
