package workshop2;

//Three points named p1, p2, and p3 of the type MyPoint with getter and setter methods. O
//•A no-arg constructor that creates a default triangle with the points (0, 0), (1,1), and (2, 5). O
//•A constructor that creates a triangle with the specified points. O
//•A method getArea() that returns the area of the triangle. 
//•A method getPerimeter() that returns the parameter of the triangle.
//•A method contains(MyPoint p) that returns true if the specified point p is inside this triangle (see Figure A).
//•A method contains(Triangle2D t) that returns true if the specified triangle is inside this triangle (see Figure B).
//•A method overlaps(Triangle2D t) that returns true if the specified triangle overlaps with this triangle (see Figure C)

public class Triangle2D {

	MyPoint p1;
	MyPoint p2;
	MyPoint p3;
	
	
	Triangle2D(){ 																//Default Constructor
		
		p1 = new MyPoint(0,0);
		p2 = new MyPoint(1,1);
		p3 = new MyPoint(2,5);
	}
	
	
	Triangle2D(MyPoint other1, MyPoint other2, MyPoint other3) {				//Three arg Constructor with point objects
		
		p1 = other1;
		p2 = other2;
		p3 = other3;
	}
	
	
	Triangle2D(double x1, double y1, double x2, double y2, double x3, double y3) {				//Three arg Constructor
		
		MyPoint point1 = new MyPoint(x1,y1);
		MyPoint point2 = new MyPoint(x2,y2);
		MyPoint point3 = new MyPoint(x3,y3);
		
		this.pointSetter(point1, point2, point3);	
	}
	
	
	public double getArea() {
		
		double[] point1 = new double[2];
		double[] point2 = new double[2];
		double[] point3 = new double[2];
				
		System.out.println(point1 + "     " + point2 + "      " + point3);
		
		double area = 
		p1.xyCoord[0] * (p2.xyCoord[1] - p3.xyCoord[1]) + p2.xyCoord[0] * (p3.xyCoord[1] - p1.xyCoord[1]) + p3.xyCoord[0] * (p1.xyCoord[1] - p2.xyCoord[1]);
		
		if(area < 0) {
			area = area * -1;
		}
		
		return area;
	}
	
	public MyPoint[] pointGetter() {											//Getter for points of triangle
		
		MyPoint pointArr[] = new MyPoint[3];
		pointArr[0] = p1;
		pointArr[1] = p2;
		pointArr[2] = p3;
		
		return pointArr;
	}
	
	
	public void pointSetter(MyPoint other1, MyPoint other2, MyPoint other3) {	//Setter for Triangle points
		
		p1 = other1;
		p2 = other2;
		p3 = other3;
	}
	
	
	
	
}
