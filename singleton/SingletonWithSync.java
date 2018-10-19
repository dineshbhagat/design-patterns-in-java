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

/*
class MySingleton {

    private MySingleton() {
    }

    private static MySingleton ourInstance;

    public static MySingleton getInstance() {
        if (ourInstance == null) {
            synchronized (MySingleton.class) {
                System.out.println(Thread.currentThread().getName() + " : instantiates object");
                ourInstance = new MySingleton();
            }
        }
        return ourInstance;
    }
}
//output: If you miss and second level null check
//Thread-0 : instantiates object
//Thread-1 : instantiates object
//Thread-3 : instantiates object
//Thread-4 : instantiates object
//Thread-2 : instantiates object
*/

/*
class MySingleton {

    private MySingleton() {
    }

    private static MySingleton ourInstance;

    public static MySingleton getInstance() {
        if (ourInstance == null) {
            synchronized (MySingleton.class) {
                if (ourInstance == null) {
                    System.out.println(Thread.currentThread().getName() + " : instantiates object");
                    ourInstance = new MySingleton();
                }
            }
        }
        return ourInstance;
    }
}

// output: with Double-Checked locking, but this solution is discouraged recently 
// Thread-7 : instantiates object

*/
