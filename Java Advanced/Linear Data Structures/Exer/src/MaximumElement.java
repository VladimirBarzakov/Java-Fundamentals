import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        SortedMap<Integer, Integer> tree = new TreeMap<>(Comparator.reverseOrder());
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String codeCommand = reader.readLine();
            switch (codeCommand){
                case "2":
                    if (!stack.isEmpty()){
                        int key = stack.pop();
                        tree.put(key,tree.get(key)-1);
                        if (tree.get(key)==0){
                            tree.remove(key);
                        }
                    }
                    break;
                case "3":
                    if (stack.isEmpty()){
                        builder.append(0).append(System.lineSeparator());
                    } else{

                        builder.append(tree.firstKey()).append(System.lineSeparator());
                    }
                    break;
                    default:
                    int element =Integer.parseInt(codeCommand.substring(2));
                    stack.push(element);
                    if (!tree.containsKey(element)){
                        tree.put(element,1);
                    } else{
                        tree.put(element,tree.get(element)+1);
                    }
                    break;
            }
        }
        System.out.println(builder.toString());
    }
}
