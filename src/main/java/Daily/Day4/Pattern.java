package Daily.Day4;

public class Pattern {
    static void main(String[] args) {

        // square *
        for(int i=0 ; i<5; i++) {
            for(int j=0;j<5;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // right angle *
        for(int i=0 ; i<5; i++) {
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // inverted right angle *
        for(int i=5 ; i>0; i--) {
            for(int j=0;j<=i;j++){
                System.out.print(" ");
            }
            for(int j=i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }

        // inverted right angle *
        for(int i=5 ; i>0; i--) {
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
