package respository;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

public class UserRepository {
    public User findById(Integer userId) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        User user = session.find(User.class, userId);
        session.close();
        return user;
    }
}
