import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        StringBuilder restorer = new StringBuilder();
        List<String> textRope = new ArrayList<>();
        LinkedList<String> stack = new LinkedList<String>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            switch (tokens[0]){
                case "1":
                    String[] word = tokens[1].split("");
                    textRope.addAll(Arrays.asList(word));
                    stack.push("~r"+word.length);
                    break;
                case "2":
                    int eraseCount =Integer.parseInt(tokens[1]);
                    restorer = new StringBuilder();
                    restorer.append("~u");
                    for (int count = 0; count < eraseCount; count++) {
                        if (textRope.size()==0){
                            break;
                        }
                        restorer.append(textRope.get(textRope.size()-1));
                        textRope.remove(textRope.size()-1);
                    }
                    stack.push(restorer.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    if (index<1||index>textRope.size()||textRope.size()==0){
                        continue;
                    }
                    builder.append(textRope.get(index-1)).append(System.lineSeparator());
                    break;
                case "4":
                    if (stack.size()==0){
                        continue;
                    }
                    String command = stack.pop();
                    String commandType = command.substring(0,2);
                    if (commandType.equals("~r")){
                        int undo = Integer.parseInt(command.substring(2));
                        for (int j = 0; j < undo; j++) {
                            textRope.remove(textRope.size()-1);
                        }
                    } else if(commandType.equals("~u")){
                        String[] restoreString = command.substring(2).split("");
                        for (int j = restoreString.length-1; j >=0 ; j--) {
                            textRope.add(restoreString[j]);
                        }
                        break;
                    }
                    break;
            }
        }
        System.out.println(builder.toString().trim());

    }
}
