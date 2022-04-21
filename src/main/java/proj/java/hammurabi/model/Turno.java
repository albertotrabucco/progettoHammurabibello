package proj.java.hammurabi.model;

import javax.persistence.*;
import java.io.Serializable;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table(name="partita")
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;
    private int popolazione;
    private int grano;
    private int terreno;
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ListaPartite_partite")
    private ListaPartite partita;
    */
    public Turno() {
    }

    public Turno(int id, int popolazione, int grano, int terreno/*, ListaPartite partita*/) {
        this.id = id;
        this.popolazione = popolazione;
        this.grano = grano;
        this.terreno = terreno;
        /*this.partita = partita;*/
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopolazione() {
        return popolazione;
    }

    public void setPopolazione(int popolazione) {
        this.popolazione = popolazione;
    }

    public int getGrano() {
        return grano;
    }

    public void setGrano(int grano) {
        this.grano = grano;
    }

    public int getTerreno() {
        return terreno;
    }

    public void setTerreno(int terreno) {
        this.terreno = terreno;
    }

    /*public ListaPartite getPartita() {
        return partita;
    }

    public void setPartita(ListaPartite partita) {
        this.partita = partita;
    }*/
    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", popolazione=" + popolazione +
                ", grano=" + grano +
                ", terreno=" + terreno +
                /*", partita=" + partita +*/
                '}';
    }


}
