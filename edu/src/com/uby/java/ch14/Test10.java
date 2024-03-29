package com.uby.java.ch14;

//interface StringFunc3{
//	String modify(String s);
//}

//public class Test10 {
//
//	static String func(String s) {
//		String result = "";
//		char c;
//		for(int i = 0; i < s.length(); i++){
//			c = s.charAt(i);
//			if(c == ',')
//				result += " ";
//			else
//				result += c;
//		}
//		return result;
//	}
//	
//	
//	public static void main(String[] args) {
//		StringFunc3 sf = Test10::func; //인터페이스 타입의 메서드와 참조되는 클래스의 메서드는 같은 타입의 입력과 return을 가져야함!
//		
//		String str = "Korea,Australia,China,Germany,Spain,Turkey";
//		String result = sf.modify(str);
//		System.out.println(result);
//		
//		String str2 = "서울,북경,도쿄,뉴욕,발리";
//		result = sf.modify(str2);
//		System.out.println(result);
//	}
//}

interface StringFunc3{
	String modify(String s);
}

public class Test10 {

	String func(String s) {
		String result = "";
		char c;
		for(int i = 0; i < s.length(); i++){
			c = s.charAt(i);
			if(c == ',')
				result += " ";
			else
				result += c;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		Test10 obj = new Test10();
		StringFunc3 sf = obj::func; //인터페이스 타입의 메서드와 참조되는 클래스의 메서드는 같은 타입의 입력과 return을 가져야함!
		
		String str = "Korea,Australia,China,Germany,Spain,Turkey";
		String result = sf.modify(str);
		System.out.println(result);
		
		String str2 = "서울,북경,도쿄,뉴욕,발리";
		result = sf.modify(str2);
		System.out.println(result);
	}
}
