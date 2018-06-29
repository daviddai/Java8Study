package lambda.study.test;

import lambda.study.MyComparator;
import lambda.study.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

}
