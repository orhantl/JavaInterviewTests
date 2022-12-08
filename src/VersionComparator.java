import java.util.Arrays;
import java.util.Comparator;

public class VersionComparator implements Comparator<String> {


    @Override
    public int compare(String version1, String version2) {
        Integer[] array1 = Arrays.stream(version1.split("\\."))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Integer[] array2 = Arrays.stream(version2.split("\\."))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        int length1 = array1.length;
        int length2 = array2.length;

        int index = 0;

        while(index < length1 || index < length2) {
            if (index < length1 && index < length2) {
                if (array1[index] < array2[index]) {
                    return -1;
                } else if (array1[index] > array2[index]) {
                    return 1;
                }
            } else if (index < length1) {
                if  (array1[index] != 0) {
                    return 1;
                }
            } else if (index < length2) {
                if (array2[index] != 0) {
                    return -1;
                }
            }
            index++;
        }
        return 0;
    }
}
