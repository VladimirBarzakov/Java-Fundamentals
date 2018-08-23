package p08_pet_clinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Pet> pets = new HashMap<>();
        Map<String, PetClinic> clinicMap = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            try {
                switch (command){
                    case "Create":
                        String type = tokens[1];
                        String name = tokens[2];
                        switch (type){
                            case "Pet":
                                Pet pet = new Pet(name, Integer.parseInt(tokens[3]),tokens[4]);
                                pets.put(name, pet);
                                break;
                            case "Clinic":
                                PetClinic clinic = new PetClinic(Integer.parseInt(tokens[3]));
                                clinicMap.put(name, clinic);
                                break;
                        }
                        break;
                    case "Add":
                        String petName = tokens[1];
                        String clinicName = tokens[2];
                        Pet pet = pets.get(petName);
                        PetClinic clinic = clinicMap.get(clinicName);
                        System.out.println(clinic.addPet(pet));
                        break;
                    case "Print":
                        clinicName = tokens[1];
                        if (tokens.length==2){
                            clinicMap.get(clinicName).print();
                        } else{
                            clinicMap.get(clinicName).print(Integer.parseInt(tokens[2]));
                        }
                        break;
                    case "Release":
                        clinicName = tokens[1];
                        System.out.println(clinicMap.get(clinicName).releasePet());
                        break;
                    case "HasEmptyRooms":
                        clinicName = tokens[1];
                        System.out.println(clinicMap.get(clinicName).hasEmptyRooms());
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
