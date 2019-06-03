package workshop2;

public class Tester {

//			Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3),new MyPoint(5, 3.5));
//			Triangle2D t2 = new Triangle2D(new  MyPoint(0,0), new MyPoint(0, 2), new MyPoint(2, 0));

			Triangle2D t1 = new Triangle2D(new MyPoint(0,0), new MyPoint(100, 0),new MyPoint(0, 100));
			Triangle2D t2 = new Triangle2D(new  MyPoint(0,0), new MyPoint(0, 2), new MyPoint(2, 0));
			
			System.out.println(t1.getArea());
			System.out.println(t1.getPerimeter());
			System.out.println(t1.contains(3, 3));
			System.out.println(t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))));
			System.out.println(t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), new MyPoint(2, 6.5))));
			
			
			System.out.println(t2.getArea());
			System.out.println(t2.getPerimeter());
			System.out.println(t2.contains(1,1));
			System.out.println(t2.contains(new Triangle2D(new MyPoint(4, 5), new MyPoint(10.5, 3.2), new MyPoint(-0.5, -10.5))));
			System.out.println(t2.overlaps(new Triangle2D(new MyPoint(1, 1.7), new MyPoint(-1, 1.7), new MyPoint(0, -3))));
			
		}
}
