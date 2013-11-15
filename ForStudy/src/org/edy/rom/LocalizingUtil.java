package org.edy.rom;

public class LocalizingUtil {

	public static byte[] stringToByte(String salt){
		
//		List<Byte> list = new ArrayList<Byte>();
		
		int size = salt.length()/2;
		String two[] = new String[size];
//		StringBuffer sb = new StringBuffer();
		
		byte[] result = new byte[size];
		
		for(int i = 0; i < size; i++){
			two[i] = salt.substring(i*2, ((i*2)+2));
//			System.out.print(two[i]);
			byte tmp = (byte) Integer.parseInt(two[i], 16);
//			System.out.printf("%02X\n", tmp);
//			System.out.println(Integer.parseInt("ff", 16));
//			sb.append((char)Integer.parseInt(two[i], 16));
//			list.add(tmp);
			result[i] = tmp;
		}
		
//		System.out.printf("%02X\n", sb.toString().getBytes());
//		System.out.println(list.toArray() instanceof Byte[]);
//		ArrayUtils.toPrimitive((Byte[]) list.toArray());
		
		return result;
	}
	
	public static String byteToString(byte[] digest){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < digest.length; i++){
//			System.out.printf("%X" ,tmp[i]); 
			sb.append(String.format("%02X", digest[i]));
		}
		return sb.toString();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	/*
	* byte형 -> String형으로 변환 후 반환.
	* 변환값이 1문자일 경우, 앞에 0을 붙여서 반환.
	* ex)"F" -> "0F"
	*/
	public static String toHexCode(byte b){
		String hex = Integer.toString(b & 0xff, Constant.READBUFF);

		///test용////////////////////////////////
//		String hex2 = Integer.toString((b & 0xff) + 0x100, Constant.READBUFF); //0x100은 멀까???
//		String test = String.format("%02X", b);
//		System.out.println("toHexCode : hex = " + hex + " ,test = " + test + " result = " + hex.toUpperCase().equals(test) + " hex2 + " + hex2.toUpperCase() + " result-hex2 = " + hex.toUpperCase().equals(hex2.toUpperCase()));
		////////////////////////////////////////
		
		if(hex.length() == 1) hex = "0" + hex;
		return hex.toUpperCase();
	}
	
	/*
	* Integer형 -> Hex형으로 변환 후 반환.
	* 변환값이 6문자 미만일 경우, 앞에 0을 붙여서 반환.
	* ex)"1F30" -> "001F30"
	*/
	public static String getLineNum(int num){
		String value = Integer.toHexString(num);
		int i = value.length();
		for(; i < 6; i++){
			value = "0" + value;
		}
		return value.toUpperCase();
	}
}
