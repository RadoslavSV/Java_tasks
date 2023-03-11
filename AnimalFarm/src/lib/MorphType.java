package lib;

public enum MorphType {
    EARTH("Сухоземно"),
    WATER("Водно"),
    EARTH_WATER("Водно/Сухоземно");

    private String morphType;

    MorphType(String morphType) {
        this.morphType = morphType;
    }

    public String getMorphType() {
        return morphType;
    }
}
