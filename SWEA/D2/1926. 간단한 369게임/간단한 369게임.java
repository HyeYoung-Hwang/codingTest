/////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
            String num = Integer.toString(test_case);
            String clap="";
            char ch[] = num.toCharArray();
            for(int i=0; i<ch.length; i++){
            	if(ch[i] == '3' || ch[i] == '6' || ch[i] == '9'){
                    clap +="-";
                }
            }
            if(clap.contains("-")){
            	System.out.print(clap+" ");
            }else{
            	System.out.print(test_case+" ");
            }
		}
	}
}