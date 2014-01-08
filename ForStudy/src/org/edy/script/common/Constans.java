package org.edy.script.common;

public class Constans {
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String PARSING = ","; // ,를 기준으로 파싱했다..
	public static int ADDRESS_NUM = 0; // 주소값 위치 숫자
	public static int DIV_NUM = 1; // 원본 파일에서 쓰레기 스크립트 폰트테이블을 나누는 기준을 잡아 줄수 있는 위치 숫자
	public static int RESULT_NUM = 2; // 데이터값 위치 숫자
	public static int FONT_TABLE_NUM = 2; // 폰트 테이블 판단용 숫자... 폰트테이블 크기는 2바이트인듯
	public static int SCRIPT_NUM = 5; // 스크립트 판단용 숫자... 우선 감으로 5바이트이상인 녀석들만 저장시킴..
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static class Path {
		private static String PATH_DRIVE = "D:/";
		private static String PATH_FOLDER = "han/script/";
		private static String PATH_INFO_FILE_NAME_ORI = "hagaren-meisou.txt";
		private static String PATH_RESULT_FOLDER = "result/";
		private static String PATH_INFO_RESULT_FILE_NAME_SCRIPT = "hagaren_meisou_result.txt";
		private static String PATH_INFO_RESULT_FILE_NAME_FONT_TABLE = "font_table.tbl";

		public static String getInputPath() {return PATH_DRIVE + PATH_FOLDER;}
		public static String getInputPathFileName_ORI() {return PATH_DRIVE + PATH_FOLDER + PATH_INFO_FILE_NAME_ORI;}
		public static String getInputFileName_ORI() {return PATH_INFO_FILE_NAME_ORI;}
		public static String getOutputPath() {return PATH_DRIVE + PATH_FOLDER + PATH_RESULT_FOLDER;}
		public static String getOutputPathFileName_Script() {return getOutputPath() + PATH_INFO_RESULT_FILE_NAME_SCRIPT;}
		public static String getOutputPathFileName_FontTable() {return getOutputPath() + PATH_INFO_RESULT_FILE_NAME_FONT_TABLE;}
		public static String getOutputFileName_Script() {return PATH_INFO_RESULT_FILE_NAME_SCRIPT;}
		public static String getOutputFileName_FontTable() {return PATH_INFO_RESULT_FILE_NAME_FONT_TABLE;}
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static class Cmd {
		private static String CMD_0 = "script";
		private static String CMD_1 = "font_table";

		public static String getCMD_0() {return CMD_0;}
		public static String getCMD_1() {return CMD_1;}
	}
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
