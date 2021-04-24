package respository;

import model.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.util.List;

public class ReviewRepository {

    public Review findById(Integer reviewId) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Review review = session.find(Review.class, reviewId);
        session.close();
        return review;
    }

    public void save(Review review) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(review);
        transaction.commit();
        session.close();
    }

    public List<Review> readAllReviews() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Review> selectAllReviews = session.createQuery("From Review").list();
        transaction.commit();
        session.close();
        return selectAllReviews;
    }

    public void update(Review review) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(review);
        transaction.commit();
        session.close();
    }

    public void delete(Review review) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(review);
        transaction.commit();
        session.close();
    }

}
