package ua.goit.java8.hw10;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Planet {

    @Id
    private String id;

    private String name;

    @ManyToMany(mappedBy = "fromPlanet")
    private List<Ticket> fromPlanetTickets;

    @ManyToMany(mappedBy = "toPlanet")
    private List<Ticket> toPlanetTickets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Ticket> getFromPlanetTickets() {
        return fromPlanetTickets;
    }

    public void setFromPlanetTickets(List<Ticket> fromPlanetTickets) {
        this.fromPlanetTickets = fromPlanetTickets;
    }

    public List<Ticket> getToPlanetTickets() {
        return toPlanetTickets;
    }

    public void setToPlanetTickets(List<Ticket> toPlanetTickets) {
        this.toPlanetTickets = toPlanetTickets;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
