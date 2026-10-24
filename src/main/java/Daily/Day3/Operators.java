package Daily.Day3;

public class Operators {
    public static void main(String [] args) {

        int x = 100;
        System.out.println(x);
        System.out.println("post --");
        System.out.println(x--);
        System.out.println("x="+x+ "\n");
        System.out.println("post ++");
        System.out.println(x++);
        System.out.println("x="+x+ "\n");
        System.out.println("pre --");
        System.out.println(--x);
        System.out.println("x="+x+ "\n");
        System.out.println("pre ++");
        System.out.println(++x);
        System.out.println("x="+x+ "\n");
        System.out.println("x-- + x");
        System.out.println(x-- + x);
        System.out.println("x="+x+ "\n");
        System.out.println("++x + x");
        System.out.println(++x + x);
        System.out.println("x="+x+ "\n");
        System.out.println("++x + x--");
        System.out.println(++x + x--);
        System.out.println("x="+x+ "\n");
        System.out.println("x = ++x + x--");
        System.out.println(x = ++x + x--);
        System.out.println("x="+x+ "\n");

        System.out.println("x%10");
        System.out.println(x%10);
        System.out.println("x="+x+ "\n");
        System.out.println("x>=1");
        System.out.println(x >= 1);
        System.out.println("x="+x+ "\n");
    }
}
