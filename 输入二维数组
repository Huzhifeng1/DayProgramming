import java.util.Scanner;

public class Exercise7_2_sumMajorDiagonal {
	public static void main(String[] args) {
		int[][] m = new int[4][4];
		System.out.println("Enter a 4-by-4 matrix row by row");
		Scanner reader = new Scanner(System.in);

		for (int i = 0; i < 4; i++) { // 循环输入
			for (int j = 0; j < 4; j++) {
				m[i][j] = reader.nextInt();
			}
		}
		System.out.println("你输入的数组为");
		for (int i = 0; i < 4; i++) { // 循环输出
			for (int j = 0; j < 4; j++) {
				System.out.print(m[i][j] + " ");
				}
				System.out.println();	
		}

		int sum = m[0][0] + m[1][1] + m[2][2] + m[3][3];
		System.out.println("Sum of the elements in the major diagonal is " + sum);

	}

}
