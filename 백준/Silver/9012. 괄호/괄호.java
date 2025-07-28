import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<T; i++){
            String line = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean isbracket = true;
            for(char c :line.toCharArray()){
                if(c==')'){
                    if(stack.isEmpty()){
                        isbracket = false;
                        break;
                    }else {
                    stack.pop();
                    }
                }else if(c=='('){
                    stack.push(c);
                }
            }
            if(stack.isEmpty() && isbracket){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }

    }
}

