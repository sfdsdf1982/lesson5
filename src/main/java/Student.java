import javax.persistence.*;

//Требования к Entity классам - они должны быть бинами. Бин это класс, в котором обязательно
//наличие приватных полей класса, наличие публичных геттеров и сеттеров для каждого поля и наличие
//пустого конструктора без параметров

@Entity
@Table(name = "student")
public class Student {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Данный метод вызывается при выводе объекта
     * @return
     */
    @Override
    public String toString() {
        return "Студент " + firstName + " " + lastName + " имеет email " + email;
    }
}
