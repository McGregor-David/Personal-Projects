package workshop2;


public class MyPoint {

	double[] xyCoord;
	
	
	MyPoint(){
		xyCoord = new double[2];
		xyCoord[0] = 0;
		xyCoord[1] = 0;
	}
	
	
	MyPoint(double x, double y){
		xyCoord = new double[2];
		xyCoord[0] = x;
		xyCoord[1] = y;
	}
	
	
	public double[] distanceObj(MyPoint other) {
		double[] distance = new double[2];
		distance[0] = xyCoord[0] - other.xyCoord[0];
		distance[1] = xyCoord[1] - other.xyCoord[1];
		return distance;
	}
	
	
	public double[] distanceCoord(double x, double y) {
		double[] distance = new double[2];
		distance[0] = xyCoord[0] - x;
		distance[1] = xyCoord[1] - y;
		return distance;
	}
	
	
	public double[] xyGetter() {
		return xyCoord;
	}
	
	
}
