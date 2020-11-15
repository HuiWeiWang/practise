package com.huiwei.arth.datastructure.linkedlist;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * LinkedHashMap ʵ��
 * put /get ���� O(1)
 * ���������������������Ҫɾ������ͷ
 * created by Ethan-Walker on 2019/2/16
 */
public class LRUCache2 {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache2(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        int val = cache.get(key);
        cache.remove(key); // ��������ɾ��
        cache.put(key, val); // ��ӵ���β

        return val;

    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key); // �Ѿ����ڣ�������ɾ��
        }

        if (capacity == cache.size()) {
            // cache ����,ɾ������ͷ
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key, value);// ��ӵ���β
    }
}
