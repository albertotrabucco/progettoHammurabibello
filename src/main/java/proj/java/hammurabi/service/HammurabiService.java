package proj.java.hammurabi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.java.hammurabi.model.Hammurabi;
import proj.java.hammurabi.model.MockPlayer;
import proj.java.hammurabi.repo.HammurabiRepo;
import proj.java.hammurabi.repo.MockPlayerRepo;

import java.util.List;

@Service
public class HammurabiService {

    private final HammurabiRepo hammurabiRepo;
    private final MockPlayerRepo mockPlayerRepo;

    @Autowired
    public HammurabiService(HammurabiRepo hammurabiRepo, MockPlayerRepo mockPlayerRepo){
        this.hammurabiRepo = hammurabiRepo;
        this.mockPlayerRepo = mockPlayerRepo;
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
    public MockPlayer addMockPlayer(MockPlayer mockPlayer){
        mockPlayer.setPopolazione(10);
        mockPlayer.setGrano(30);
        mockPlayer.setTerreno(1);
        return mockPlayerRepo.save(mockPlayer);
    }
}
