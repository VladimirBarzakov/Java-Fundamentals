package p07_1984;

import p07_1984.contracts.Observer;
import p07_1984.contracts.Subject;
import p07_1984.factories.Factory;
import p07_1984.models.Institution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Factory factory = new Factory();
        Map<String, Subject> subjectMap = new LinkedHashMap<>();
        Map<String, Observer> observerMap = new LinkedHashMap<>();

        String[] tokens = reader.readLine().split("\\s+");
        int numEntities = Integer.parseInt(tokens[0]);
        int numInstitutions = Integer.parseInt(tokens[1]);
        int numChanges = Integer.parseInt(tokens[2]);

        for (int i = 0; i < numEntities; i++) {
            tokens=reader.readLine().split("\\s+");
            Subject subject = factory.createSubject(tokens);
            subjectMap.put(tokens[1], subject);
        }
        for (int i = 0; i <numInstitutions; i++) {
            tokens=reader.readLine().split("\\s+");

            Observer observer = new Institution(tokens[1], tokens[2],
                    Arrays.stream(tokens).skip(3).toArray(String[]::new));

            for (Subject subject : subjectMap.values()) {
                subject.addObserver(observer);
            }
            observerMap.put(tokens[1],observer);
        }
        for (int i = 0; i < numChanges; i++) {
            tokens=reader.readLine().split("\\s+");
            Subject subject = subjectMap.get(tokens[0]);
            String fieldName = tokens[1];
            String newValue = tokens[2];
            subject.updateStats(fieldName, newValue);
        }
        for (Observer observer : observerMap.values()) {
            System.out.println(observer.toString());
        }
    }
}
