import model.User;
import model.Clinic;
import model.Review;
import respository.ConsultRepository;
import respository.PetRepository;
import Repository.UserRepository;
import model.Puppy;
import model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import respository.ClinicRepository;
import respository.ReviewRepository;
import respository.UserRepository;
import repository.ClinicRepository;
import repository.ReviewRepository;
import repository.UserRepository;
import respository.UserRepository;
import util.HibernateUtils;


import java.time.LocalDateTime;


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


        UserRepository userRepository = new UserRepository();
        User user = userRepository.findById(4);
        System.out.println(user);

        ClinicRepository clinicRepository = new ClinicRepository();
        Clinic clinic = clinicRepository.findById(1);
        System.out.println(clinic);


        ReviewRepository reviewRepository = new ReviewRepository();
        Review review1 = new Review();
        System.out.println(review1);


        //Task1 per Review
        System.out.println("Task1 per REVIEW");

        review1.setReview("Klienti u paraqit");
        review1.setReviewId(1);
        review1.setGrade(20);
        review1.setUser(user);
        review1.setClinic(clinic);

        reviewRepository.save(review1);

        //Task1 per  User
        System.out.println("Task1 per USER");
        UserRepository userRepository1 = new UserRepository();
        User user1 = new User();
        user1.setUserId(1);
        user1.setFirstName("filan1");
        user1.setLastName("fisteku1");
        user1.setUsername("ffisteku1");
        user1.setPassword("filan1");
        user1.setPhone("123655665655");
        user1.setEmail("filanfisteku@kot.com");
        userRepository.save(user1);


        //Task2 Read all the review stored
        System.out.println("Task2");
        userRepository.readAllUsers().forEach(System.out::println);
        reviewRepository.readAllReviews().forEach(System.out::println);


        //Task3
        System.out.println("Task3");


        //task3 per user2
        user.setPassword("admin1");
        userRepository.update(user);

        //task 3 per review
        review1.setGrade(50);
        reviewRepository.update(review1);


        //Task4 per User dhe Delete
        System.out.println("Task4");
//        userRepository.delete(user);

        //Delete reviews on the database
//        Review review5 = session.find(Review.class, 5);
//        reviewRepository.delete(review5);

//        reviewRepository.delete(review1);

        //Additional
        System.out.println("Additional");
        userRepository1.checkIfExists("lbulku", "admin1");
        transaction.commit();
        session.close();


        User user2 = userRepository.findById(1);

        PetRepository petRepository=new PetRepository();
        Puppy puppy = petRepository.findById(1);


        ConsultRepository consultRepository = new ConsultRepository();
        Reservation reservation= new Reservation();
        reservation.setReservationId(1);
        reservation.setDateOfReservation(LocalDateTime.now());
        reservation.setPuppy(puppy);
        reservation.setUser(user2);
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
