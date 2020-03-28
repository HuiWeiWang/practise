圣思园张龙JVM学习地址:https://github.com/weolwo/jvm-learn
指定类加载路径来运行java：java -Djava.ext.dirs=./ com.huiwei.basic.Test
打包class文件：jar cvf test.jar com/huiwei/basic/Test.class
反编译：javap -c -verbose com.huiwei.basic.Test

字节码相关：
使用javap -verbose命令分析一个字节码文件时，
将会分析该字节码文件的魔数，版本号，常量池，类信息，类的构造方法，类中的方法信息，类变量与成员变量等信息。

魔数：所有的.class字节码文件的前4个字节都是魔数，魔数的值为固定值：0xCAFEBABE
