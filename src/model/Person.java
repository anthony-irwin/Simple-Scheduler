package src.model;

import java.util.List;
import java.util.Map;

// represents a person, which has a name, location, availability, role, year, program, email, phone number, instagram handle, and whether they were a member before
public class Person {

    private String name;
    private Location location;
    private Map<Day, List<TimeSlot>> availability;
    
    /**
     * Represents a Person object.
     * 
     * @param name The name of a person
     * @param location The location of a person
     * @param availableHours The 
     * @return A Person object
     */
    public Person(String name, Location location, Map<Day, List<TimeSlot>> availability) {

        this.name = name;
        this.location = location;
        this.availability = availability;

    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Location getLocation() {
        return location;
    }


    public void setLocation(Location location) {
        this.location = location;
    }


    public Map<Day, List<TimeSlot>> getAvailability() {
        return availability;
    }


    public void setAvailability(Map<Day, List<TimeSlot>> availability) {
        this.availability = availability;
    }

    
}
