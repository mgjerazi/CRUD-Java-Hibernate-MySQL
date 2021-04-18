package util;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();

                configuration.addAnnotatedClass(Clinic.class);
                configuration.addAnnotatedClass(Puppy.class);
                configuration.addAnnotatedClass(Reservation.class);
                configuration.addAnnotatedClass(Review.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                ;
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }
        } catch (Exception e) {

            System.out.println("Lidhja Eshte masaker");
            e.printStackTrace();
        }
        return sessionFactory;
    }
}