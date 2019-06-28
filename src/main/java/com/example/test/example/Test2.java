package com.example.test.example;

public class Test2 {
	public static int  show(int i) throws Exception {
		if(i==0) {
			throw new Exception("i ==0");
		}
		int a =  3/i;
		return a;
	}
	public static int show1(int i) {
		int a = 0;
		try {
			a = 3/i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("show1 error");
			e.printStackTrace();
		}
		return a;
	}
	
	public  static void test() {
		try {
			show1(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		test();
	}

}
