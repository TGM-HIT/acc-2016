package langheiter.david;

public class Turn {
	
	public static void main(String[] args) {
		int size = 5;
		
		char[][] raster = new char[size][size + 10];
		
		for(int i = 0; i < size; i++) {
			for(int a = 0; a < size; a++) {
				raster[i][a] = Math.random() < 0.2 ? 'x' : 'o';
			}
		}
		
		for(int i = 0; i < size; i++) {
			printArr(raster);
			raster = turn(raster);
		}
		printArr(raster);
		
		
	}
	
	/**
	 * Print 2 Dimensional arrays
	 * 
	 * @param in Array to print
	 */
	public static void printArr(char[][] in) {
		for(char[] i : in) {
			for(char j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Turns an array by 90 deg to the right
	 * 
	 * @param in Array to turn
	 * @return Turned array
	 */
	public static char[][] turn(char[][] in) {
		int M = in.length;
	    int N = in[0].length;
	    char[][] ret = new char[N][M];
	    
	    for (int i = 0; i < M; i++) {
	        for (int c = 0; c < N; c++) {
	            ret[c][M - 1 - i] = in[i][c];
	        }
	    }
	    
	    return ret;
	}
	
}
