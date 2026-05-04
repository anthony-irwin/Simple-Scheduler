package src.model;

// represents the scheduler that schedules people to workshops
//
// scheduling rules:
// - Workshops have at least WORKSHOP_MIN attendees
// - Workshops have a capacity limit of WORKSHOP_MAX attendees
// - Each person must attend at least PERSON_MIN workshops
// - Each person cannot attend more than PESRON_MAX workshops
public class Scheduler {

    private static final int WORKSHOP_MIN = 3;
    public static final int WORKSHOP_MAX = 5;
    private static final int PERSON_MIN = 2;
    private static final int PERSON_MAX = 4;

    // TODO: remember to make it so that the time taken to schedule something is then removed if used in a schedule
}
