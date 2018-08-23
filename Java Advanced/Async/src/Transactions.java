public class Transactions {

    static  class BackAccount{
        int balance;

        synchronized void deposit(int sum){
            this.balance+=sum;
        }

    }

    static final int transactions = 100;
    static final int operationsPerTransaction = 100;


    public static void main(String[] args) throws InterruptedException {
        BackAccount account = new BackAccount();
        Runnable task = ()->{
            for (int i = 0; i < operationsPerTransaction; i++) {
                account.deposit(1);
                Thread.yield();
            }
        };

        Thread[] threads = new Thread[transactions];
        for (int i = 0; i < transactions; i++) {
            threads[i]= new Thread(task);
            threads[i].start();

        }
        for (int i = 0; i < transactions; i++) {

            threads[i].join();

        }
        System.out.println(account.balance);

    }
}
