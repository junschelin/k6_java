package com.ruby.java.ch08.innerClass;


interface Messenger{
	String getMessage();
	void setMessage(String msg);
}

public class MessengerTest2 {
	public static void main(String[] args) {
//		Messenger test = new Messenger();
		Messenger test = new Messenger() {
			public String getMessage() {
				return "test";
			}
			public void setMessage(String msg) {
				System.out.println();
			}
			
		};
	}

}
