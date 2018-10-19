public class SingletonWithoutSynch {
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

    public static MySingleton getInstance() {
        if (ourInstance == null) {
            System.out.println(Thread.currentThread().getName() + " : instantiates object");
            ourInstance = new MySingleton();
        }
        return ourInstance;
    }
}
//output, following output will vary on each run, just check, there should be only 1 thread which instantiate this class's object
// and not any other thread.
// If other thread is instantiating it then its not singleton.
/*
Thread-5 : instantiates object
Thread-1 : instantiates object
Thread-2 : instantiates object
Thread-4 : instantiates object
Thread-3 : instantiates object
Thread-0 : instantiates object
*/
