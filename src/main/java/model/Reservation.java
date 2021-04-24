package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;
    private LocalDateTime dateOfReservation;
    private String description;

    @ManyToOne
    @JoinColumn(name = "vetId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "puppyId")
    private Puppy puppy;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Puppy getPuppy() {
        return puppy;
    }

    public void setPuppy(Puppy puppy) {
        this.puppy = puppy;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDateTime getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(LocalDateTime dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", dateOfReservation=" + dateOfReservation +
                ", description=" + description +
                '}';
    }
}
