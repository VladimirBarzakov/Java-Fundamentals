package p11_cat_lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Cat> cats= new HashMap<>();
        String line;
        while (true){
            line=reader.readLine();
            if ("End".equals(line)){
                break;
            }
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double param = Double.parseDouble(tokens[2]);
            Cat cat = null;
            switch (type){
                case "p11_cat_lady.Siamese":
                    cat= new Siamese(type, name, param);
                    break;
                case "p11_cat_lady.Cymric":
                    cat= new Cymric(type,name, param);
                    break;
                case "p11_cat_lady.StreetExtraordinaire":
                    cat = new StreetExtraordinaire(type,name, param);
                    break;
            }
            cats.put(name, cat);
        }
        System.out.println(cats.get(reader.readLine()));
    }
}
