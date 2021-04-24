package respository;

import model.Clinic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtils;

public class ClinicRepository {

    public Clinic findById(Integer clinicId) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Clinic clinic = session.find(Clinic.class, clinicId);
        session.close();
        return clinic;
    }

}
