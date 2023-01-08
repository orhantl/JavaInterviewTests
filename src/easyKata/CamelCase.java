package easyKata;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class CamelCase {
    /*
     * Write simple .camelCase method (camel_case function in PHP, CamelCase in C# or camelCase in Java) for strings.
     * All words must have their first letter capitalized without spaces.
     * For instance:
     * camelCase("hello case"); // => "HelloCase"
     * camelCase("camel case word"); // => "CamelCaseWord"
     * Don't forget to rate this kata! Thanks :)
     */

    public static String camelCase(String str) {
        if (str.isEmpty()) {
            return str;
        }
        String[] split = str.trim().split(" ");
        return String.join("", Arrays.stream(split)
                .map(s -> !s.isEmpty() ?
                        s.replaceFirst(String.valueOf(s.charAt(0)), String.valueOf(s.charAt(0)).toUpperCase())
                                .trim()
                        : "")
                .toList());
    }

    public static String camelCase2(String str) {
        // your code here
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            if (string.length() > 0) {
                stringBuilder.append(string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase()));
            }

        }
        return new String(stringBuilder);
    }


    public static String camelCase3(String str) {
        return (str == null || str.isEmpty()) ? "" : Arrays.stream(str.trim().split("\\s+"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(joining());
    }

    public static String camelCase4(final String string) {

        return Arrays.stream(string.split("\\s+"))
                .filter(s -> !s.isEmpty())
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase())
                .collect(joining());
    }

    public static String camelCase5(String str) {
        StringBuilder sb = new StringBuilder();
        for (var word : str.split(" "))
        {
            sb.append(word.isEmpty() ? "" : word.substring(0, 1).toUpperCase() + word.substring(1));
        }
        return sb.toString();
    }

    public static String camelCase6(String str) {
        for (char c = 'a'; c <= 'z'; c++){
            String regex = "^"+c+"|[\\ ]{1,}"+c, replaced = (c+"").toUpperCase();
            str = str.replaceAll(regex, replaced);
        }
        return str.trim();
    }

    public static String camelCase7(String str) {
        return java.util.Arrays.stream(str.split(" "))
                .filter(e -> e.matches("\\w+"))
                .reduce("", (s1, s2) -> s1 + s2.substring(0,1).toUpperCase()+s2.substring(1));
    }


    public static String camelCase8(String str) {
        return Arrays.stream(str.split("\\s+")).filter(t -> t.length()>0)
                .map(owo -> (Character.toString(owo.charAt(0)).toUpperCase()+owo.substring(1)))
                .collect(Collectors.joining());
    }

    /*with Apache Commons

    import org.apache.commons.lang3.text.WordUtils;

    public static String camelCase(String str) {
        str = WordUtils.capitalize(str);
        str = str.replaceAll(" ", "");
        return str;
    }

    public static String camelCase(String str) {
        String result = "";
        for (String s : str.trim().split(" ")) {
            result += WordUtils.capitalize(s);
        }
        return result;
    }


    public static String camelCase(String str) {
        return WordUtils.capitalize(str).replace(" ","");
    }

    */
}
