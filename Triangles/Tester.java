package workshop2;

public class Tester {

	public static void main(String[] args) {
	
		Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3),new MyPoint(5, 3.5));
		Triangle2D t2 = new Triangle2D(new  MyPoint(0,0), new MyPoint(0, 2), new MyPoint(2, 0));
		
		
		System.out.println(t1.getArea());
		System.out.println(t1.getPerimeter());
		
		System.out.println(t2.getArea());
		System.out.println(t2.getPerimeter());
		

		
	}

}
