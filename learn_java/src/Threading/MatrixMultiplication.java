package Threading;

public class MatrixMultiplication extends Thread {
	
	static int[][] A1={{1,2,3},{4,5,6},{7,8,9}};
	static int[][] B1={{1,2,3},{4,5,6},{7,8,9}};
	static int[][] C1=new int[3][3];
	int i,j;
	public MatrixMultiplication(int i, int j){
		this.i= i;
		this.j= j;
	}
	
	public static void main(String[] args) {
		MatrixMultiplication[][] m = new MatrixMultiplication[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				m[i][j] = new MatrixMultiplication(i, j);
				m[i][j].start();
			}
		}
	  
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(" "+C1[i][j]);
			}
			System.out.println();
		}
		
		
		
	
}
public void run(){
	for(int k=0;k<3;k++){
		C1[i][j] += A1[i][k] * B1[k][j];
		//System.out.println("value for  i ="+i+" j = "+j+" "+C1[i][j]);
	}

}
}
