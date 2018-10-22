//Bytecode of class without synchronized method

Compiled from "MySingleton1.java"
```shell
javap -v MySingleton1
```

```java

Classfile /Users/z003byl/Desktop/temp/out/production/temp/MySingleton1.class
  Last modified Oct 19, 2018; size 422 bytes
  MD5 checksum 947377373b828d5465d4c1725a3bf8a8
  Compiled from "MySingleton1.java"
public class MySingleton1
  minor version: 0
  major version: 56
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #5.#19         // java/lang/Object."<init>":()V
   #2 = Fieldref           #3.#20         // MySingleton1.ourInstance:LMySingleton1;
   #3 = Class              #21            // MySingleton1
   #4 = Methodref          #3.#19         // MySingleton1."<init>":()V
   #5 = Class              #22            // java/lang/Object
   #6 = Utf8               ourInstance
   #7 = Utf8               LMySingleton1;
   #8 = Utf8               <init>
   #9 = Utf8               ()V
  #10 = Utf8               Code
  #11 = Utf8               LineNumberTable
  #12 = Utf8               LocalVariableTable
  #13 = Utf8               this
  #14 = Utf8               getInstance
  #15 = Utf8               ()LMySingleton1;
  #16 = Utf8               StackMapTable
  #17 = Utf8               SourceFile
  #18 = Utf8               MySingleton1.java
  #19 = NameAndType        #8:#9          // "<init>":()V
  #20 = NameAndType        #6:#7          // ourInstance:LMySingleton1;
  #21 = Utf8               MySingleton1
  #22 = Utf8               java/lang/Object
{
  public static MySingleton1 getInstance();
    descriptor: ()LMySingleton1;
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=0, args_size=0
         0: getstatic     #2                  // Field ourInstance:LMySingleton1;
         3: ifnonnull     16
         6: new           #3                  // class MySingleton1
         9: dup
        10: invokespecial #4                  // Method "<init>":()V
        13: putstatic     #2                  // Field ourInstance:LMySingleton1;
        16: getstatic     #2                  // Field ourInstance:LMySingleton1;
        19: areturn
      LineNumberTable:
        line 8: 0
        line 9: 6
        line 11: 16
      StackMapTable: number_of_entries = 1
        frame_type = 16 /* same */
}
SourceFile: "MySingleton1.java"

```


//Bytecode of class with synchronized method 

```shell
javap -v MySingleton2
```

```java

Classfile /Users/z003byl/Desktop/temp/out/production/temp/MySingleton2.class
  Last modified Oct 19, 2018; size 422 bytes
  MD5 checksum 255511650d44543ce5ad6f8110ca5a98
  Compiled from "MySingleton2.java"
public class MySingleton2
  minor version: 0
  major version: 56
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #5.#19         // java/lang/Object."<init>":()V
   #2 = Fieldref           #3.#20         // MySingleton2.ourInstance:LMySingleton2;
   #3 = Class              #21            // MySingleton2
   #4 = Methodref          #3.#19         // MySingleton2."<init>":()V
   #5 = Class              #22            // java/lang/Object
   #6 = Utf8               ourInstance
   #7 = Utf8               LMySingleton2;
   #8 = Utf8               <init>
   #9 = Utf8               ()V
  #10 = Utf8               Code
  #11 = Utf8               LineNumberTable
  #12 = Utf8               LocalVariableTable
  #13 = Utf8               this
  #14 = Utf8               getInstance
  #15 = Utf8               ()LMySingleton2;
  #16 = Utf8               StackMapTable
  #17 = Utf8               SourceFile
  #18 = Utf8               MySingleton2.java
  #19 = NameAndType        #8:#9          // "<init>":()V
  #20 = NameAndType        #6:#7          // ourInstance:LMySingleton2;
  #21 = Utf8               MySingleton2
  #22 = Utf8               java/lang/Object
{
  public static synchronized MySingleton2 getInstance();
    descriptor: ()LMySingleton2;
    flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
    Code:
      stack=2, locals=0, args_size=0
         0: getstatic     #2                  // Field ourInstance:LMySingleton2;
         3: ifnonnull     16
         6: new           #3                  // class MySingleton2
         9: dup
        10: invokespecial #4                  // Method "<init>":()V
        13: putstatic     #2                  // Field ourInstance:LMySingleton2;
        16: getstatic     #2                  // Field ourInstance:LMySingleton2;
        19: areturn
      LineNumberTable:
        line 8: 0
        line 9: 6
        line 11: 16
      StackMapTable: number_of_entries = 1
        frame_type = 16 /* same */
}
SourceFile: "MySingleton2.java"
```


//Bytecode of class with double-checked synchronized method


Notice: monitorenter and monitorexit, its scope of synchronized block
