import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Internship {

    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        int problemCount = Integer.parseInt(reader.readLine());
        int candidatesCount = Integer.parseInt(reader.readLine());

        ArrayDeque<String> problems = new ArrayDeque<>();
        for (int i = 0; i < problemCount; i++) {
            problems.addLast(reader.readLine());
        }

        Pattern pattern = Pattern.compile("^[A-Z][a-z]*\\s+[A-Z][a-z]*$");
        String line;
        ArrayDeque<String> candidates = new ArrayDeque<>();
        for (int i = 0; i < candidatesCount; i++) {
            line = reader.readLine();
            Matcher matcher= pattern.matcher(line);
            if (matcher.find()){
                candidates.addLast(line);
            }
        }

        while (!problems.isEmpty() && candidates.size()>1){
            String candidate = candidates.removeFirst();
            String problem = problems.removeLast();
            if (canCandidateSolveProblem(candidate,problem)){
                System.out.printf("%s solved %s.%n",candidate,problem);
                candidates.addLast(candidate);
            } else{
                System.out.printf("%s failed %s.%n",candidate,problem);
                problems.addFirst(problem);
            }
        }
        if (candidates.size()==1){
            System.out.printf("%s gets the job!",candidates.peek());
        } else{
            System.out.println(candidates.toString().replaceAll("[\\[\\]]",""));
        }

    }

    private static boolean canCandidateSolveProblem(String candidate, String problem) {
        return  (candidate.chars().sum()>problem.chars().sum());
    }
}
