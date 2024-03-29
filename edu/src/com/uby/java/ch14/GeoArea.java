package com.uby.java.ch14;

interface Geometry{
}

class Circle implements Geometry{
	int radious;
	Circle(int r){
		this.radious = r;
	}
}

class Rectangular implements Geometry{
	int width;
	int height;
	Rectangular(int w, int h){
		this.width = w;
		this.height = h;
	}	
}

class Triangle implements Geometry{
	int width;
	int height;
	Triangle(int w, int h){
		this.width = w;
		this.height = h;
	}	
}

public class GeoArea {
	public static void main(String[] args) {
		Function<Geometry, Double> cir = (g) ->{
			double area = Math.pow(g,2);
			return area;
		};
		
		Function<Geometry, Double> rec = (g) ->{
			
			double area;
			
			return area;
		};
		
		Function<Geometry, Double> tri = (g) ->{
			
			double area;
			
			return area;
		};
		
		
		double area_Cir = cir.apply(10); 
	}

	
}
