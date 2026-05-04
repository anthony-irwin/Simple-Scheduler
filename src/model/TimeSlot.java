package src.model;

// represents a timeslot with start time and end time
public class TimeSlot {

    private int start;
    private int end;

    /**
     * Represents a TimeSlot object.
     * 
     * @param start The start time
     * @param end The end time
     * @return A TimeSlot object
     */
    public TimeSlot(int start, int end) {

        this.start = start;
        this.end = end;

    }

    /**
     * Determines whether two timeslots overlap.
     * 
     * @param other The other TimeSlot
     * @return true if they overlap, false otherwise
     */
    public boolean overlaps(TimeSlot other) {

        return this.start < other.getEnd() && other.getStart() < this.end;

    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

}
