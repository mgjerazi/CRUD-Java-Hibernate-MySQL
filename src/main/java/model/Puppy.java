package model;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "puppies")
public class Puppy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer puppyId;
    private String name;
    private String race;
    private LocalDateTime dateOfBirth;
    @Column(name = "isVacinated",columnDefinition = "TINYINT")
    private boolean isVaccinated;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private User user;

    @OneToMany(mappedBy = "puppy")
    private Set<Reservation> reservations=new HashSet<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Integer getPuppyId() {
        return puppyId;
    }



    public void setPuppyId(Integer puppyId) {
        this.puppyId = puppyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    @Override
    public String toString() {
        return "Puppy{" +
                "puppyId=" + puppyId +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", isVaccinated=" + isVaccinated +
                '}';
    }
}
