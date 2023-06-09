import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateStudent {
    public static void main(String[] args) {
//        1) Настраиваем коннект к базе, получая объект factory
//        2) Для выполнения запросов к базе создаем объект Session через объект factory


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();//теперь можно через session делать запросы

            Student student1 = new Student("Олег", "Петров", "test1@mail.ru");
            Student student2 = new Student("Петр", "Романов", "test2@mail.ru");
            Student student3 = new Student("Андрей", "Сидоров", "test3@mail.ru");

            List<Student> studentList = new ArrayList<>();
            Collections.addAll(studentList,student1,student2,student3);


            session.beginTransaction();
            for (Student student : studentList) {
                session.save(student);//здесь выполняется вставка новой строки в таблицу
            }
            session.getTransaction().commit();//для сохранения записи в таблице

        } finally {
            factory.close();
            session.close();
        }

    }
}
