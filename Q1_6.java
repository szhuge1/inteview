/*
 * Given an image represented by an NxN matrix, 
 * where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees Can you do this in place?
 */
package array_string;

public class Q1_6 {
  
	public static int[][] rotate1(int[][] matrix){
		int len = matrix.length;
		int[][] newMatrix = new int[len][len];
		
		for(int i=0; i<len; i++){
			int[] temp = matrix[i];
			
			for(int j=0; j<len; j++){
				newMatrix[len - (1 + j)][i] = temp[j];
			}
		}
		
		return newMatrix;
	}
	
	public static void rotate2(int[][] matrix, int n){
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer; 
			int last=n-1-layer;
			for(int i = first; i < last; ++i) {
			int offset = i - first;
			int top = matrix[first][i]; // save top
			// left -> top
			matrix[first][i] = matrix[last-offset][first];
			// bottom -> left
			matrix[last-offset][first] = matrix[last][last - offset];
			// right -> bottom
			matrix[last][last - offset] = matrix[i][last];
			// top -> right
			matrix[i][last] = top; // right <- saved top }
			}
		}
	}
	
	
	public static void main(String[] args){
		int[][] matrix = new int[][]{
				{1,2,3},
				{11,12,13},
				{21,22,23}
		};
		
		int len = matrix.length;
		
		rotate2(matrix, len);
		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				System.out.print("[" + matrix[i][j] + "]");
			}
			System.out.println();
		}
	}
}
