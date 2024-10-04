package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    private int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    // Custom toString, equals, and hashCode methods:


    public String toString() {
        return value;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        JobField jobField = (JobField) o;
        return getId() == jobField.getId();
    }


    public int hashCode() {
        return Objects.hash(id);
    }

    public String getValue() {
        if (value.isEmpty()){
            return "Data not available";
        }
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }


}
