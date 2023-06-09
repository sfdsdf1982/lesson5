package serialisation;

import java.io.*;

public class TestSerialisation {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Иванов","DevOps",150000);

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\1\\person.ser");//файл, в который упакуем объект
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);//объект с помощью которого упаковываем
        try {
            out.writeObject(person); //сохранение объекта в файле
        }finally {
            out.close();
            fileOutputStream.close();
        }
    }
}
