package com.uby.java.ch14;

import java.util.function.Function;

// 최상위 Geometry 인터페이스 생성 => 추상 메서드로 면적구하는 메서드 선언
interface GGeometry{
	abstract double getArea();
}

// 자식 클래스를 생성 => Circle, Rectangular, Triangle

class CCircle implements GGeometry{
	
	int radious;
	
	CCircle (int r){
		this.radious = r;
	}
	@Override
	public double getArea() {
		return Math.PI * radious * radious;
	}
	
}

class RRectangular implements GGeometry{
	int width;
	int height;
	RRectangular(int w, int h){
		this.width = w;
		this.height = h;
	}
	@Override
	public double getArea() {
		return width * height;
	}	
}

class TTriangle implements GGeometry{
	int width;
	int height;
	TTriangle(int w, int h){
		this.width = w;
		this.height = h;
	}
	@Override
	public double getArea() {
		return width * height * 0.5;
	}	

}

public class GeoArea_ans {
	public static void main(String[] args) {
		
		//Function 람다 작성
		// 출력
		
		Function<GGeometry, Double> func = (g) ->{
			return g.getArea();
		};
	System.out.println("원 면적 : " + func.apply(new CCircle(5)));	
	System.out.println("삼각형 면적 : " + func.apply(new RRectangular(5,5)));	
	System.out.println("사각형 면적 : " + func.apply(new TTriangle(5,5)));	
	}
}
