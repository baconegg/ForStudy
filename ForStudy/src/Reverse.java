
public class Reverse {

	char[] reverse(String s){
		int len = s.length();
		char[] c = new char[len];
		
		for(int i = 0; i < len; i++){
			c[i] = s.charAt(len - 1 - i);
		}
		
		return c;
	}
	
	
	public static void main(String[] args) {
		
		args = new String[1];
		args[0] = "abcd";
		
		if(args.length < 1){
			System.out.println("Usage : java Reverse 문자열");
			System.exit(1);
		}
		
		String s = args[0];
		Reverse r = new Reverse();
		System.out.println(r.reverse(s));
		
	}
	
}
