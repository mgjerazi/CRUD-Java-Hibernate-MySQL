import Repository.ConsultRepository;
import Repository.PetRepository;
import Repository.UserRepository;
import model.Puppy;
import model.Reservation;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;
import org.hibernate.query.Query;

import java.time.LocalDateTime;


public class Application {

    public static void main(String[] args) {
        HibernateUtils.getSessionFactory();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();


        UserRepository userRepository= new UserRepository();
        User user = userRepository.findById(1);

        PetRepository petRepository=new PetRepository();
        Puppy puppy = petRepository.findById(1);


        ConsultRepository consultRepository = new ConsultRepository();
        Reservation reservation= new Reservation();
        reservation.setReservationId(1);
        reservation.setDateOfReservation(LocalDateTime.now());
        reservation.setPuppy(puppy);
        reservation.setUser(user);
        reservation.setDescription("VAKSINE");
       /* consultRepository.createReservation(reservation);*/


        consultRepository.readAllReservation().forEach(System.out::println);

        reservation.setDescription("Gjilpere");
        consultRepository.updateReservation(reservation);


        consultRepository.deleteReservation(reservation);

        Reservation reservation1 = consultRepository.findConsultById(1);
        System.out.println(reservation1);





        transaction.commit();
        session.close();



    }

}
