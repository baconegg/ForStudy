//10진수를 2진수로 
public class DecimalToBinary {

	//일반적인 방법
	int[] binary(int value){
		System.out.println("value : " + value);
		int i = 63;
		int n;
		int[] b = new int[i + 1];
		for(i = 63; value > 1; i--){
			//나머지
			n = value%2;
			//몫
			value = value/2;
			
			if(value < 2){
				b[i] = n;
				b[i - 1] = value;
			}else{
				b[i] = n;
			}
			
			System.out.println(i + " 번째 n 값 : " + n);
			System.out.println(i + " 번째 value 값 : " + value);
			
		}
		
		b[0] = i;
		
		System.out.println("i값 : " + i);
		
		return b;
	}
	
	
	//shift 방법
	int[] binaryShift(int value){
		System.out.println("value : " + value);
		int i = 63;
		int[] b = new int[i + 1];
		
		while(value > 0){ //convert decimal to binary representation
		 if( (value%2) != 0 ) b[i] = 1;
		 i--;
		 
		 System.out.println((i + 1) + " 번째 (value%2)값 : " + (value%2));

		 value>>=1; //divide decimal by 2
		 
		 System.out.println((i + 1) + " 번째 value 값 : " + value);
		}
		b[0] = i + 1;
		
		return b;
	}
	
	//재귀함수
	static int k = 63;
	static int[] c = new int[k + 1];
	
	void binary2(int value){
		System.out.println("value : " + value);
		System.out.println("k : " + k);
		
		if(value > 1){
			c[k] = value%2;
			k--;
			binary2(value/2);
		}else{
			c[k] = value;
			c[0] = k;
		}
		
	}
	
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		
		args = new String[1];
		args[0] = "80";
		
		if(args.length < 1){
			System.out.println("Usage : java DecimalToBinary number");
			System.exit(1);
		}
		
		int value = Integer.parseInt(args[0]);
		DecimalToBinary d = new DecimalToBinary();

//		int[] b = d.binary(value);
//		int[] b = d.binaryShift(value);
		d.binary2(value);
		
		
		System.out.println("10진수 " + value + "를 이진수로 바꾸면 -->");
//		for(int j = b[0]; j < 64; j++){
//			System.out.print(b[j]);
//		}
		
		//재귀함수이용시
		for(int j = c[0]; j < 64; j++){
			System.out.print(c[j]);
		}
		
		
		System.out.println("\n\n총 소요시간 : " + (System.currentTimeMillis() - time) + "millis");
		Runtime r = Runtime.getRuntime();
		long t = r.totalMemory();
		long f = r.freeMemory();
		System.out.println("총 메모리 : " + t + "bytes");
		System.out.println("남은 메모리 : " + f + "bytes");
		System.out.println("");
		
	}
	
}
