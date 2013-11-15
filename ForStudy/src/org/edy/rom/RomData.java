package org.edy.rom;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class RomData {

	// /////////////////////////////////////////////////////////////////////////////
	/*
	 * 롬의 주소 +16만큼 더해져 배열에 저장된다. ex) 0F0E00, 0F0E10, 0F0E20
	 */
	private Vector<String> mapIndex;
	// static List<String> mapIndex;

	/*
	 * 롬의 데이터 mapIndex에 해당하는 주소의 16바이트만큼의 데이터 값이 저장된다. ex) [15, 35, 36, 60, 78,
	 * 76, 52, 35, 28, EE, AD, B3, 92, 80, A4, B0]
	 */
	private Map<String, Vector<String>> romMap;
	// static Map<String, List<String>> romMap;

	// ///////////////////////////////////////////////////////////////////////////
	/*
	 * 인스턴스 생성시의 생성자 romMap, mapIndex 생성
	 */
	public RomData() {

		romMap = new HashMap<String, Vector<String>>();
		// romMap = new HashMap<String, List<String>>();
		mapIndex = new Vector<String>();
		// mapIndex = new ArrayList<String>();
	}
	// ///////////////////////////////////////////////////////////////////////////
	//get set all
	public Vector<String> getMapIndex() {
		return mapIndex;
	}
	public Map<String, Vector<String>> getRomMap() {
		return romMap;
	}
	public void setMapIndex(Vector<String> mapIndex) {
		this.mapIndex = mapIndex;
	}
	public void setRomMap(Map<String, Vector<String>> romMap) {
		this.romMap = romMap;
	}
	// ///////////////////////////////////////////////////////////////////////////
	//get set specific index
	public Vector<String> getRomMap(String lineAddress){
		return romMap.get(lineAddress);
	}
	public String getMapIndex(int index){
		return mapIndex.get(index);
	}
//	public void setRomMap(String lineAddress, Vector<String> hexArray) {
//		romMap.put(lineAddress, hexArray);
//	}
//	public void setMapIndex(int index, String lineAddress) {
//		mapIndex.set(index, lineAddress);
//	}
	// ///////////////////////////////////////////////////////////////////////////
	//add
	public void addRomMap(String lineAddress, Vector<String> hexArray){
		romMap.put(lineAddress, hexArray);
	}
	public void addMapIndex(String lineAddress){
		mapIndex.add(lineAddress);
	}
	//set 
	// ///////////////////////////////////////////////////////////////////////////
	public int sizeRomMap(){
		return romMap.size();
	}
	public int sizeMapIndex(){
		return mapIndex.size();
	}
	
}
