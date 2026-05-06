package src.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import src.model.Workshop;
import src.model.Person;

// represents the scheduler that schedules people to workshops
//
// scheduling rules:
// - Workshops have at least WORKSHOP_MIN attendees
// - Workshops have a capacity limit of WORKSHOP_MAX attendees
// - Each person must attend at least PERSON_MIN workshops
// - Each person cannot attend more than PESRON_MAX workshops
public class Scheduler {

    // constants
    private static final int WORKSHOP_MIN = 3;
    public static final int WORKSHOP_MAX = 5;
    private static final int PERSON_MIN = 2;
    private static final int PERSON_MAX = 4;

    // fields
    private DistanceUtil distanceUtil;
    private TimeSlot timeSlot;

    // TODO: remember to make it so that the time taken to schedule something is
    // then removed if used in a schedule

    public Scheduler() {

        distanceUtil = new DistanceUtil();
        // timeSlot = new TimeSlot();

    }

    // generate a map that contains workshops as keys and people as values
    public void schedule(Set<Person> personSet, Set<Workshop> workshopSet) {

        // create the initial map and populate it with people who fit the location and time frame
        Map<Workshop, Set<Person>> initialMap = new HashMap<>();

        for (Workshop workshop : workshopSet) {

            // create an empty set for the possible people to be attending the workshop
            Set<Person> possibleSet = new HashSet();
            
            for (Person person : personSet) {
                if (person.getAvailability().containsKey(workshop.getDay())) {
                    
                    // get the available time slots a person has for the day the workshop is being hosted on
                    List<TimeSlot> applicableTimeSlots = new ArrayList<>();
                    applicableTimeSlots = person.getAvailability().get(workshop.getDay());

                    // check if a timeslot overlaps
                    for (TimeSlot timeSlot : applicableTimeSlots) {
                        if (timeSlot.overlaps(workshop.getTime())) {

                            // if it does overlap, add them to the set of possible people attending the workshop
                            if (workshop.assignPerson(person)) {
                                possibleSet.add(person);
                            }
                        }
                    }
                }
            }

            // put the workshop and set of people participating into the map
            initialMap.put(workshop, possibleSet);
        }

        // check to see what the total distance is
        int totalDistanceInitial = 0;
        for (Workshop workshopKey : initialMap.keySet()) {
            for (Person personValue : initialMap.get(workshopKey)) {
                totalDistanceInitial += DistanceUtil.getDistance(personValue.getLocation(), workshopKey.getLocation());
            }
        }
    }
}
