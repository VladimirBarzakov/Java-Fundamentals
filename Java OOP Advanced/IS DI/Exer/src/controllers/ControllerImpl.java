package controllers;

import contracts.Boat;
import contracts.BoatEngine;
import contracts.Race;
import database.BoatSimulatorDatabase;
import exeptions.*;
import models.BoatRace;
import models.boats.PowerBoat;
import models.boats.RowBoat;
import models.boats.SailBoat;
import models.boats.Yacht;
import models.engines.JetEngine;
import models.engines.SterndriveEngine;
import utility.Constants;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ControllerImpl implements contracts.Controller {
    private BoatSimulatorDatabase database;
    private Race currentRace;

    public ControllerImpl(BoatSimulatorDatabase database) {
        this.database=database;
        this.currentRace=null;
    }

    @Override
    public String createBoatEngine(String model,
                                   int horsepower,
                                   int displacement,
                                   String engineType) throws DuplicateModelException {
        BoatEngine engine;
        try {
            switch (engineType) {
                case "Jet":
                    engine = new JetEngine(model, horsepower, displacement);
                    break;
                case "Sterndrive":
                    engine = new SterndriveEngine(model, horsepower, displacement);
                    break;
                default:
                    throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE);
            }
            this.database.getEngines().add(engine);
            return String.format(
                    "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                    model,
                    horsepower,
                    displacement);
        } catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
            Boat boat = new RowBoat(model,weight,oars);
            this.database.getBoats().add(boat);
            return String.format("Row boat with model %s registered successfully.", model);
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
            Boat boat = new SailBoat(model,weight,sailEfficiency);
            this.database.getBoats().add(boat);
            return String.format("Sail boat with model %s registered successfully.", model);
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel)
            throws DuplicateModelException, NonExistentModelException {
            BoatEngine engineA = this.database.getEngines().getItem(firstEngineModel);
            BoatEngine engineB = this.database.getEngines().getItem(secondEngineModel);
            Boat boat = new PowerBoat(model,weight,engineA,engineB);
            this.database.getBoats().add(boat);
            return String.format("Power boat with model %s registered successfully.", model);
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargoWeight)
            throws NonExistentModelException, DuplicateModelException {
            BoatEngine engine = this.database.getEngines().getItem(engineModel);
            Boat boat = new Yacht(model,weight,engine,cargoWeight);
            this.database.getBoats().add(boat);
            return String.format("Yacht with model %s registered successfully.", model);
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats)
            throws RaceAlreadyExistsException {
        Race race = new BoatRace(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.validateRaceIsEmpty();
        this.currentRace = race;
        return String.format("A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    @Override
    public String signUpBoat(String model)
            throws NonExistentModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = this.database.getBoats().getItem(model);
        this.validateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats()&&boat.isMotorBoat()){
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }
        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    @Override
    public String startRace()
            throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();
        List<Boat> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(
                    Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }
        List<Boat> winners = this.findFastest(participants);

        String[] strPlaces = {"First", "Second", "Third"};
        int counter=0;
        StringBuilder result = new StringBuilder();
        for (Boat boat : winners) {
            result.append(
                    String.format("%s place: %s Model: %s Time: %s",
                    strPlaces[counter++],
                    boat.getClass().getSimpleName(),
                    boat.getModel(),
                    isFinished(boat.calculateRaceSpeed(this.currentRace)))
            )
                    .append(System.lineSeparator());
        }

        this.currentRace = null;

        return result.toString().trim();
    }

    @Override
    public String getStatistic() throws NoSetRaceException {
        this.validateRaceIsSet();
        Map<String, Integer> countOfBoats = new TreeMap<>();
        for (Boat boat:this.currentRace.getParticipants()) {
            String boatClassName = boat.getClass().getSimpleName();
            countOfBoats.putIfAbsent(boatClassName, 0);
            countOfBoats.put(boatClassName, countOfBoats.get(boatClassName)+1);
        }
        StringBuilder builder = new StringBuilder();
        Double totalCount = (double) this.currentRace.getParticipants().size();
        for (Map.Entry<String, Integer> entry:countOfBoats.entrySet()) {
            builder.append(String.format("%s -> %.2f%%",entry.getKey(), (entry.getValue()/totalCount)*100d)).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

    private String isFinished(Double speed) {
        double time = this.currentRace.getDistance()/speed;
        if (time <= 0d || time == Double.POSITIVE_INFINITY || time == Double.NEGATIVE_INFINITY) {
            return "Did not finish!";
        }
        return String.format("%.2f sec", time);
    }

    private List<Boat> findFastest(List<Boat> participants) {
        return participants
                .stream()
                .sorted((boatA, boatB)->
                        Double.compare(boatB.calculateRaceSpeed(this.currentRace),boatA.calculateRaceSpeed(this.currentRace)))
                .limit(3)
                .collect(Collectors.toList());
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }
}
