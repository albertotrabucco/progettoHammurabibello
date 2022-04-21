package proj.java.hammurabi.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/*
@Entity
public class ListaPartite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "partita", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Turno> partite = new HashSet<>();

    private boolean status;


    public ListaPartite() {
    }

    public ListaPartite(int id, Set<Turno> partite, boolean status) {
        this.id = id;
        this.partite = partite;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Set<Turno> getPartite() {
        return partite;
    }

    public void setPartite(Set<Turno> partite) {
        this.partite = partite;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ListaPartite{" +
                "id=" + id +
                ", partite=" + partite +
                ", status=" + status +
                '}';
    }


}
*/
