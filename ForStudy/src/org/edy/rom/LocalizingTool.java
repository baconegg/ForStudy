package org.edy.rom;

import org.edy.rom.data.RomData;
import org.edy.rom.input.ReadRom;

/*
 *  1. 롬파일 읽기
 *  2. 롬파일 분석(포인터, 대사 위치 찾기)
 *  3. 포인터 테이블 읽기
 *  4. 포인터 테이블에 따른 대사코드 읽기
 *  5. 폰트 테이블을 통해 대사코드를 대사로 변환하기
 *  6. 데이터 베이스에 저장하기
 *  7. 웹으로 번역 페이지 만들기
 *  8. 기존 대사를 번역된 대사로 변환하기
 *  9. 롬파일 쓰기
*/

public class LocalizingTool {

	/*
	 * 롬파일 읽기
	 * 1. 롬의 첫 시작부터 16바이트씩 읽어들인다.
	 * 2. 현재 주소를 배열에 저장한다.
	 * 3. 1에서 읽어온 16바이트를 한 바이트씩 다시 읽어들이며, byte형을 String형으로 변환한다.
	 * 	  EX) 롬 데이터의 "5F"의 경우 byte형으로 "95"라는 값으로 읽어들임, 이를 다시 String형으로 "5F"로 변환
	 * 4. byte형에서 String 형으로 변환된 16바이트의 데이터를 주소와 데이터의 쌍으로 Map에 저장한다.
	 * 5. 파일 끝까지 읽었으면, 콘솔창에 출력하고 종료한다. 
	 */
//	static private RomData romData = null;
	private RomData romData = null;
	
	public LocalizingTool(){
		romData = new RomData();
	}
	
	public void start(String readFileName){
		
		System.out.println("start readRom");
		//롬 읽기
		ReadRom readRom = new ReadRom(readFileName, romData);
		readRom.readRom();
		
		System.out.println("end readRom");
	
		//읽은 롬을 콘솔에 출력
		logRomData();
		
	}
	
	public void logRomData(){
		
		///////////////////////////////////////////////////////////////////////
		System.out.println("========================================================logRomData start========================================");
		///////////////////////////////////////////////////////////////////////
		
		String tmp = ""; //롬 주소 대입용 임시 변수
		//romData(mapIndex, romMap)의 정보를 콘솔창에 출력
		for(int i = 0; i < romData.sizeMapIndex(); i++){
			tmp = romData.getMapIndex(i);
			System.out.print(tmp + " -> ");
			System.out.println(romData.getRomMap(tmp));
		}
		
		///////////////////////////////////////////////////////////////////
		System.out.println("========================================================logRomData end========================================");
//		System.out.println("addressline size : " + romData.sizeMapIndex());
		System.out.println("romdata size : " + romData.sizeRomMap());
		///////////////////////////////////////////////////////////////////
	}
	
	public void checkTime(long time){
		long totalTime = (System.currentTimeMillis() - time);
		System.out.println("\n\n총 소요시간 : " + totalTime + "millis = " + (totalTime * 0.001) + "seconds");
		Runtime r = Runtime.getRuntime();
		long t = r.totalMemory();
		long f = r.freeMemory();
		
		System.out.println("총 메모리 : " + t + "bytes " + " = " +  (t/1024/1024) + "MegaBytes");
		System.out.println("사용한 메모리 : " + (t - f) + "bytes " + " = " +  ((t - f)/1024/1024) + "MegaBytes");
		System.out.println("남은 메모리 : " + f + "bytes " + " = " +  (f/1024/1024) + "MegaBytes");
		
		
		
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		long time = System.currentTimeMillis();
		
		// 롬파일 위치
		String readFileName = "D:/han/";
		
		args = new String[3];
		args[0] = readFileName + "MetalMax2Kai(J).gba";
		args[1] = readFileName + "5400 - Ninokuni - Shikkoku no Madoushi (J).nds";
		args[2] = readFileName + "FFT(J).iso";
		
		if(args.length < 1){
			System.out.println("Usage : java DecimalToBinary number");
			System.exit(1);
		}
		
		//인스턴스 생성
		LocalizingTool tool = new LocalizingTool();
		tool.start(args[0]);
		tool.checkTime(time);
		
	}
	
}
