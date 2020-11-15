package com.huiwei.arth.datastructure.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LRU: �������ʹ���㷨 �� �������ʹ�õ�Ԫ�أ��ڽ�����һ��ʱ���ڣ������ʵĸ���Ҳ�ܵ͡�
 * �������ʹ�õ�Ԫ�أ��ڽ�����һ��ʱ���ڣ������ʸ��ʽϸߡ�
 * <p>
 * ������Ľṹ��
 * ����β��ʾ��������ʵ�Ԫ�أ�Խ��������ͷ��ʾԽ��֮ǰ�����ʵ�Ԫ��
 * <p>
 * ����һ��Ԫ�أ�cache �������嵽����β�������Ƴ�cache��ͷԪ���ٲ�������β
 * ����һ��Ԫ�أ�������β����ʼ����, ���ʵ�֮�󣬽����ԭλ��ɾ�������¼�������β��
 * <p>
 * ʵ��1����˫������ʵ�֡�
 * put��get ʱ�临�Ӷ�:O(n)       Ч�ʵ�
 * <p>
 * created by Ethan-Walker on 2019/2/16
 */
public class LRUCache {

    LinkedList<Node> cache;

    int capacity;

    public LRUCache(int capacity) {
        this.cache = new LinkedList<>();
        this.capacity = capacity;
    }

    // -1 ��ʾû�ҵ�
    public int get(int key) {
        Iterator<Node> iterator = cache.descendingIterator();
        int result = -1;
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                result = node.val;
                iterator.remove();
                put(key, result); //��ӵ�����β��
                break;
            }
        }
        return result;
    }

    public void put(int key, int value) {
        //�ȱ��������Ƿ���key ��Ԫ��, ����ɾ����������ӵ���β
        Iterator<Node> iterator = cache.iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                iterator.remove();
                break;
            }
        }

        if (capacity == cache.size()) {
            //����������ɾ��һ�� ������ٷ��ʵ�Ԫ�أ�����ͷ��
            cache.removeFirst();
        }
        cache.add(new Node(key, value));
    }


    class Node {
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
