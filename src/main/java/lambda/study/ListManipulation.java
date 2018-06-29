package lambda.study;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListManipulation {

    public long countNamesStartWithAorB(List<String> names, String lettersA, String lettersB) {
        if (names != null) {
            final Function<String, Predicate<String>> startsWithAorB =
                    letter -> name -> name.startsWith(letter);
            long countOfLetterA = names.stream().filter(startsWithAorB.apply(lettersA)).count();
            long countOfLetterB = names.stream().filter(startsWithAorB.apply(lettersB)).count();
            return countOfLetterA + countOfLetterB;
        } else {
            return 0;
        }
    }

    public String findLongestName(List<String> names) {
        final Optional<String> longestName = names.stream().reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2);
        return longestName.orElse(null);
    }

    public List<String> findNamesStartWith(List<String> names, String letters) {
        if (names != null) {
            return names.stream().filter(name -> name.startsWith(letters)).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public String findFirstMatched(List<String> names, String targetName) {
        final Optional<String> matchedName = names.stream().filter(name -> name.equals(targetName)).findFirst();
        return matchedName.orElse(null);
    }

    public int calculateSumOfLetters(List<String> names) {
        if (names != null) {
            return names.stream().mapToInt(String::length).sum();
        } else {
            return 0;
        }
    }

}
