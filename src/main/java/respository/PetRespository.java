package respository;

import model.Puppy;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.util.List;

public class PetRespository {
    public void createPuppy(Puppy puppy){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(puppy);
        transaction.commit();
        session.close();
    }

    public List<Puppy> readAllPuppies(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Puppy> selectAllReviews = session.createQuery("From Puppy").list();
        transaction.commit();
        session.close();
        return selectAllReviews;
    }

    public void updatePuppy(Puppy puppy){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(puppy);
        transaction.commit();
        session.close();
    }

    public void deletePuppy(Puppy puppy){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(puppy);
        transaction.commit();
        session.close();
    }

    public Puppy findPuppyById(Integer puppyId) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Puppy puppy = session.find(Puppy.class, puppyId);
        session.close();
        return puppy;
    }
}
