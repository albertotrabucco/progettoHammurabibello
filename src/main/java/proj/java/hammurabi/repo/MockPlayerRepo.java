package proj.java.hammurabi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.java.hammurabi.model.Hammurabi;
import proj.java.hammurabi.model.MockPlayer;

import java.util.Optional;

public interface MockPlayerRepo extends JpaRepository<MockPlayer, Integer> {

}
