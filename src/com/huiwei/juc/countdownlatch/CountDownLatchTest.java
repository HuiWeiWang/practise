package com.huiwei.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    static class BossThread extends Thread {
        @Override
        public void run() {
            System.out.println("Boss�ڻ����ҵȴ����ܹ���" + countDownLatch.getCount() + "���˿���...");
            try {
                // Boss�ȴ�
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("�����˶��Ѿ������ˣ������...");
        }

        // Ա�����������
        static class EmpleoyeeThread extends Thread {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "�����������....");
                }finally {
                    // Ա����������� count - 1
                    countDownLatch.countDown();
                }
            }
        }

        public static void main(String[] args) {
            // Boss�߳�����
            new BossThread().start();

            for (long i = 0; i < countDownLatch.getCount(); i++) {
                new EmpleoyeeThread().start();
            }

        }
    }
}
