package Daily.Day2;

class Pet {
    public static void main(String[] args){
        System.out.println("Helloworld");
        System.out.println("Helloworld 1");
        System.out.println("Helloworld 2");
        System.out.println("Helloworld 3");
        System.out.println("Helloworld 4");
        System.out.println("Helloworld 5");


        float x = 100.5f;
        double dd = 10000000000.6;
        double dd1 = 10000000000.6d;

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Character.MAX_VALUE);
//        System.out.println(Boolean.MAX_VALUE); // ERROR

        System.out.println(Byte.MIN_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Character.MIN_VALUE);
//        System.out.println(Boolean.MIN_VALUE); // ERROR


        System.out.println(Byte.SIZE);
        System.out.println(Short.SIZE);
        System.out.println(Integer.SIZE);
        System.out.println(Long.SIZE);
        System.out.println(Double.SIZE);
        System.out.println(Float.SIZE);
        System.out.println(Character.SIZE);
//        System.out.println(Boolean.SIZE); // ERROR

//        int x = null; // ERROR

        char c = 'a';
//        char c1 = 'ab'; // ERROR

        // String, Array, Enum, Interface, Record
        // Non-primitive


        int a, b = 5, cc=10;
        int sum = 0;
//        sum = a + b + cc;

        byte o = 50;
        short q = o; // widening
        int p = 100;
//        short qq = p; // ERROR
        short qq = (short) p; // narrowing
        long r = q;

//        String s = "10000000";;
//        byte k = Byte.parseByte(s); // out of range

        String s = "100";;
        byte k = Byte.parseByte(s);

        short l = Short.parseShort(s);
        int m = Integer.parseInt(s);
        long n = Long.parseLong(s);
        System.out.println(k + " " + l);
        System.out.println(l);
        System.out.println(m);
        System.out.println(n);


        int t = 49;
        String kk = String.valueOf(t);
        String ll = String.valueOf(s);
        String mm = String.valueOf(s);
        String nn = String.valueOf(s);
        System.out.println(kk);
        System.out.println(ll);
        System.out.println(mm);
        System.out.println(nn);

        // reference casting
        // upcasting, downcasting

    }
}