package org.edy.list;

public interface List<E> {

	/**
	 * 요소를 리스트 끝에 삽입한다.
	 * @param e 삽입할 데이터
	 */
	public void add(E e);
	
	/**
	 * 요소를 리스트의 정해진 위치에 삽입한다.
	 * @param e 삽입할 데이터
	 * @param index 삽입할 위치
	 */
	public void add(E e, int index);
	
	/**
	 * 리스트로부터 해당 위치의 요소를 가져온다.
	 * @param index 가져올 위치
	 * @return 		리스트의 index번째 요소
	 */
	public E get(int index);
	
	/**
	 * 리스트의 해당 위치의 데이터를 지운다.
	 * @param index 지울 위치
	 * @return 		지워진 데이터
	 */
	public E remove(int index);
	
	/**
	 * 해당 객체를 찾은 후, 최초로 등장한 객체를 지운다. 해당 객체를 찾지 못하면 null을 반환한다.
	 * @param e 지울 객체
	 * @return 	지워진 데이터이거나, 해당객체가 없으면 null
	 */
	public E remove(E e);
	
	/**
	 * 리스트의 모든 요소를 지운다.
	 */
	public void clear();
	
	/**
	 * 리스트가 비었는지 비어있지 않은지 검사한다.
	 * @return 	리스트가 비어있으면 true, 그렇지 않으면 false.
	 */
	public boolean isEmpty();
	
	/**
	 * 리스트에 저장된 객체들의 수를 가져온다.
	 * @return 	리스트에 담긴 요소들의 수
	 */
	public int size();
}
