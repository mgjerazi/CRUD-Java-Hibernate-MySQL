import model.Puppy;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import respository.PetRespository;
import respository.UserRepository;
import util.HibernateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;


public class Application {

    public static void main(String[] args) {
        HibernateUtils.getSessionFactory();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        /*
        create new pet
        UserRepository userRepository = new UserRepository();
        User user = userRepository.findById(1);
        System.out.println(user);

        PetRespository petRespository = new PetRespository();
        Puppy puppy = new Puppy();
        puppy.setPuppyId(6);
        puppy.setName("jojo");
        puppy.setRace("gold retriever");
        puppy.setDateOfBirth(LocalDateTime.of(LocalDate.of(2020, Month.JANUARY,01), LocalTime.now()));
        puppy.setVaccinated(true);
        puppy.setUser(user);
        petRespository.createPuppy(puppy);

         */

        /*
        read all puppies
        PetRespository petRespository = new PetRespository();
        petRespository.readAllPuppies().forEach(System.out::println);
         */

        /*
        delete puppy
        PetRespository petRespository = new PetRespository();
        Puppy puppy = session.find(Puppy.class,3);
        petRespository.deletePuppy(puppy);
        */

        /*
        update table
        PetRespository petRespository = new PetRespository();
        Puppy puppy = session.find(Puppy.class,3);
        puppy.setName("buci");
        petRespository.updatePuppy(puppy);

         */


        /*
        find if puppy exists
        PetRespository petRespository = new PetRespository();
        Puppy puppy = petRespository.findPuppyById(1);
        System.out.println(puppy);
        */




        transaction.commit();
        session.close();
    }

}
