package workshop2;

import java.lang.Math;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

//Three points named p1, p2, and p3 of the type MyPoint with getter and setter methods. O
//•A no-arg constructor that creates a default triangle with the points (0, 0), (1,1), and (2, 5). O
//•A constructor that creates a triangle with the specified points. O
//•A method getArea() that returns the area of the triangle. O
//•A method getPerimeter() that returns the parameter of the triangle. O
//•A method contains(MyPoint p) that returns true if the specified point p is inside this triangle (see Figure A).
//•A method contains(Triangle2D t) that returns true if the specified triangle is inside this triangle (see Figure B).
//•A method overlaps(Triangle2D t) that returns true if the specified triangle overlaps with this triangle (see Figure C)

public class Triangle2D {

	MyPoint p1;
	MyPoint p2;
	MyPoint p3;
	Line2D.Double triSide1;
	Line2D.Double triSide2; 
	Line2D.Double triSide3; 
	
	
	Triangle2D(){ 																				//Default Constructor
		p1 = new MyPoint(0,0);
		p2 = new MyPoint(1,1);
		p3 = new MyPoint(2,5);	
		this.setTriLines();
	}
	
	
	Triangle2D(MyPoint other1, MyPoint other2, MyPoint other3) {								//Three arg Constructor with point objects	
		p1 = other1;
		p2 = other2;
		p3 = other3;
		this.setTriLines();
	}
	
	
	Triangle2D(double a1, double b1, double a2, double b2, double a3, double b3) {				//raw value Constructor
		
		p1 = new MyPoint(a1,b1);
		p2 = new MyPoint(a2,b2);
		p3 = new MyPoint(a3,b3);
		this.setTriLines();
	}
	
	public void setTriLines() { 																//makes the points into actual lines that we can use later
		triSide1 = new Line2D.Double(p1.xyGetter().getX(), p1.xyGetter().getY(), p2.xyGetter().getX(), p2.xyGetter().getY());
		triSide2 = new Line2D.Double(p2.xyGetter().getX(), p2.xyGetter().getY(), p3.xyGetter().getX(), p3.xyGetter().getY());
		triSide3 = new Line2D.Double(p3.xyGetter().getX(), p3.xyGetter().getY(), p1.xyGetter().getX(), p1.xyGetter().getY());
	}
	
	public double getArea() {
		
		double ptx1 = p1.xyGetter().getX();
		double ptx2 = p2.xyGetter().getX();
		double ptx3 = p3.xyGetter().getX();
		double pty1 = p1.xyGetter().getY();
		double pty2 = p2.xyGetter().getY();
		double pty3 = p3.xyGetter().getY();
				
		double area =
			(((ptx1*pty2) + 
			 (ptx2*pty3) +
			 (ptx3*pty1) - 
			 (ptx1*pty3) - 
			 (ptx2*pty1) - 
			 (ptx3*pty2)) / 2);		
		if(area < 0) {
			area = area * -1;
		}	
		
		return area;
	}
	
	
	public double getPerimeter() {
		
		double dist1 = p1.distanceObj(p2);
		double dist2 = p2.distanceObj(p3);
		double dist3 = p3.distanceObj(p1);
			double perimeter = dist1 + dist2 + dist3;
		return perimeter;
	}
	
	public Point2D pointGetter(int getChoice) {											//Getter for points of triangle
		
	    Point2D.Double Choice = new Point2D.Double();
        switch (getChoice) {
            case 1:  Choice = p1.xyGetter();
                     break;
            case 2:  Choice = p2.xyGetter();
                     break;
            case 3:  Choice = p3.xyGetter();
                     break;
            default: break; //NEEDS FIXING, DEFAULT SHOULD NOT BE DEFAULT VALUE OF POINT2D
        	}
		
		return Choice;
	}
	
	
	public boolean contains(double x, double y) {
		
		MyPoint outIn = new MyPoint(x,y);
		Triangle2D triangle1 = new Triangle2D(p1, p2, outIn);
		Triangle2D triangle2 = new Triangle2D(p2, p3, outIn);
		Triangle2D triangle3 = new Triangle2D(p1, p3, outIn);
		double pointArea = triangle1.getArea() + triangle2.getArea() + triangle3.getArea();
		if(pointArea == this.getArea()) {
			return true;
		}else {
		return false;
		}
	}
	
	
	public boolean contains(MyPoint outIn) {
//		Line2D.Double line1 = new Line2D.Double(p1.xyGetter(), outIn.xyGetter());
//		Line2D.Double line2 = new Line2D.Double(p2.xyGetter(), outIn.xyGetter());
//		Line2D.Double line3 = new Line2D.Double(p3.xyGetter(), outIn.xyGetter());
				
//			if(line1.intersectsLine(triSide2) || line1.intersectsLine(triSide3)
//			|| line2.intersectsLine(triSide1) || line2.intersectsLine(triSide3)
//			|| line3.intersectsLine(triSide1) || line3.intersectsLine(triSide2)) {
//			return false; }
//				else{
//					return true; }
		
		Triangle2D triangle1 = new Triangle2D(p1, p2, outIn);
		Triangle2D triangle2 = new Triangle2D(p2, p3, outIn);
		Triangle2D triangle3 = new Triangle2D(p1, p3, outIn);
		double pointArea = triangle1.getArea() + triangle2.getArea() + triangle3.getArea();
		if(pointArea == this.getArea()) {
			return true;
		}else {
		return false;
		}
	}
	
public boolean contains(Triangle2D x) {
		
		double xArea = x.getArea();
		if(xArea <= this.getArea() && this.contains(x.p1) && this.contains(x.p2) && this.contains(x.p3)) {
			return true;
		}else {
		return false;
		}
	}

public boolean overlaps(Triangle2D x) {
	
	if(this.contains(x.p1) || this.contains(x.p2) || this.contains(x.p3)) {
		return true;
	}else if(this.contains(x)){
	return false;
	}else {return false;}
}
}
