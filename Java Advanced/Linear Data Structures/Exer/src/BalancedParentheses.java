import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {
            String element = String.valueOf(line.charAt(i));
            switch (element){
                case "{":
                case "[":
                case "(":
                    stack.push(element);
                    break;
                case "}":
                    if (stack.size()==0||!stack.peek().equals("{")){
                        System.out.println("NO");
                        return;
                    } else{
                        stack.pop();
                    }
                    break;
                case "]":
                    if (stack.size()==0||!stack.peek().equals("[")){
                        System.out.println("NO");
                        return;
                    } else{
                        stack.pop();
                    }
                    break;
                case ")":
                    if (stack.size()==0||!stack.peek().equals("(")){
                        System.out.println("NO");
                        return;
                    } else{
                        stack.pop();
                    }
                    break;

            }
        }
        System.out.println("YES");
    }
}
