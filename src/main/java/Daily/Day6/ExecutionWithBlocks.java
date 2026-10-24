package Daily.Day6;

public class ExecutionWithBlocks {
    ExecutionWithBlocks() {
        int a = 0;
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        System.out.println("Main Method");
        new ExecutionWithBlocks();
    }
    {
        System.out.println("Instance Block");
    }

    static {
        System.out.println("static block");
    }

    void HelloworldMethod() {
        System.out.println("Helloworld Method");
    }

}
