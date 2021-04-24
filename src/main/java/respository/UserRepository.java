package respository;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtils;

import java.util.List;

public class UserRepository {

    public User findById(Integer userId) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        User user = session.find(User.class, userId);
        session.close();
        return user;
    }

    public void save(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public List<User> readAllUsers() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<User> selectAllUsers = session.createQuery("From User").list();
        transaction.commit();
        session.close();
        return selectAllUsers;
    }

    public void update(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }


    public User checkIfExists(String username, String password) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select u from User u where u.username = :username and u.password =:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        System.out.println(user);
        transaction.commit();
        session.close();
        return user;

    }


}
