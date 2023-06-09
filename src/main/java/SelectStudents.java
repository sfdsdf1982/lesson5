import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SelectStudents {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Student> list = session.createQuery("FROM Student").getResultList();//получили всех студентов из таблицы
            for (Student student : list) {
                System.out.println(student);
            }
        }finally {
            factory.close();
            session.close();
        }
    }
}
