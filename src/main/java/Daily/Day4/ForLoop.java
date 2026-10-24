package Daily.Day4;

public class ForLoop {
    static void main(String[] args) {

        for( int x=1; x<=3 ; x++) {
            System.out.println(x + "\t Aneeshia");
        }

        for( int x=1;  ; x++) { // without destination
            if(x==3 ) { // otherwise infinite loop
                break;
            }
            System.out.println("\t Aneeshia " + x);
        }
        for( int x=1; x<3 ; x--) {
            if(x<-3) { // otherwise infinite loop
                break;
            }
            System.out.println("\t Aneeshia " + x);
        }
        int y = 1;
        while (y<=3) {
            System.out.println(y + " while..");
            y++;
        }

        int z = 0;
        while (z<3) {
            System.out.println( "DO while..at "+(z+1));
            z++;
        }
    }
}
