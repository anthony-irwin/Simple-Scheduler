package src.model;

import java.util.ArrayList;
import java.util.List;

// represents a workshop, which has a teacher, school, day, time, date, and list of people attending
public class Workshop {
    
    private String teacher;
    private String school;
    private Day day;
    private TimeSlot time;
    private int date;
    private List<Person> people;
    private int capacity;
    private Location location;
    // TODO: add in combo class functionality

    /**
     * Represents a Workshop object.
     * 
     * @param teacher The name of the teacher
     * @param school The name of the school
     * @param day The day of the week the workshop is being hosted
     * @param time The times of day the workshop is starting and ending (in the form of [START_TIME, END_TIME])
     * @param date The day of the month the workshop is being hosted
     * @return a Workshop object
     */
    public Workshop(String teacher, String school, Day day, TimeSlot time, int date, Location location) {

        this.teacher = teacher;
        this.school = school;
        this.day = day;
        this.time = time;
        this.date = date;
        people = new ArrayList<>();
        this.capacity = Scheduler.WORKSHOP_MAX;
        this.location = location;

    }

    /**
     * Assigns a Person object to the workshop's list of people attending. Removes the time slot from their availability.
     * 
     * @param person The Person object
     * @return true if the person is assigned successfully, and false otherwise
     */
    public boolean assignPerson(Person person) {

        if (people.size() >= capacity || !canAttend(person) || people.contains(person)) { return false; }

        people.add(person);
        person.removeTimeSlot(time, day);
        return true;

    }

    /**
     * Determines if a person can attend the workshop or not based on time availability.
     * 
     * @param person The Person object
     * @return true if the person can attend, and false otherwise
     */
    private boolean canAttend(Person person) {

        List<TimeSlot> timeSlots = person.getAvailability().get(day);

        if (timeSlots == null) { return false; }

        for (TimeSlot slot : timeSlots) {
            if (slot.overlaps(this.time)) { return true; }
        }
        return false;
    }

    /**
     * Removes everyone in the current list of attendees.
     */
    public void resetAttendees() {

        people = new ArrayList<>();

    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public TimeSlot getTime() {
        return time;
    }

    public void setTime(TimeSlot time) {
        this.time = time;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
