import java.util.Scanner;

public class Hourglass {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				a[i][j] = in.nextInt();
			}
		}
        in.close();
        
        int max = 0;
        boolean flag = true;
        
        for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
			    int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
                if(flag){
                    max = temp;
                    flag = false;
                }
                if(temp > max) {
                    max = temp;
                }
			}
		}
        System.out.println(max);
	}

}