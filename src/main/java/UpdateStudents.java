import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudents {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("UPDATE Student SET email='demo@list.ru' where id=3").executeUpdate();//получили всех студентов из таблицы
            session.getTransaction().commit();
        }finally {
            factory.close();
            session.close();
        }
    }
}
