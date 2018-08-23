import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Robotics {
    private static BufferedReader reader;
    private static LinkedList<String> robotQueue;
    private static List<String> productQueue;
    private static HashMap<String,Long> robotCapacity;
    private static TreeMap<Long,LinkedList<String>> robotTimer;
    private static StringBuilder builder;
    private static int offset;
    private static long time;
    private static long startTimer;

    static {
        robotQueue = new LinkedList<>();
        productQueue = new ArrayList<>();
        robotCapacity = new HashMap<>();
        robotTimer = new TreeMap<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
        builder  = new StringBuilder();
        offset = -1;
        time=0;
        startTimer=0;
    }

    public static void main(String[] args) throws IOException {

        readInput();

        while (!productQueue.isEmpty()){
            startTimer=time;
            if(!robotTimer.isEmpty()&& robotQueue.isEmpty()){
                time = robotTimer.firstKey();
                time--;
            }
            time++;
            freeRobots();
            assignWorkLoad();
        }
        System.out.println(builder.toString());
    }

    private static void assignWorkLoad() {
        if (robotQueue.isEmpty()){
            return;
        }
        calculateOffset();
        String product = productQueue.get(offset);
        shortenProductQueue();

        String robot = robotQueue.removeLast();
        String currentTimeString = timeToString(time);
        generateMessage(robot,currentTimeString, product);
        if (robotCapacity.get(robot)==0){
            robotQueue.addFirst(robot);
        }else{
            long nextTimer = time+robotCapacity.get(robot);
            assignRobot(nextTimer,robot);
        }
    }

    private static void shortenProductQueue() {
        productQueue.remove(offset);
        if (!productQueue.isEmpty()){
            offset=(productQueue.size()+offset-1)%productQueue.size();
        }
    }

    private static void assignRobot(long nextTimer, String robot) {
        if (!robotTimer.containsKey(nextTimer)){
            robotTimer.put(nextTimer, new LinkedList<>());
        }
        robotTimer.get(nextTimer).add(robot);
    }

    private static void generateMessage(String robot,
                                        String currentTimeString,
                                        String product) {
        builder.append(
                String.format("%s - %s [%s]",
                        robot,
                        product,
                        currentTimeString) );
        builder.append(System.lineSeparator());
    }

    private static void calculateOffset() {
        offset=(int)((offset+(time-startTimer))%productQueue.size());
    }

    private static void readInput() throws IOException {
        readRobots();
        readStartTime();
        readProducts();
        if (robotQueue.isEmpty() || productQueue.isEmpty() || time<0){
            throw new IllegalArgumentException();
        }
    }

    private static void readProducts() throws IOException {
        String line;
        while (!"End".equals(line=reader.readLine().trim())){
            productQueue.add(line);
        }
    }
    
    private static void readRobots() throws IOException {
        String[] tokens = reader.readLine().split(";");

        for (String token:tokens) {
            String[] robotTokens= token.trim().split("-");
            String robot = robotTokens[0].trim();
            long robotProductivity = Long.parseLong(robotTokens[1].trim());

            robotCapacity.put(robot,robotProductivity);
            robotQueue.addFirst(robot);
        }
    }

    private static String timeToString(long time) {
        time=time%86400;
        long hours = time/3600;
        time=time%3600;
        long minutes = time/60;
        long seconds = time%60;
        return String.format("%02d:%02d:%02d",hours,minutes,seconds);
    }

    private static void freeRobots() {

        if (robotTimer.isEmpty() || robotTimer.firstKey()>time){
            return;
        }
        for (Long timeKey:robotTimer.subMap(
                robotTimer.firstKey(),
                true,
                time,
                true).keySet()) {
            while (!robotTimer.get(timeKey).isEmpty()){
                robotQueue.addFirst(robotTimer.get(timeKey).removeLast());
            }
            robotTimer.remove(timeKey);
        }
    }

    private static void readStartTime() throws IOException {
        String[] tokens = reader.readLine().split(":");
        long hour = 3600;
        long minute = 60;
        time =0;
        time+=Long.parseLong(tokens[0].trim())*hour;
        time+=Long.parseLong(tokens[1].trim())*minute;
        time+=Long.parseLong(tokens[2].trim());
    }
}
