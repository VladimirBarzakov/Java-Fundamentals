package model;

import java.util.*;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families=new TreeMap<>();
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }


    public List<Colonist> getColonistsByFamilyId(String familyId){
        if (this.families.containsKey(familyId)){
            return Collections.unmodifiableList(
                    new ArrayList<>(this.families.get(familyId).getMembers().values()));
        }
        return null;
    }
    public void addColonist(Colonist colonist){
        if (!this.families.containsKey(colonist.getFamilyId())){
            if (this.families.size()<this.maxFamilyCount){
                if (this.maxFamilyCapacity>0){
                    this.families.put(colonist.getFamilyId(),new Family(colonist.getFamilyId()));
                }
            } else {
                throw new IllegalArgumentException("colony is full");
            }
        }
        if (this.families.get(colonist.getFamilyId()).getMembers().size()<this.maxFamilyCapacity){
            this.families.get(colonist.getFamilyId()).getMembers().put(colonist.getId(),colonist);
        } else {
            throw new IllegalArgumentException("family is full");
        }

    }
    public void removeColonist(String familyId, String memberId){
        if (this.families.containsKey(familyId)){
            this.families.get(familyId).getMembers().remove(memberId);
            if (this.families.get(familyId).getMembers().size()==0){
                this.removeFamily(familyId);
            }
        }
    }
    public void removeFamily(String id){
        this.families.remove(id);
    }

    public void grow(int years){
        for (Family family:families.values()) {
            family.getMembers().values().forEach(x->x.grow(years));
        }
    }

    public int getPotential(){
        int potentialSum=0;
        for (Family family:families.values()) {
            potentialSum+=family.getMembers().values().stream().mapToInt(Colonist::getPotential).sum();
        }
        return potentialSum;
    }

    public String getCapacity(){
        Set<String> familiesNames = this.families.keySet();
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("families: %d/%d",familiesNames.size(),this.maxFamilyCount));
        for (String familyName:familiesNames) {
            builder.append(System.lineSeparator()).append(
                    String.format("-%s: %d/%d",familyName,this.families.get(familyName).getMembers().size()
                            ,this.maxFamilyCapacity));
        }
        return builder.toString();
    }


}
