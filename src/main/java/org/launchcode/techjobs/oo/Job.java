package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;


    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency){
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String toString(){
        String formatedString;

        //check at least one field has valid data
        if (this.getName() == "Data not available" && this.getEmployer().getValue() == "Data not available" && this.getLocation().getValue() == "Data not available" && this.getPositionType().getValue() == "Data not available" && this.getCoreCompetency().getValue() == "Data not available"){
            return "OOPS! This job does not seem to exist.";
        }

        formatedString =

                System.lineSeparator() +

                "ID: " + this.getId()+ System.lineSeparator() +
                "Name: " + this.getName() + System.lineSeparator() +
                "Employer: " + this.getEmployer().getValue() + System.lineSeparator() +
                "Location: " + this.getLocation().getValue() + System.lineSeparator() +
                "Position Type: " + this.getPositionType().getValue() + System.lineSeparator() +
                "Core Competency: " + this.getCoreCompetency().getValue() +

                System.lineSeparator();

        return formatedString;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        if (name.isEmpty()){
            return "Data not available";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
