package lambda.study;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyComparator {

    public List<Person> sortPersonsInAscendingAgeOrder(List<Person> persons) {
        if (persons != null) {
            return persons
                    .stream()
                    .sorted(Person::ageDifference)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<Person> sortPersonsInDescendingAgeOrder(List<Person> persons) {
        if (persons != null) {
            return persons
                    .stream()
                    .sorted((person1, person2) -> person2.ageDifference(person1))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<Person> sortPersonsInAscendingNameOrder(List<Person> persons) {
        if (persons != null) {
            return persons
                    .stream()
                    .sorted(Comparator.comparing(Person::getName))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<Person> sortPersonsByAscendingAgeThenAscendingName(List<Person> persons) {
        if (persons != null) {
            return persons
                    .stream()
                    .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }

    }

    public Map<Integer, List<Person>> groupPersonsByAge(List<Person> persons) {
        if (persons != null) {
            return persons.stream().collect(Collectors.groupingBy(Person::getAge));
        } else {
            return Collections.emptyMap();
        }
    }

    public Map<Integer, List<String>> groupPersonNamesByAge(List<Person> persons) {
        if (persons != null) {
            return persons.stream()
                    .collect(Collectors
                            .groupingBy(Person::getAge,
                                        Collectors.mapping(Person::getName, Collectors.toList())));
        } else {
            return Collections.emptyMap();
        }
    }

}