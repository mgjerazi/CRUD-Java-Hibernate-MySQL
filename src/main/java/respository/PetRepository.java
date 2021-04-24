package respository;

import model.Puppy;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

public class PetRepository {
    public Puppy findById(Integer puppyId) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
       Puppy puppy= session.find(Puppy.class, puppyId);
       session.close();
       return puppy;

    }
}
