package proj.java.hammurabi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Hammurabi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;
    private int popolazione;
    private int grano;
    private int terreno;

    public Hammurabi() {
    }

    public Hammurabi(int id, int popolazione, int grano, int terreno) {
        this.id = id;
        this.popolazione = popolazione;
        this.grano = grano;
        this.terreno = terreno;
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

    @Override
    public String toString() {
        return "Hammurabi{" +
                "id=" + id +
                ", popolazione=" + popolazione +
                ", grano=" + grano +
                ", terreno=" + terreno +
                '}';
    }
}
