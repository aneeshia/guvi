package Daily.Day8.Inheritance;

public class Types {
    public static void main(String[] args) {
//        A objA = new A();
//        System.out.println(objA.a);
//        System.out.println(objA.methodA());
//        System.out.println(objA.a1);
//        System.out.println(objA.a2);
//        System.out.println(objA.x1);
//        System.out.println(objA.x2);
//        System.out.println(objA.y1);
//        System.out.println(objA.y2);

        B objB = new C();
        objB.methodA();
        System.out.println();
        System.out.println(objB.a);
        System.out.println(objB.a1);
        System.out.println(objB.a2);
        System.out.println(objB.x1);
        System.out.println(objB.x2);
        System.out.println(objB.y1);
        System.out.println(objB.y2);
    }
}

class A {
    String a = "Data is a";
    int a1 = 100;
    int a2 = 100;
    static int x1 = 300;
    static int x2 = 300;
    protected int y1 = 600;
    protected int y2 = 600;
    void methodA() {
        System.out.println("inside methodA original");
        a += " methodA original ";
//        return a;
    }

    String method2A() {
        System.out.println("inside method2A original");
        a += " method2A original ";
        return a;
    }
}
class B extends A {
//    String a = "Data is B";
//    int a2 = 5000;
//    int x2 = 3000;
//    int y2 = 6000;

//    void methodA() {
//        System.out.println("inside methodA From B");
//         this.a2 += 5000;
//        this.x2 += 3000;
//        this.y2 += 6000;
//        this.a += " methodA From B ";
////        return this.a ;
//
//    }
}

class C extends B {
//    String a = "Data is B";
//    int a2 = 5000;
//    int x2 = 3000;
//    int y2 = 6000;

    void methodA() {
        System.out.println("inside methodA From B");
        this.a1 += 5000;
        this.x1 += 3000;
        this.y1 += 6000;
        this.a2 += 5000;
        this.x2 += 3000;
        this.y2 += 6000;
        this.a += " methodA From B ";
//        return this.a ;

    }
}
