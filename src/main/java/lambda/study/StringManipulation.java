package lambda.study;

import java.util.stream.Collectors;

public class StringManipulation {

    public String removeDigits(String str) {
        return str.chars()
                  .filter(character -> !Character.isDigit(character))
                  .mapToObj(character -> Character.toString((char)character))
                  .collect(Collectors.joining(""));
    }

}
