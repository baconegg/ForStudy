
public class Sum {

	//재귀 호출
	long hab(int value){
		if(value == 0) return 0;
		else return value + hab(value - 1);
	}
	
	//일반방식
	long hab1(int value){
		long hab = 0;
		for(int i = 1; i <= value; i++){
			hab = hab + i;
		}
		return hab;
	}
	
	public static void main(String[] args){
		
		args = new String[1];
		args[0] = "80";
		
		if(args.length < 1){
			System.out.println("Usage : java DecimalToBinary number");
			System.exit(1);
		}
		
		long time = System.currentTimeMillis();
		int value = Integer.parseInt(args[0]);
		Sum s= new Sum();
//		long hab = s.hab(value);
		long hab = s.hab1(value);
		System.out.println("1부터 " + value + "까지 합 = " + hab);
		
		System.out.println("\n\n총 소요시간 : " + (System.currentTimeMillis() - time) + "millis");
		Runtime r = Runtime.getRuntime();
		long t = r.totalMemory();
		long f = r.freeMemory();
		System.out.println("총 메모리 : " + t + "bytes");
		System.out.println("남은 메모리 : " + f + "bytes");
		System.out.println("");
	}
	
}
