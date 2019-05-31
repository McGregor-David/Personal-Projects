package workshop2;

import java.lang.Math;
import java.awt.geom.Point2D;

public class MyPoint {

//	double[] xyCoord;
	Point2D.Double xyCoord;
	
	MyPoint(){
//		xyCoord = new double[2];
//		xyCoord[0] = 0;
//		xyCoord[1] = 0;
		xyCoord = new Point2D.Double();
	}
	
	
	MyPoint(double x, double y){
//		xyCoord = new double[2];
//		xyCoord[0] = x;
//		xyCoord[1] = y;
		xyCoord = new Point2D.Double(x, y);
	}
	
	
	public double distanceObj(MyPoint other) {
//		double distance = 
//		Math.sqrt(Math.pow((xyCoord[0]- other.xyCoord[0]),2) + Math.pow((xyCoord[1]- other.xyCoord[1]),2));
//		return distance;
		double distance = 
			Math.sqrt(Math.pow((xyCoord.getX()- other.xyCoord.getX()),2) + Math.pow((xyCoord.getY()- other.xyCoord.getY()),2));
		return distance;
	}
	
	
	public double distanceCoord(double x, double y) {
//		double distance = 
//		Math.sqrt(Math.pow((xyCoord[0]- x),2) + Math.pow((xyCoord[1]- y),2));
//		return distance;
		
		double distance = 
			Math.sqrt(Math.pow((xyCoord.getX() - x),2) + Math.pow((xyCoord.getY()- y),2));
		return distance;
	}
	
	
	public Point2D.Double xyGetter() {
		return xyCoord;
	}
	
	
}
