package org.edy.script.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.edy.script.common.Constans;

public class Output_File {
	// script용
	public void saveFile(List<String> output, String result, String cmd) {
		// 디렉토리 생성
		File directory = new File(Constans.Path.getOutputPath());
		directory.mkdirs();

		// 파일 저장
		File save = new File(result);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(save);

			write_File(pw, output, cmd);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

	// ///////////////////////////////////////////////////////////////////////////
	public void write_File(PrintWriter pw, List<String> output, String cmd) {

		// String str[] = {Constans.Cmd.getCMD_0(), Constans.Cmd.getCMD_1()};

		int size = output.size();
		
		switch (cmd) {

		case "script":
			for (int i = 0; i < size; i++) {
				
				System.out.println("output : " + output.get(i));
				
				pw.println(output.get(i));

				// ////////////////////////////////////////////////
				// 번역 결과 쓸 빈 공간용... 이거 있는게 낫나..없는게 낫나??
				pw.println();
				// ////////////////////////////////////////////////
			}
			break;

		case "font_table":
			//순서가 홀수 주소 짝수 값 이다.. 즉 프로그램 상으론 짝수일 때 주소 홀수일때 값이 됨..
			for (int i = 0; i < size; i++) {
				
				//이거..폰트테이블로 쓰려면 shift-jis 로 바꿔야 될듯 싶음..
				System.out.println("output : " + output.get(i));
				
				if(i%2 == 0){
					pw.print(output.get(i));	//주소
					pw.print("\t"); 			//<--한칸 띄어서 구분했음.. 요것도 constants에 올려야 되려나..
				}else{
					pw.println(output.get(i));	//값
				}
			}
			break;
		}
	}
}
