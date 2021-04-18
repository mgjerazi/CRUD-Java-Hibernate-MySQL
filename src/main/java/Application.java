import org.hibernate.Session;
import util.HibernateUtils;
import org.hibernate.query.Query;


public class Application {

    public static void main(String[] args) {
        HibernateUtils.getSessionFactory();
        Session session = HibernateUtils.getSessionFactory().openSession();
    }

}
