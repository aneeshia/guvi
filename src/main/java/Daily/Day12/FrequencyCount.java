package Daily.Day12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

public class FrequencyCount {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,2,3,3,2,5,3,1,6};
        HashMap<Integer, Integer> frequency = new HashMap<>();

        int len = arr.length;
        for (int a: arr) {
            if(frequency.containsKey(a)) {
                int oldF = frequency.get(a);
                int newF = oldF + 1;
                frequency.put(a , newF);
            } else {
                frequency.put(a, 1);
            }
        }
        System.out.println(frequency);

        /////////////
        String arr2 = "leetcode";
        HashMap<Character, Integer> frequency2 = new HashMap<>();

        for (Character a: arr2.toCharArray()) {
            if(frequency2.containsKey(a)) {
                int oldF = frequency2.get(a);
                int newF = oldF + 1;
                frequency2.put(a , newF);
            } else {
                frequency2.put(a, 1);
            }
        }
        System.out.println(frequency2);



        /////////////
        HashMap<Character, Integer> frequency3 = new LinkedHashMap<>();

        for (Character a: arr2.toCharArray()) {
            if(frequency3.containsKey(a)) {
                int oldF = frequency3.get(a);
                int newF = oldF + 1;
                frequency3.put(a , newF);
            } else {
                frequency3.put(a, 1);
            }
        }
        System.out.println(frequency3);

        System.out.println(('a'- 'a') + " " + ('A' - 'a'));

        String str = "Aneeshia";
        int [] freqArray = new int[26];
        for(Character a: str.toLowerCase(Locale.ROOT).toCharArray()) {
            int index = a - 'a';
            freqArray[index] = freqArray[index] + 1;

//            System.out.println(a + " - a = " + index);
        }
        System.out.println(Arrays.toString(freqArray));
    }
}
