package org.edy.rom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public class ReadRom {

	/*
	 * 해당 롬을 16바이트씩 읽어, mapIndex에 롬 주소를
	 * romMap에 mapIndex의 주소에 해당하는 buffer만큼의 데이터를 저장한다. - 현재 buffer = 16byte
	 */
	
	private String readFileName;
	private RomData romData;
	
	public ReadRom(String readFileName, RomData romData){
		this.readFileName = readFileName;
		//얕은 복사 
		this.romData = romData;
	}
	
	public void readRom(){
		
		FileInputStream is = null;
		byte arr[] = null;	//롬에서 16byte씩 읽어올 변수
		Vector<String> hexArray = null; //romMap에 저장할 배열
		int line = 0; //주소 계산을 위해 16byte만큼 증가하는 변수
		String lineAddress = null; //롬 주소 대입용 변수
		int num = 0; //파일 읽기 완료 여부를 조사하기 위한 변수
		
		//파일읽기 시작
		try {
			
			is = new FileInputStream(readFileName);
			
			while(true){
				arr = new byte[Constant.READBUFF];
				hexArray = new Vector<String>(); // 롬에서 16byte씩 읽어온다. 파일을 끝까지 다 읽었을 경우, 롬 읽기 종료
				num = is.read(arr);
				
				if(num < 0) break;
				
				//romMap에 저장하기 위해 byte형 -> String형으로 변환 후, hexArray에 저장
				for(int i = 0; i < arr.length; i++){
					hexArray.add(LocalizingUtil.toHexCode(arr[i]));
				}
				
				//Integer -> Hex값으로 변환
				lineAddress = LocalizingUtil.getLineNum(line);
				//mapIndex에 롬 주소를 추가한다.
				romData.addMapIndex(lineAddress);
				//romMap에 롬 주소와 buffer만큼의 데이터를 추가한다.
				romData.addRomMap(lineAddress, hexArray);
				//주소 계산을 위해, buffer만큼 증가
				line += Constant.READBUFF;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(is != null)	try {is.close();} catch (IOException e) {e.printStackTrace();}
		}
		
	}
	
}
