package org.edy.script.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.edy.script.common.Constans;
import org.edy.script.data.ScriptList;

public class Input_File {

	private ScriptList data = new ScriptList();

	// 파일로 부를 경우...
	private List<String> start(File file) {

		if (file.exists()) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
				String str = null;
				// 임시방편... 줄에 공백이 있었따 ㅠㅠ
				while ((str = br.readLine()) != null) {
					String tmp[] = str.split(Constans.PARSING);
					// System.out.println(tmp[0] + " : " + tmp[1] + " : " +
					// tmp[2]);
					if (tmp.length > Constans.DIV_NUM) {
						// DIV_NUM = 1 <-- 기준이 되는 곳 위치 숫자
						// String div_Str = new
						// String(tmp[Constans.DIV_NUM].getBytes(), "UTF-8");
						int div_num = Integer.parseInt(tmp[Constans.DIV_NUM].trim());
						System.out.println(div_num);
						// RESULT_NUM = 2 <-- 실질적으로 저장할 곳 위치 숫자
						String address = new String(tmp[Constans.ADDRESS_NUM].getBytes(), "UTF-8");
						String result = new String(tmp[Constans.RESULT_NUM].getBytes(), "UTF-8");

						// if(
						// String.valueOf(0+Constans.FONT_TABLE_NUM).equals(div_num)){
						if (Constans.FONT_TABLE_NUM == div_num) {
							data.add_FontTableList(address);
							data.add_FontTableList(result);
							// }else
							// if(String.valueOf(0+Constans.SCRIPT_NUM).compareTo(div_num)
							// < 0){
						} else if (Constans.SCRIPT_NUM < div_num) {
							data.add_ScriptList(result);
						}
					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(br != null) try {br.close();} catch (IOException e) {e.printStackTrace();}
			}
		} else {
			System.out.println("file not found~!!!");
		}

		return null;
	}

	// 문자열로 부를 경우..
	public void start(String path) {
		File file = new File(path);
		start(file);
	}

	// /////////////////////////////////////////////////////////////
	public ScriptList getData() {
		return data;
	}

	public void setData(ScriptList data) {
		this.data = data;
	}

}
