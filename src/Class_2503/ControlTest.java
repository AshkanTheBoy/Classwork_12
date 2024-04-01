package Class_2503;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ControlTest {

@Test
    public void test1a() throws IOException {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1", "b1");
        // Проверить первый элемент коллекции,
    String first = collection.stream()
            .findFirst()
            .orElse(null);

        // последний элемент коллекции,
    String last = collection.stream()
            .skip(collection.size()-1)
            .findAny()
            .orElse(null);

        // число элементов,
    long count = collection.stream()
            .count();

        // проверить, существует ли элемент
    String find = collection.stream()
            .filter("a3"::equals)
            .findFirst()
            .get();

        //Выбрать элемент по шаблону regex, чтобы строка начиналась на 'b'
    List<String> selected = collection.stream()
            .filter(s-> Pattern.compile("b.*").matcher(s).matches())
            .collect(Collectors.toList());
    List<String> res = Arrays.asList("b1");
    Assertions.assertAll("",
            () -> Assertions.assertEquals(first, "a1"),
            () -> Assertions.assertEquals(last, "b1"),
            () -> Assertions.assertEquals(count, collection.size()),
            () -> Assertions.assertEquals(find, "a3"),
            () -> Assertions.assertEquals(selected, res)
    );

}

    @Test
    public void test1() throws IOException {
        //Используя stream, записать в файл последовательность строк "a1,b2,c3,d4...z26"
        File file = new File("src/Class_2503/data.txt");
        PrintWriter out = new PrintWriter(file);
        IntStream.rangeClosed(1,26)
                .mapToObj(i->new StringBuilder()
                        .append(Character.toString(i+'a'-1))
                        .append(i)
                        .toString())
                .forEach(out::println);
        out.close();

        //Прочитать данные из файла. Проверить первую и последнюю записанные строки
        List<String> strings = Files.lines(Paths.get("src/Class_2503/data.txt"))
                .collect(Collectors.toList());
    }

    @Test
    public void test1b() throws IOException {
        // Выбрать мужчин от 20 до 30 лет
        List<Person> men = Person.persons.stream()
                .filter(p->p.getAge()>=20
                        &&p.getAge()<=30
                        &&p.getSex()== Person.Sex.MAN)
                .collect(Collectors.toList());
        //System.out.println(men.size());

        // Найти средний возраст среди мужчин
        double meanAge = Person.persons.stream()
                .filter(p->p.getSex()== Person.Sex.MAN)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        //System.out.println(meanAge);

        // Найти количество трудоспособных (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
        long count = Person.persons.stream()
                .filter(p->p.getAge()>=18)
                .filter(p->(p.getSex()== Person.Sex.WOMAN&&p.getAge()<55)
                        ||(p.getSex()== Person.Sex.MAN&&p.getAge()<60))
                .count();
        //System.out.println(count);

        // Найти человека с максимальным возрастом
        Person theOldest = Person.persons.stream()
                .max(Comparator.comparing(Person::getAge))
                .get();
        //System.out.println(theOldest.toString());

        // Отсортировать по имени в обратном алфавитном порядке
        List<Person> byName = Person.persons.stream()
                .sorted((p1,p2)->-p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());
        System.out.println(byName);
        boolean sorted = true;

	    // Отсортировать сначала по полу, а потом по возрасту
        List<Person> sorted2 = Person.persons.stream()
                .sorted((p1,p2)->p1.getSex()!=p2.getSex()?
                        p1.getSex().compareTo(p2.getSex()):
                        p1.getAge().compareTo(p2.getAge()))
                .collect(Collectors.toList());
        System.out.println(sorted2);
        boolean isSorted = true;

        //Группировка по полу
        Map<Person.Sex, List<Person>> group = Person.persons.stream()
                        .collect(Collectors.groupingBy(Person::getSex));
        System.out.println(group);


        Assertions.assertAll("",
                () -> Assertions.assertEquals(2, men.size()),
                () -> Assertions.assertEquals(34.6, meanAge),
                () -> Assertions.assertEquals(5, count),
                () -> Assertions.assertEquals(69, theOldest.getAge()),
                () -> Assertions.assertEquals(true,sorted),
                () -> Assertions.assertEquals(true,isSorted),
                () -> Assertions.assertEquals(true,isSorted)
        );
       
    }

    @Test
    public void test2() {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        // Получить все числа подряд, записать в массив целых чисел
        int[] numbers = collection.stream()
                .mapToInt(s->Integer.parseInt(s.substring(1)))
                .toArray();

        // Получить все числа подряд, записать в массив строк
        collection = Arrays.asList("1,2,0", "4,5");
        String[] strings = collection.stream()
                .flatMap(s->Arrays.asList(s.split(","))
                        .stream())
                .toArray(String[]::new);

        //Найти сумму всех чисел, которые хранятся через запятую в collection
        collection = Arrays.asList("1,2,0", "4,5", "1,2");
        int sum = collection.stream()
                        .flatMapToInt(s->Arrays.asList(s.split(",")).stream()
                                .mapToInt(Integer::parseInt))
                .sum();
    }
}