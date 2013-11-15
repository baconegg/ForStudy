package org.edy.list;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

	private int count;
	private Object[] arr;
	
	 /**
     * 기본생성자
     */
    public ArrayList() {
        this(10);
    }
   
    public ArrayList(int capacitance) {
        arr = new Object[capacitance];
        count = 0;
    }
    
    /**
     * 복사생성자
     * @param another
     */
    public ArrayList(ArrayList<E> another) {
        this(another.size());
 
        // 배열의 깊은복사 - 서로 다른 레퍼런스
        arr = Arrays.copyOf(another.arr, another.size());
       
        this.count = another.size();
    }
	
    /**
     * 배열의 요소를 왼쪽으로 시프트한다.
     * @param index	기준점
     */
    private void shiftLeft(int index){
    	for(int i = index; i < count - 1; i++) 
    		arr[i] = arr[i + 1];
    }
    
    /**
     * 배열의 요소를 오른쪽으로 시프트한다.
     * @param index     기준점
     */
    private void shiftRight(int index) {
    	for(int i = arr.length - 2; i >= index; i--)
    		arr[i + 1] = arr[i];
    }
    
    /**
     * 배열을 다 채울쯤에 배열의 크기를 확장한다.
     */
    private void extend() {
    	if(count + 2 >= arr.length){
    		Object[] temp = new Object[arr.length * 2];
    		
    		//배열의 얕은복사 - 같은 레퍼런스 참조..
    		for(int i = 0; i < arr.length; i++)
    			temp[i] = arr[i];
    		
    		//참조의 대상을 바꾼다.
    		arr = temp;
    	}
    }
    
    //////////////////////////////////////////////////////////////////////
	@Override
	public void add(E e) {
		extend();
		arr[count++] = e;
	}

	@Override
	public void add(E e, int index) {
		extend();
		shiftRight(index);
		
		arr[index] = e;
		count++;
	}

	@Override
	public E get(int index) {
		return (E)arr[index];
	}

	@Override
	public E remove(int index) {
		
		E e = (E)arr[index];
		
		shiftLeft(index);
		
		count--;
		
		return e;
	}

	@Override
	public E remove(E e) {
		
		//선형검색
		for(int i = 0; i < count; i++){
			if(arr[i].equals(e)){
				shiftLeft(i);
				count--;
				return (E)arr[i];
			}
		}
		
		return null;
	}

	@Override
	public void clear() {
		 /**
         * 기존의 배열객체는 가비지 컬렉터에 의해 소멸된다.
         */
		arr = new Object[count];
		count = 0;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

}
