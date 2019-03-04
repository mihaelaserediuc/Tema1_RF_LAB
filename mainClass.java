package lab1_rf;

public class mainClass {
	private static double[][] normalizeLearningSet(double[][] learningSet) {
		double[][] normalizedLearningSet = new double[learningSet.length][];
		
		double[] max = new double[learningSet[0].length];
		double[] min = new double[learningSet[0].length];
		
		for(int i = 0; i < learningSet[0].length; i++)
		{
			max[i] = learningSet[0][i];
			min[i] = learningSet[0][i];
		}
		
	    for (int row = 1; row < learningSet.length; row++) {
	        for (int column = 0; column < learningSet[0].length; column++) {
	            if (learningSet[row][column] > max[column]) {
	                max[column] = learningSet[row][column];
	            }
	            if (learningSet[row][column] < min[column]) {
	            	min[column] = learningSet[row][column];
	            }
	        }
	    }
	    
	    for (int row = 0; row < learningSet.length; row++) {
	    	normalizedLearningSet[row] = new double[learningSet[0].length];
	        for (int column = 0; column < learningSet[0].length; column++) {
	        	normalizedLearningSet[row][column] = 
	        		(learningSet[row][column] - min[column]) / (max[column] - min[column]);
	        }
	    }
		
		return normalizedLearningSet;
	}

	public static void main(String[] args) {
		double[][] learningSet = FileUtils.readLearningSetFromFile("in.txt");
		 FileUtils.writeLearningSetToFile("C:\\Users\\Student\\eclipse-workspace\\lab1_rf\\output.csv", normalizeLearningSet(learningSet));

	}

}
