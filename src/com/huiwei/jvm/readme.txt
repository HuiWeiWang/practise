ʥ˼԰����JVMѧϰ��ַ:https://github.com/weolwo/jvm-learn

һ��jvm�������
java����̨��jconsole
java������ߣ�jvisualvm

ָ�������·��������java��java -Djava.ext.dirs=./ com.huiwei.basic.Test
���class�ļ���jar cvf test.jar com/huiwei/basic/Test.class
�����룺javap -c -verbose com.huiwei.basic.Test

�ֽ�����أ�
ʹ��javap -verbose�������һ���ֽ����ļ�ʱ��
����������ֽ����ļ���ħ�����汾�ţ������أ�����Ϣ����Ĺ��췽�������еķ�����Ϣ����������Ա��������Ϣ��

ħ�������е�.class�ֽ����ļ���ǰ4���ֽڶ���ħ����ħ����ֵΪ�̶�ֵ��0xCAFEBABE



������������

�����㷨��
1�����ü����������ܽ��ѭ�����õ����⣩����GC Roots�����
2�������㷨
3���������㷨����Լ�ռ䣬�����ڴ���Ƭ��
4����������㷨����������Ƭ������Ч�ʵͣ�
���������Ƚ��пɴ��Է�������GC Roots����Ϊ�����б��������ܱ������Ķ�����ǲ��ɴ����

������������
Serial��������������������UseSerialGC��UseSerialOldGC(������)��
Parallel������������������(UseParallelGC��UseParNewGC��UseParallelOldGC)
CMS������������������������(UseConcMarkSweepGC)�������ռ�ͣ�ٵͣ�����ִ�У���cpu��Դѹ���󣬲��õı������㷨�ᵼ�´�����Ƭ��
G1�����ڴ�ֳ�С�鲢���ػ��գ���UseG1GC��


young����ռ1/3����
eden����8/10
survivor from����1/10
survivor to����1/10

old����ռ2/3��



����jvm����
jvm���Ų�����3��:���������X������XX����(��Ҫ�в����ͺͼ�ֵ����)
jps -l ��ӡjava���̺�
jstack pid ��ӡjava���̵Ķ�ջ��Ϣ
jinfo -flag ���� pid �鿴ĳ�����̵Ĳ���
jinfo -flags pid �鿴ĳ�����̵����в���

-Xms�ȼ���-XX��InitialHeapSize  ��ʼ��С�ڴ棬Ĭ��Ϊ�����ڴ��1/64
-Xmx�ȼ���-XX:MaxHeapSize     �������ڴ棬Ĭ��Ϊ�����ڴ��1/4
-Xss�ȼ���-XX:ThreadStackSize ����ջ��С��һ��Ϊ512kb~1024kb
-Xmn            Young Gen��,���������С
-XX:MetaspaceSize

�̵�jvm�ҵ�������3�����
java -XX:+PrintFlagsInitial �鿴jvm��ʼ�ҵ�
java -XX:PrintFlagsFinal �޸�֮��ļҵ�
java -XX:PrintCommandLineFlags version ���������޸ĵ�ֵ

�����б�
PrintGCDetails �Ƿ��ӡGCϸ��
MetaspaceSize  Ԫ�ռ��С
MaxTenuringThreshold �����Ҫ������ٴβ��ܵ���������������������������䣩
InitialHeapSize �ѳ�ʼ��С
UseParallelGC   ��������������
UseSerialGC   ��������������
SurvivorRatio  ����young�������ֵı��������õ���eden����ʣ�µ�2��1��from����to����
NewRatio       �����������������ı��������õ����������ʣ�µ�1���������

MaxDirectMemorySize ֱ�������ڴ�


�ġ��������ã�ǿ���á������á������á������ã�
ǿ���ã��ڴ治��Ҳ�����գ����׵���oom
�����ã��ڴ湻ʱ�����գ��ڴ治��ʱ����
�����ã������ڴ湻�����ã�ֻҪ�������շ����˾ͻ���

��Ҫ��ȡ�����ı���ͼƬʱ��ÿ�ζ���Ӳ�̶�ȡ����Ӱ�����ܣ�ȫ�����ص��ڴ�������������ڴ��������ʱ���Կ���ʹ�������ú�������

�����ã��������������ʲ��������ö���ֻ�ܺ�ReferenceQueue����ʹ�ã������ŵ������У�����GC֮������ڶ����з��ʵ�

�塢OOM
1��StackOverflowError ջ������ݹ���÷�����
2��OutOfMemoryError:java heap space
3��OutOfMemoryError��GC overhead limit exceeded(��ͣ����������ȴû��)
4��OutOfMemoryError��Direct buffer memory(�����ڴ����)
5��OutOfMemoryError��unable to create new native thread �����ܴ������౾���̣߳�
6��OutOfMemoryError��Metaspace��Ԫ�ռ䱬��

���ô������������Ϣ��java8֮��Ԫ�ռ�MetaSpace�����ˣ���
��������ص�����Ϣ��
�����أ�
��̬������
��ʱ�����Ĵ���





