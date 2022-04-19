package proj.java.hammurabi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.java.hammurabi.model.Hammurabi;
import proj.java.hammurabi.repo.HammurabiRepo;

import java.util.List;

@Service
public class HammurabiService {

    private final HammurabiRepo hammurabiRepo;


    @Autowired
    public HammurabiService(HammurabiRepo hammurabiRepo){
        this.hammurabiRepo = hammurabiRepo;
    }

    /*GETDATA()*/
    public List<Hammurabi> findAllHammurabis(){
        return hammurabiRepo.findAll();
    }

    /*UPDATEDATA()*/
    public Hammurabi updateHammurabi(Hammurabi hammurabi){
        return hammurabiRepo.save(hammurabi);
    }

    /*DELETEDATA()byID*/
    public void deleteHammurabi(int id){
        hammurabiRepo.deleteHammurabiById(id);
    }

    /*SETDATA() turno1*/
    public Hammurabi addHammurabi(Hammurabi hammurabi){

        hammurabi.setPopolazione(10);
        hammurabi.setGrano(30);
        hammurabi.setTerreno(1);

        return hammurabiRepo.save(hammurabi);
    }
}
