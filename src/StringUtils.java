public class StringUtils {

    public static String reverse(String input) {

        // reverse a string, cut array in 2 and invert letters in that array, needed to index
        // one runs from the beginning of the array
        // the second runs from the end of the array

        if (null == input) {
            return "";
        }

        char[] stringArray = input.toCharArray();
        final int halfLength = stringArray.length / 2;
        int index2;
        char clipboard;
        for (int index1 = 0 ; index1 < halfLength; index1++) {
            index2 = stringArray.length - 1 - index1;
            clipboard = stringArray[index1];
            stringArray[index1] = stringArray[index2];
            stringArray[index2] = clipboard;
        }
        return String.valueOf(stringArray);
    }
}
