
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> operators = new HashMap<>();
        operators.put("+",1);
        operators.put("-",1);
        operators.put("*",2);
        operators.put("/",2);
        //List<String> operators = Arrays.asList("+", "-","", "*", "/");
        StringBuilder builder  = new StringBuilder();
        ArrayDeque<String> output = new ArrayDeque<>();
        LinkedList<String> operatorStack = new LinkedList<>();

        String[] input = reader.readLine().split(" ");

        for (String s: input) {
            if ((isDigit(s) || (Character.isLetter(s.charAt(0))
                    && Character.toLowerCase(s.charAt(0))==s.charAt(0))) &&
                    !"(".equals(s) &&
                    !")".equals(s)){
                output.add(s);
            } else if("(".equals(s)){

                operatorStack.push(s);
            } else if(")".equals(s)){

                while (!operatorStack.peek().equals("(")){
                    output.add(operatorStack.pop());
                }
                operatorStack.pop();
            } else if (operators.containsKey(s)){

                    while (!operatorStack.isEmpty()
                            && !operatorStack.peek().equals("(")
                            && operators.get(operatorStack.peek()) >= operators.get(s)
                            ){
                        output.add(operatorStack.pop());
                    }
                    operatorStack.push(s);

            }
        }
        while (!operatorStack.isEmpty()){
            output.add(operatorStack.pop());
        }
        while (!output.isEmpty()){
            builder.append(output.remove()).append(" ");
        }
        System.out.println(builder.toString().trim());
    }

    private static boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
