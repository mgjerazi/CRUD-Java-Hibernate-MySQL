package Repository;

import model.Reservation;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.util.List;

public class ConsultRepository {

    public void createReservation (Reservation reservation){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(reservation);
        transaction.commit();
        session.close();
    }


public List<Reservation> readAllReservation(){
    Session session = HibernateUtils.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    List<Reservation> selectAllReviews = session.createQuery("From Reservation").list();
    transaction.commit();
    session.close();
    return selectAllReviews;
}
    public void updateReservation(Reservation reservation){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(reservation);
        transaction.commit();
        session.close();
    }

    public void deleteReservation(Reservation reservation){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(reservation);
        transaction.commit();
        session.close();
    }

    public Reservation  findConsultById(Integer reservationId) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Reservation reservation= session.find(Reservation.class, reservationId);
        session.close();
        return reservation;

    }
}
