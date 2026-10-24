package Daily.Day6;

import java.util.Arrays;

public class Method {
    public static void main(String[] args) {
        int [][]inputs = {
                {100,200},
                {10,20},
                {1000,2000}
        };
        for (int [] input: inputs) {
            System.out.println(Arrays.toString(input)+" "+ add(input[0], input[1]));
        }
//        int x = added(input[0], input[1]);
    }

    static int add(int x, int y){
        return x+y;
    }
    int added(int x, int y){
        return x+y;
    }
}
