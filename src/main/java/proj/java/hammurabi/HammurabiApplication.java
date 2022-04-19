package proj.java.hammurabi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import proj.java.hammurabi.model.Hammurabi;

@SpringBootApplication
public class HammurabiApplication {

        public static void main(String[] args) {
            SpringApplication.run(Hammurabi.class, args);
        }
}
