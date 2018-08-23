public class Deadlock {

    static class MyClass{
        String id;

        public MyClass(String id) {
            this.id = id;
        }

        synchronized void a(MyClass other){
            System.out.printf("%s called A on %s%n", this.id, other.id);
        }
    }

    public static void main(String[] args) {



    }
}
