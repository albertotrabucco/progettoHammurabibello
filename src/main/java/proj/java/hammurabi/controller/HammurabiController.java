package proj.java.hammurabi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.java.hammurabi.model.Hammurabi;
import proj.java.hammurabi.service.HammurabiService;

import java.util.List;

@RestController
@RequestMapping("/hammurabi")
public class HammurabiController {
    private final HammurabiService hammurabiService;

    public HammurabiController(HammurabiService hammurabiService){
        this.hammurabiService = hammurabiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hammurabi>> getAllHammurabis(){
        List<Hammurabi> hammurabis = hammurabiService.findAllHammurabis();
        return new ResponseEntity<>(hammurabis, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Hammurabi> addHammurabi(Hammurabi hammurabi){
        Hammurabi newHammurabi = hammurabiService.addHammurabi(hammurabi);
        return new ResponseEntity<>(hammurabi, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Hammurabi> updateHammurabi(@RequestBody Hammurabi hammurabi){
        Hammurabi updateHammurabi = hammurabiService.updateHammurabi(hammurabi);
        return new ResponseEntity<>(hammurabi, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHammurabi(@PathVariable("id") int id){
        hammurabiService.deleteHammurabi(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
