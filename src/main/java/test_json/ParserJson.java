package test_json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class ParserJson {
    public static void main(String[] args) throws IOException, ParseException {
        var reader = new FileReader("store.json");//объект, в котором хранится наш файл
        JSONParser jsonParser = new JSONParser();//с помощью этого объекта преобразуем строку в объект Json
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);//преобразовали json нашего файла в объект
        System.out.println("Название компании: " + jsonObject.get("title"));//получаем значения по ключу

//        Получение массива из json
        JSONArray cars = (JSONArray) jsonObject.get("cars");
//        1ый вариант
        for (int i = 0; i < cars.size(); i++) {
            System.out.println((i + 1) + ") " + ((JSONObject)cars.get(i)).get("name"));
        }
//        2ой вариант - через итератор

        Iterator i = cars.iterator();//создали объект перечислитель
//        У итератора есть полезные методы для обхода элемента - next - для получения элемента
        while (i.hasNext()){//пока есть, что перебирать
            JSONObject car = (JSONObject) i.next();//получаем каждую машину
            System.out.println("Авто " + car.get("name") + " стоит " + car.get("price"));
        }

        JSONObject contacts = (JSONObject)jsonObject.get("contacts");
        System.out.println(contacts.get("phone"));
    }
}
