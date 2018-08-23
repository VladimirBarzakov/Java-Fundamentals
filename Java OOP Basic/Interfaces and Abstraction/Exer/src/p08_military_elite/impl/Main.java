package p08_military_elite.impl;

import p08_military_elite.interfaces.Mission;
import p08_military_elite.interfaces.Private;
import p08_military_elite.interfaces.Repair;
import p08_military_elite.interfaces.Soldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Soldier> army = new LinkedHashMap<>();
        String input;

        while (true){
            input = reader.readLine();
            if ("End".equals(input)){
                break;
            }
            String[] tokens = input.split("\\s+");
            String soldierType = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            Soldier soldier = null;

            try {
                switch (soldierType){
                    case "Private":
                        double salary = Double.parseDouble(tokens[4]);
                        soldier = new PrivateImpl(id,firstName,lastName,salary);
                        break;
                    case "LeutenantGeneral":
                        salary = Double.parseDouble(tokens[4]);
                        soldier = new LeutenantGeneralImpl(id, firstName,lastName, salary,
                                Arrays.stream(tokens).skip(5)
                                        .map(x->(Private)army.get(Integer.parseInt(x)))
                                        .collect(Collectors.toCollection(ArrayList::new)) );
                        break;
                    case "Engineer":
                        salary = Double.parseDouble(tokens[4]);
                        String corps = tokens[5];

                        List<Repair> repairs = new ArrayList<>();
                        for (int i = 6; i < tokens.length; i+=2) {
                            Repair repair= new RepairImpl(tokens[i],
                                    Integer.parseInt(tokens[i+1]));
                            repairs.add(repair);
                        }
                        soldier = new EngineerImpl(id,firstName,lastName,salary,corps, repairs);
                        break;
                    case "Commando":
                        salary = Double.parseDouble(tokens[4]);
                        corps = tokens[5];

                        List<Mission> missions = new ArrayList<>();
                        for (int i = 6; i < tokens.length; i+=2) {
                            try {
                                Mission mission= new MissionImpl(tokens[i],
                                        tokens[i+1]);
                                missions.add(mission);
                            } catch (IllegalArgumentException e){
                                ;
                            }
                        }
                        soldier = new CommandoImpl(id,firstName,lastName,salary,corps, missions);
                        break;
                    case "Spy":
                        String codeNumber = tokens[4];
                        soldier = new SpyImpl(id,firstName,lastName, codeNumber);
                        break;
                }
            } catch (IllegalArgumentException e){
                ;
            }

            if (soldier!=null){
                army.put(soldier.getId(), soldier);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Soldier soldier:army.values()) {
            builder.append(soldier.toString()).append(System.lineSeparator());
        }
        System.out.println(builder.toString().trim());
    }
}
