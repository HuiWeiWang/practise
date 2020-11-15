package com.huiwei.exam;


public class DiyList<T> {
   private T[] elementData;
   private int size;
   private static final int CAPACITY = 10;

   DiyList(){
       elementData = (T[]) new Object[CAPACITY];
   }

   public void add(T obj){
       if(size == elementData.length){
           T[] newElementData = (T[]) new Object[elementData.length<<1];
           System.arraycopy(elementData,0,newElementData,0,elementData.length);
           elementData = newElementData;
       }
       elementData[size++] = obj;
   }

   public boolean remove(T obj){
       for (int i = 0; i < size ; i++) {
           if(obj.equals(elementData[i])){
               System.arraycopy(elementData,i+1,elementData,i,size-i-1);
               elementData[--size] = null;
               return true;
           }
       }
       return false;
   }
}
