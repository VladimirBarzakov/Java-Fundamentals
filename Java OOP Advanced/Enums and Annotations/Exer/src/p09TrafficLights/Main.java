package p09TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<LightCommand> trafficLights= Arrays.stream(reader.readLine().split("\\s+"))
                .map(x->LightCommand.valueOf(LightCommand.class, x))
                .collect(Collectors.toList());
        LightCommand[] states = LightCommand.values();
        StringBuilder builder = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLights.size(); j++) {
                int newIndex = (trafficLights.get(j).ordinal()+1)%states.length;
                trafficLights.set(j,states[newIndex]);
                builder.append(trafficLights.get(j).name()).append(" ");
            }
            builder.append(System.lineSeparator());
        }
        System.out.println(builder.toString()   );
    }
}
