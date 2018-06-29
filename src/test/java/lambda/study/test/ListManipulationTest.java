package lambda.study.test;

import lambda.study.ListManipulation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListManipulationTest {

    private ListManipulation listManipulation;

    @Before
    public void init() {
        listManipulation = new ListManipulation();
    }

    @Test
    public void testFindNamesStartWith() {
        List<String> names = Arrays.asList("David", "Johnny", "Jason", "Tony");
        Assert.assertEquals("The list is expected to contain Johnny and Jason",
                Arrays.asList("Johnny", "Jason"), listManipulation.findNamesStartWith(names, "J"));
        Assert.assertEquals("The list is expected to be an empty one",
                Collections.emptyList(), listManipulation.findNamesStartWith(names, "K"));
    }

    @Test
    public void testCountNamesStartWithAorB() {
        List<String> names = Arrays.asList("David", "Johnny", "Jason", "Tony");
        Assert.assertEquals("The list is expected to contain David and Tony so count is 2",
                2, listManipulation.countNamesStartWithAorB(names, "D", "T"));
        Assert.assertEquals("The list is expected to contain David and Tony so count is 2",
                0, listManipulation.countNamesStartWithAorB(names, "A", "B"));
    }

    @Test
    public void testFindLongestName() {
        List<String> names = Arrays.asList("David", "Johnny", "Jason", "Tony", "Stephen");
        Assert.assertEquals("It is expected to be Stephen", "Stephen", listManipulation.findLongestName(names));
        Assert.assertEquals("It is expected to be null", null, listManipulation.findLongestName(Collections.emptyList()));
    }

    @Test
    public void testFindFirstMatched() {
        List<String> names = Arrays.asList("David", "Johnny", "Jason", "Tony", "Stephen");
        Assert.assertEquals("It is expected to be Jason", "Jason", listManipulation.findFirstMatched(names, "Jason"));
        Assert.assertEquals("It is expected to be null", null, listManipulation.findFirstMatched(names, "Jacky"));
    }

    @Test
    public void testCalculateSumOfLetters() {
        List<String> names = Arrays.asList("David", "Johnny", "Jason", "Tony");
        int sum = listManipulation.calculateSumOfLetters(names);
        Assert.assertEquals("Expect sum to be 20", 20, sum);
    }

}
