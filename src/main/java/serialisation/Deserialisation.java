package serialisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialisation {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = null;
        var file = new FileInputStream("C:\\1\\person.ser");
        var in = new ObjectInputStream(file);
        person = (Person) in.readObject();//получили из файла объект и его преобразовали к Person
        person.showInfo();
        in.close();
        file.close();

    }
}
