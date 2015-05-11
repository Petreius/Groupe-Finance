package Data;
import GUI.CoordinatesXY;

public class KernelFitter {
	public CoordinatesXY ComputeKernelFitter(double[] portfolioReturns, double step, double min, double max){
		double std = ComputeSTD(portfolioReturns);
		double bandwidth = 1.06*std/(Math.pow(portfolioReturns.length,0.2));
		CoordinatesXY coordinatesXY = new CoordinatesXY();
		double value = 0;
		
		for(double x = min; x <= max; x+=step){
			for(int i = 0; i < portfolioReturns.length; i++){
				value += (1/Math.pow(2*Math.PI,0.5)) * Math.exp(-0.5*Math.pow((x-portfolioReturns[i])/bandwidth,2));
			}
			coordinatesXY.setCoordinates(x , (1/(portfolioReturns.length*bandwidth))*value);
			value = 0;
		}
		return coordinatesXY;
	}

	public double ComputeSTD(double[] portfolioReturns){
		double powerSum1 = 0;
		double powerSum2 = 0;
		double stdev = 0;

		for(int i = 0; i < portfolioReturns.length; i++) {
		    powerSum1 += portfolioReturns[i];
		    powerSum2 += Math.pow(portfolioReturns[i], 2);
		    stdev = Math.sqrt(i*powerSum2 - Math.pow(powerSum1, 2))/i;
		}
		return stdev;
	}
}
