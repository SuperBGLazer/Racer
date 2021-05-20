package xyz.lazertechbuilds.racer.models;


public enum TrackType {
    POINT_TO_POINT(new String[]{"pointtopoint", "p2p"}, "Point To Point"),
    TIME_TRIAL(new String[]{"timetrial", "tt"}, "Time Trial"),
    CIRCUIT(new String[]{"circuit", "c"}, "Circuit");

    private String[] names;
    private String displayName;

    TrackType(String[] names, String displayName) {
        this.names = names;
        this.displayName = displayName;
    }

    public String[] getNames() {
        return names;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static TrackType fromString(String type) {
        for (TrackType value : TrackType.values()) {
            for (String name :
                    value.names) {
                if (name.equalsIgnoreCase(type)) return value;
            }
        }
        throw new IllegalArgumentException();
    }

}
