package ie.home.matrixes;

public class MatrixHelpers {
	
	/**
	 *  0  1  1  0
	 *  0  0  0  1
	 *  0  1  0  1
	 *  0  0  0  0
	 *  
	 *  create this matrix. and test this function
	 *  this is used for getting 2 hopes neighbours of a graph
	 *  graph is above in matrix representation
	 */
	public static int[][] matrixToPowerTwo(int[][] adjMatrix) {
		int verticesNum = adjMatrix.length;
		int[][] multipliedMatrix = new int[verticesNum][verticesNum];
		
		// row
		for (int i = 0; i < verticesNum; i++) {
			// column from second matrix
			for (int j = 0; j < verticesNum; j++) {
				// row in second column
				int result = 0;
				
				for (int k = 0; k < verticesNum; k++) {
					int num1 = adjMatrix[i][k];
					int num2 = adjMatrix[k][j];
					result += num1 * num2;
//				System.out.print(num1 + " * " + num2 + " + ");
				}
//				System.out.println();
				multipliedMatrix[i][j] = result;
			}
		}
		
//		for (int i = 0; i < verticesNum; i++) {
//			for (int j = 0; j < multipliedMatrix.length; j++) {
//				System.out.print(multipliedMatrix[i][j]);
//			}
//			System.out.println();
//		}
		
		return multipliedMatrix;
	}

}
