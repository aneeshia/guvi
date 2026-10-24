package Daily.Day17;

import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        String arr [] = new String[] { "100", "9", "30", "45", "5"};

        //custom sorting
        Arrays.sort(arr, (a, b) -> {
            if(a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        System.out.println(Arrays.toString(arr));
    }
}
