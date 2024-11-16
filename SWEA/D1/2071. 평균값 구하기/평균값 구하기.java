import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n =0;
            double avg;
            for(int i=0; i<10; i++){
                n += sc.nextInt();
            }
            avg = n/10.0;
            int answer; 
            answer = (int)Math.round(avg);
            System.out.println("#"+test_case+" "+answer);
		}
	}
}