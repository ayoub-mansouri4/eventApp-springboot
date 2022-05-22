package springboot_auth.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "participants")
public class Participant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_participant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_event", nullable = false)
    @JsonIgnoreProperties("participants")
    private Event event;

    public Participant(){}

    public Participant(Long id_participant, Event event) {
        this.id_participant = id_participant;
        this.event = event;
    }

    public Long getId_participant() {
        return id_participant;
    }

    public void setId_participant(Long id_participant) {
        this.id_participant = id_participant;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
