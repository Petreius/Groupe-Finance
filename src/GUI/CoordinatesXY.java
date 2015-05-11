package GUI;

import java.util.ArrayList;

public class CoordinatesXY {
	private ArrayList<Double> CoordX = new ArrayList<Double>();
	private ArrayList<Double> CoordY = new ArrayList<Double>();
	
	public CoordinatesXY(){
	}
	
	public double getX(int index){
		return this.CoordX.get(index);
	}
	
	public ArrayList<Double> getCoordinatesX(){
		return this.CoordX	;
	}
	
	public double getY(int index){
		return this.CoordY.get(index);
	}
	
	public ArrayList<Double> getCoordinatesY(){
		return this.CoordY;
	}
	
	public void setCoordinates(double X, double Y) {
		this.CoordX.add(X);
		this.CoordY.add(Y);
	}
}
