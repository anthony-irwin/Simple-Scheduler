package src.model;

import java.util.ArrayList;
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
     * @param name           The name of a person
     * @param location       The location of a person
     * @param availableHours The
     * @return A Person object
     */
    public Person(String name, Location location, Map<Day, List<TimeSlot>> availability) {

        this.name = name;
        this.location = location;
        this.availability = availability;

    }

    /**
     * Removes the time of the person based on that time slot
     * REQUIRES: has the time slot to begin with
     * 
     * @param workshopTimeSlot The TimeSlot of the workshop the person is being
     *                         assigned to
     * @param day              The day the workshop is happening on
     */
    public void removeTimeSlot(TimeSlot workshopSlot, Day day) {
        
        List<TimeSlot> times = availability.get(day);
        if (times == null)
            return;

        List<TimeSlot> updated = new ArrayList<>();

        for (TimeSlot slot : times) {

            // Case 1: no overlap → keep as-is
            if (!slot.overlaps(workshopSlot)) {
                updated.add(slot);
                continue;
            }

            // Case 2–5: overlap exists → compute remaining pieces

            // Left piece
            if (slot.getStart() < workshopSlot.getStart()) {
                updated.add(new TimeSlot(
                        slot.getStart(),
                        Math.min(slot.getEnd(), workshopSlot.getStart())));
            }

            // Right piece
            if (slot.getEnd() > workshopSlot.getEnd()) {
                updated.add(new TimeSlot(
                        Math.max(slot.getStart(), workshopSlot.getEnd()),
                        slot.getEnd()));
            }
        }

        availability.put(day, updated);
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
