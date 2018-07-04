package lambda.study.test;

import lambda.study.MyComparator;
import lambda.study.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyComparatorTest {

    private MyComparator myComparator;

    @Before
    public void init() {
        myComparator = new MyComparator();
    }

    @Test
    public void testSortPersonsInAscendingAgeOrder() {
        List<Person> persons = Arrays.asList(
                new Person("David", 30),
                new Person("John", 26),
                new Person("Janet", 35),
                new Person("Steve", 40),
                new Person("Peter", 18)
        );

        List<Person> sortedPersons = Arrays.asList(
                persons.get(4),
                persons.get(1),
                persons.get(0),
                persons.get(2),
                persons.get(3)
        );

        Assert.assertEquals("The sorted list is supposed to order the persons like " + sortedPersons,
                sortedPersons, myComparator.sortPersonsInAscendingAgeOrder(persons));
    }

    @Test
    public void testSortPersonsInDescendingAgeOrder() {
        List<Person> persons = Arrays.asList(
                new Person("David", 30),
                new Person("John", 26),
                new Person("Janet", 35),
                new Person("Steve", 40),
                new Person("Peter", 18)
        );

        List<Person> sortedPersons = Arrays.asList(
                persons.get(3),
                persons.get(2),
                persons.get(0),
                persons.get(1),
                persons.get(4)
        );

        Assert.assertEquals("The sorted list is supposed to order the persons like " + sortedPersons,
                sortedPersons, myComparator.sortPersonsInDescendingAgeOrder(persons));
    }

    @Test
    public void testSortPersonsInAscendingNameOrder() {
        List<Person> persons = Arrays.asList(
                new Person("David", 30),
                new Person("John", 26),
                new Person("Janet", 35),
                new Person("Steve", 40),
                new Person("Peter", 18)
        );

        List<Person> sortedPersons = Arrays.asList(
                persons.get(0),
                persons.get(2),
                persons.get(1),
                persons.get(4),
                persons.get(3)
        );

        Assert.assertEquals("The sorted list is supposed to order the persons like " + sortedPersons,
                sortedPersons, myComparator.sortPersonsInAscendingNameOrder(persons));
    }

    @Test
    public void testSortPersonsByAscendingAgeThenAscendingName() {
        List<Person> persons = Arrays.asList(
                new Person("David", 30),    // 0
                new Person("John", 26),     // 1
                new Person("Janet", 35),    // 2
                new Person("Steve", 40),    // 3
                new Person("Peter", 18),    // 4
                new Person("Jacky", 30)     // 5
        );

        List<Person> sortedPersons = Arrays.asList(
                persons.get(4),
                persons.get(1),
                persons.get(0),
                persons.get(5),
                persons.get(2),
                persons.get(3)
        );

        Assert.assertEquals("The sorted list is expected to order the persons like " + sortedPersons,
                sortedPersons, myComparator.sortPersonsByAscendingAgeThenAscendingName(persons));
    }

    @Test
    public void testGroupPersonsByAge() {
        List<Person> persons = Arrays.asList(
                new Person("David", 30),    // 0
                new Person("John", 30),     // 1
                new Person("Janet", 35),    // 2
                new Person("Steve", 40),    // 3
                new Person("Peter", 18),    // 4
                new Person("Jacky", 18)     // 5
        );

        Map<Integer, List<Person>> groupedPersons = new HashMap<>();
        groupedPersons.put(18, Arrays.asList(persons.get(4), persons.get(5)));
        groupedPersons.put(30, Arrays.asList(persons.get(0), persons.get(1)));
        groupedPersons.put(35, Arrays.asList(persons.get(2)));
        groupedPersons.put(40, Arrays.asList(persons.get(3)));

        Assert.assertEquals("The grouped map is expected to be " + groupedPersons,
                groupedPersons, myComparator.groupPersonsByAge(persons));
    }

    @Test
    public void testGroupPersonNamesByAge() {
        List<Person> persons = Arrays.asList(
                new Person("David", 30),    // 0
                new Person("John", 30),     // 1
                new Person("Janet", 35),    // 2
                new Person("Steve", 40),    // 3
                new Person("Peter", 18),    // 4
                new Person("Jacky", 18)     // 5
        );

        Map<Integer, List<String>> groupedPersons = new HashMap<>();
        groupedPersons.put(18, Arrays.asList(persons.get(4).getName(), persons.get(5).getName()));
        groupedPersons.put(30, Arrays.asList(persons.get(0).getName(), persons.get(1).getName()));
        groupedPersons.put(35, Arrays.asList(persons.get(2).getName()));
        groupedPersons.put(40, Arrays.asList(persons.get(3).getName()));

        Assert.assertEquals("The grouped map is expected to be " + groupedPersons,
                groupedPersons, myComparator.groupPersonNamesByAge(persons));
    }
}
