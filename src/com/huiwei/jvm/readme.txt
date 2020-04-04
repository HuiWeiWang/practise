圣思园张龙JVM学习地址:https://github.com/weolwo/jvm-learn

一、jvm相关命令
java控制台：jconsole
java极大成者：jvisualvm

指定类加载路径来运行java：java -Djava.ext.dirs=./ com.huiwei.basic.Test
打包class文件：jar cvf test.jar com/huiwei/basic/Test.class
反编译：javap -c -verbose com.huiwei.basic.Test

字节码相关：
使用javap -verbose命令分析一个字节码文件时，
将会分析该字节码文件的魔数，版本号，常量池，类信息，类的构造方法，类中的方法信息，类变量与成员变量等信息。

魔数：所有的.class字节码文件的前4个字节都是魔数，魔数的值为固定值：0xCAFEBABE



二、垃圾回收

回收算法：
1、引用计数法（不能解决循环引用的问题）（用GC Roots解决）
2、复制算法
3、标记清除算法（节约空间，产生内存碎片）
4、标记整理算法（能清理碎片，但是效率低）
垃圾回收先进行可达性分析，以GC Roots对象为根进行遍历，不能遍历到的对象就是不可达对象

垃圾回收器：
Serial（串行垃圾回收器）（UseSerialGC、UseSerialOldGC(不用了)）
Parallel（并行垃圾回收器）(UseParallelGC、UseParNewGC、UseParallelOldGC)
CMS（并发标记清除垃圾回收器）(UseConcMarkSweepGC)（并发收集停顿低，并发执行，对cpu资源压力大，采用的标记清除算法会导致大量碎片）
G1（将内存分成小块并发地回收）（UseG1GC）


young区（占1/3）：
eden区：8/10
survivor from区：1/10
survivor to区：1/10

old区（占2/3）



三、jvm调优
jvm调优参数：3种:标配参数、X参数、XX参数(主要有布尔型和键值对型)
jps -l 打印java进程号
jstack pid 打印java进程的堆栈信息
jinfo -flag 参数 pid 查看某个进程的参数
jinfo -flags pid 查看某个进程的所有参数

-Xms等价于-XX：InitialHeapSize  初始大小内存，默认为物理内存的1/64
-Xmx等价于-XX:MaxHeapSize     最大分配内存，默认为物理内存的1/4
-Xss等价于-XX:ThreadStackSize 单个栈大小，一般为512kb~1024kb
-Xmn            Young Gen区,即年轻代大小
-XX:MetaspaceSize

盘点jvm家底用以下3个命令：
java -XX:+PrintFlagsInitial 查看jvm初始家底
java -XX:PrintFlagsFinal 修改之后的家底
java -XX:PrintCommandLineFlags version 在命令行修改的值

参数列表：
PrintGCDetails 是否打印GC细节
MetaspaceSize  元空间大小
MaxTenuringThreshold 年轻代要活过多少次才能到达老年区（设置垃圾的最大年龄）
InitialHeapSize 堆初始大小
UseParallelGC   并行垃圾回收器
UseSerialGC   串行垃圾回收器
SurvivorRatio  调整young区各部分的比例（设置的是eden区，剩下的2个1给from区和to区）
NewRatio       设置年轻代和老年代的比例（设置的是老年代，剩下的1给年轻代）

MaxDirectMemorySize 直接物理内存


四、几个引用（强引用、软引用、弱引用、虚引用）
强引用：内存不够也不回收，容易导致oom
弱引用：内存够时不回收，内存不够时回收
弱引用：不管内存够不够用，只要垃圾回收发生了就回收

需要读取大量的本地图片时，每次都从硬盘读取严重影响性能，全部加载到内存中又容易造成内存溢出，此时可以考虑使用软引用和弱引用

虚引用：不管怎样都访问不到的引用对象，只能和ReferenceQueue联合使用，把它放到队列中，则在GC之后可以在队列中访问到

五、OOM
1、StackOverflowError 栈溢出（递归调用方法）
2、OutOfMemoryError:java heap space
3、OutOfMemoryError：GC overhead limit exceeded(不停地垃圾回收却没用)
4、OutOfMemoryError：Direct buffer memory(本地内存溢出)
5、OutOfMemoryError：unable to create new native thread （不能创建更多本地线程）
6、OutOfMemoryError：Metaspace（元空间爆）

永久代存放了以下信息（java8之后被元空间MetaSpace代替了）：
虚拟机加载的类信息；
常量池；
静态变量；
即时编译后的代码





