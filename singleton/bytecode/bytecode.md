//Bytecode of class without synchronized method

Compiled from "MySingleton1.java"
public class MySingleton1 {
  public static MySingleton1 getInstance();
    Code:
       0: getstatic     #2                  // Field ourInstance:LMySingleton1;
       3: ifnonnull     16
       6: new           #3                  // class MySingleton1
       9: dup
      10: invokespecial #4                  // Method "<init>":()V
      13: putstatic     #2                  // Field ourInstance:LMySingleton1;
      16: getstatic     #2                  // Field ourInstance:LMySingleton1;
      19: areturn
}


//Bytecode of class with synchronized method 





//Bytecode of class with double-checked synchronized method

Compiled from "MySingleton.java"
class MySingleton {
  public static MySingleton getInstance();
    Code:
       0: getstatic     #2                  // Field ourInstance:LMySingleton;
       3: ifnonnull     37
       6: ldc           #3                  // class MySingleton
       8: dup
       9: astore_0
      10: monitorenter
      11: getstatic     #2                  // Field ourInstance:LMySingleton;
      14: ifnonnull     27
      17: new           #3                  // class MySingleton
      20: dup
      21: invokespecial #4                  // Method "<init>":()V
      24: putstatic     #2                  // Field ourInstance:LMySingleton;
      27: aload_0
      28: monitorexit
      29: goto          37
      32: astore_1
      33: aload_0
      34: monitorexit
      35: aload_1
      36: athrow
      37: getstatic     #2                  // Field ourInstance:LMySingleton;
      40: areturn
    Exception table:
       from    to  target type
          11    29    32   any
          32    35    32   any
}

Notice: monitorenter and monitorexit, its scope of synchronized block
