public class SingletonWithSync {
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                MySingleton.getInstance();
            }
        };

        int threadSize = 10000;
        Thread[] t = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            t[i] = new Thread(run);
        }
        for (int i = 0; i < threadSize; i++) {
            t[i].start();
        }
    }
}

class MySingleton {

    private MySingleton() {}

    private static MySingleton ourInstance;

    public static synchronized MySingleton getInstance() {
        if (ourInstance == null) {
            System.out.println(Thread.currentThread().getName() + " : instantiates object");
            ourInstance = new MySingleton();
        }
        return ourInstance;
    }
}
//output, there should be only 1 thread(any thread) which instantiate the object
/*
Thread-9 : instantiates object
*/
