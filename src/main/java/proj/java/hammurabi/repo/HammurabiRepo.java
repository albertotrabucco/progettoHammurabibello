package proj.java.hammurabi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.java.hammurabi.model.Hammurabi;

import java.util.Optional;

public interface HammurabiRepo extends JpaRepository<Hammurabi, Integer> {

    void deleteHammurabiById(int id);

    Optional<Hammurabi> findHammurabiById(int id);
}
