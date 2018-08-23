import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LittleAlchemy {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Long> deque = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Long> goldStorage = new ArrayDeque<>();

        String line;
        while (true){
            line=reader.readLine();
            if ("Revision".equals(line)){
                break;
            }
            String[] tokens = line.split(" ");
            Long param =0l;
            switch (tokens[0]){
                case "Apply":
                    param=Long.parseLong(tokens[2]);
                    applyAcid(deque,goldStorage,param);
                    break;
                case "Air":
                    param=Long.parseLong(tokens[2]);
                    applyAir(deque,goldStorage,param);
                    break;
            }

        }
        System.out.println(deque.toString().replaceAll("[\\[\\],]",""));
        System.out.println(goldStorage.size());
        System.out.println();
    }

    private static void applyAir(ArrayDeque<Long> deque,
                                 ArrayDeque<Long> goldStorage,
                                 Long air) {
        if (goldStorage.isEmpty()){
            return;
        }
        deque.addLast(goldStorage.removeLast()+air);
    }

    private static void applyAcid(ArrayDeque<Long> deque,
                                  ArrayDeque<Long> goldStorage,
                                  Long acid) {

        if (deque.isEmpty()){
            return;
        }
        while (acid>0 && !deque.isEmpty()){
            acid--;
            if (deque.getFirst()>1){
                deque.addLast(deque.removeFirst()-1);
            } else{
                goldStorage.addLast(deque.removeFirst()-1);
            }
        }
    }
}
