package controller;

import models.Car;
import models.Race;
import models.cars.PerformanceCar;
import models.cars.ShowCar;
import models.races.*;
import repository.Garage;
import repository.RaceCatalog;

import java.util.HashSet;

public class CarManager {

    private Garage garage;
    private RaceCatalog raceCatalog;

    public CarManager() {
        this.garage = new Garage();
        this.raceCatalog = new RaceCatalog();
    }

    public void register(int id, String type, String brand, String model,
                         int yearOfProduction, int horsepower, int acceleration,
                         int suspension, int durability) {

        if (this.garage.getAllCars().containsKey(id)){
            return;
        }
        Car car = null;
        switch (type) {
            case "Performance":
                car = new PerformanceCar(brand,model,yearOfProduction,
                        horsepower,acceleration,suspension,durability);
                break;
            case "Show":
                car = new ShowCar(brand,model,yearOfProduction,
                        horsepower,acceleration,suspension,durability);
                break;
        }
        if (car!=null){
            this.garage.getAllCars().put(id,car);
        }
    }

    public String check(int id) {
        if (!this.garage.getAllCars().containsKey(id)){
            return null;
        }
        return this.garage.getAllCars().get(id).toString();
    }

    public void open(int id, String type, int length, String route,
                     int prizePool) {
        if (this.raceCatalog.getRaces().containsKey(id)){
            return;
        }
        Race race = null;
        switch (type){
            case "Casual":
                race = new CasualRace(length,route,prizePool);
                break;
            case "Drag":
                race = new DragRace(length,route,prizePool);
                break;
            case "Drift":
                race = new DriftRace(length,route,prizePool);
                break;
        }
        if (race!=null){
            this.raceCatalog.getRaces().put(id,race);
        }
    }

    public void open(int id, String type, int length, String route,
                     int prizePool, int specialRaceParam) {
        if (this.raceCatalog.getRaces().containsKey(id)){
            return;
        }
        Race race = null;
        switch (type){
            case "TimeLimit":
                race=new TimeLimitRace(length,route,prizePool,specialRaceParam);
                break;
            case "Circuit":
                race=new CircuitRace(length,route,prizePool,specialRaceParam);
        }
        if (race!=null){
            this.raceCatalog.getRaces().put(id,race);
        }
    }

    public void participate(int carId, int raceId) {
        if (!this.garage.getAllCars().containsKey(carId) ||
                !this.raceCatalog.getRaces().containsKey(raceId)||
                this.garage.getParkedCars().containsKey(carId) ||
                (this.garage.getRaceCarsMarkers().containsKey(carId) &&
                this.garage.getRaceCarsMarkers().get(carId).contains(raceId)) ){
            return;
        }
        this.garage.getRaceCarsMarkers().putIfAbsent(carId,new HashSet<>());

        this.garage.getRaceCarsMarkers().get(carId).add(raceId);
        this.raceCatalog.getRaces().get(raceId).addParticipant(carId
                ,this.garage.getAllCars().get(carId));
    }

    public String start(int id) {
        if (!this.raceCatalog.getRaces().containsKey(id)){
            return null;
        }
        if (this.raceCatalog.getRaces().get(id).getParticipants().size()==0){
            return "Cannot start the race with zero participants.";
        }
        Race race = this.raceCatalog.getRaces().get(id);
        String raceResults = race.race();
        race.getParticipants().keySet().forEach(x->{
            this.garage.getRaceCarsMarkers().get(x).remove(id);
            if (this.garage.getRaceCarsMarkers().get(x).isEmpty()){
                this.garage.getRaceCarsMarkers().remove(x);
            }
        });
        this.raceCatalog.getRaces().remove(id);
        return raceResults;
    }

    public void park(int id) {
        if (this.garage.getRaceCarsMarkers().containsKey(id) ||
                this.garage.getParkedCars().containsKey(id)){
            return;
        }
        this.garage.getParkedCars().put(id,this.garage.getAllCars().get(id));
    }

    public void unpark(int id) {
        this.garage.getParkedCars().remove(id);
    }

    public void tune(int tuneIndex, String addOn) {
        this.garage.getParkedCars().values().forEach(x->x.tune(tuneIndex,addOn));
    }

}
