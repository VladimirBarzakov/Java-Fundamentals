package p10to14Inferno.controller;

import p10to14Inferno.annotations.CustomAnnotation;
import p10to14Inferno.factories.GemFactory;
import p10to14Inferno.factories.WeaponFactory;
import p10to14Inferno.models.Weapon;
import p10to14Inferno.models.types.GemType;
import p10to14Inferno.repositories.WeaponRepository;

import java.util.Arrays;

public class Controller {
    private WeaponRepository weaponRepository;
    private WeaponFactory weaponFactory;
    private GemFactory gemFactory;

    public Controller(WeaponRepository weaponRepository,
                      WeaponFactory weaponFactory,
                      GemFactory gemFactory) {
        this.weaponRepository = weaponRepository;
        this.weaponFactory = weaponFactory;
        this.gemFactory = gemFactory;
    }

    public String executeCommand(String args){
        String[] tokens = args.split(";");
        String command = tokens[0];
        String weaponName;
        String result = null;
        CustomAnnotation annotation = Weapon.class.getAnnotation(CustomAnnotation.class);
        switch (command){
            case "Create":
                String weaponTypeStr = tokens[1];
                weaponName= tokens[2];
                Weapon weapon = this.weaponFactory.createWeapon(weaponName,weaponTypeStr);
                this.weaponRepository.addWeapon(weapon);
                break;
            case "Add":
                weaponName= tokens[1];
                int index = Integer.parseInt(tokens[2]);
                String gemTypeStr = tokens[3];
                GemType gem = this.gemFactory.createGem(gemTypeStr);
                this.weaponRepository.addGem(weaponName,index,gem);
                break;
            case "Remove":
                weaponName= tokens[1];
                index = Integer.parseInt(tokens[2]);
                this.weaponRepository.removeGem(weaponName,index);
                break;
            case "Print":
                weaponName= tokens[1];
                result=this.weaponRepository.print(weaponName);
                break;
            case "Compare":
                weaponName= tokens[1];
                String otherWeaponName = tokens[2];
                result=this.weaponRepository.getBestWeaponOfTwo(weaponName,otherWeaponName);
                break;
            case "Author":
                result=String.format("Author: %s", annotation.author());
                break;
            case "Revision":
                result=String.format("Revision: %d",annotation.revision());
                break;
            case "Description":
                result=String.format("Class description: %s",annotation.description());
                break;
            case "Reviewers":
                result=String.format("Reviewers: %s",
                        Arrays.toString(annotation.reviewers()).replaceAll("[\\[\\]\"]",""));
                break;
        }
        return result;
    }
}
