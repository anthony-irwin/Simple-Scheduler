package src.model;

// represents a utility class for determining the distance between two locations
public class DistanceUtil {

    /**
     * Determines the distance between two locations.
     * 
     * @param a Location 1
     * @param b Location 2
     * @return The distance between them
     */
    public static int getDistance(Location a, Location b) {
        
        // case where they are the same location
        if (a == b) return 0;

        // case where a is Richmond
        if (a == Location.RICHMOND && b == Location.VANCOUVER) { return 1; }
        if (a == Location.RICHMOND && b == Location.SURREY) { return 2; }
        if (a == Location.RICHMOND && b == Location.NORTH_VANCOUVER) { return 3; }
        if (a == Location.RICHMOND && b == Location.WEST_VANCOUVER) { return 4; }
        if (a == Location.RICHMOND && b == Location.BURNABY) { return 3; }
        if (a == Location.RICHMOND && b == Location.UBC) { return 2; }

        // case where a is Vancouver
        if (a == Location.VANCOUVER && b == Location.RICHMOND) { return 1; }
        if (a == Location.VANCOUVER && b == Location.SURREY) { return 3; }
        if (a == Location.VANCOUVER && b == Location.NORTH_VANCOUVER) { return 2; }
        if (a == Location.VANCOUVER && b == Location.WEST_VANCOUVER) { return 2; }
        if (a == Location.VANCOUVER && b == Location.BURNABY) { return 1; }
        if (a == Location.VANCOUVER && b == Location.UBC) { return 1; }

        // case where a is Surrey
        if (a == Location.SURREY && b == Location.RICHMOND) { return 1; }
        if (a == Location.SURREY && b == Location.VANCOUVER) { return 3; }
        if (a == Location.SURREY && b == Location.NORTH_VANCOUVER) { return 5; }
        if (a == Location.SURREY && b == Location.WEST_VANCOUVER) { return 6; }
        if (a == Location.SURREY && b == Location.BURNABY) { return 2; }
        if (a == Location.SURREY && b == Location.UBC) { return 4; }

        // case where a is North Vancouver
        if (a == Location.NORTH_VANCOUVER && b == Location.RICHMOND) { return 3; }
        if (a == Location.NORTH_VANCOUVER && b == Location.VANCOUVER) { return 2; }
        if (a == Location.NORTH_VANCOUVER && b == Location.SURREY) { return 5; }
        if (a == Location.NORTH_VANCOUVER && b == Location.WEST_VANCOUVER) { return 1; }
        if (a == Location.NORTH_VANCOUVER && b == Location.BURNABY) { return 3; }
        if (a == Location.NORTH_VANCOUVER && b == Location.UBC) { return 2; }

        // case where a is West Vancouver
        if (a == Location.WEST_VANCOUVER && b == Location.RICHMOND) { return 4; }
        if (a == Location.WEST_VANCOUVER && b == Location.VANCOUVER) { return 2; }
        if (a == Location.WEST_VANCOUVER && b == Location.SURREY) { return 6; }
        if (a == Location.WEST_VANCOUVER && b == Location.NORTH_VANCOUVER) { return 1; }
        if (a == Location.WEST_VANCOUVER && b == Location.BURNABY) { return 5; }
        if (a == Location.WEST_VANCOUVER && b == Location.UBC) { return 3; }

        // case where a is Burnaby
        if (a == Location.BURNABY && b == Location.RICHMOND) { return 3; }
        if (a == Location.BURNABY && b == Location.VANCOUVER) { return 1; }
        if (a == Location.BURNABY && b == Location.SURREY) { return 2; }
        if (a == Location.BURNABY && b == Location.NORTH_VANCOUVER) { return 3; }
        if (a == Location.BURNABY && b == Location.WEST_VANCOUVER) { return 5; }
        if (a == Location.BURNABY && b == Location.UBC) { return 3; }

        // case where a is UBC
        if (a == Location.UBC && b == Location.RICHMOND) { return 1; }
        if (a == Location.UBC && b == Location.VANCOUVER) { return 1; }
        if (a == Location.UBC && b == Location.SURREY) { return 4; }
        if (a == Location.UBC && b == Location.NORTH_VANCOUVER) { return 2; }
        if (a == Location.UBC && b == Location.WEST_VANCOUVER) { return 3; }
        if (a == Location.UBC && b == Location.BURNABY) { return 3; }
        return 0;
    }
}
