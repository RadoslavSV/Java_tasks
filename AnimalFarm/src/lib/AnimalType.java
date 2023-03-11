package lib;

public enum AnimalType {
    BOZAINIK("Бозайник"),
    PTICA("Птица"),
    BEZGRABNACHNO("Безгръбначно"),
    VLECHUGO ("Влечуго"),
    RIBA("Риба");

    private String typeName;

    AnimalType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        String type = "";
        if(typeName.equals("Бозайник")) type = "BOZAINIK";
        if(typeName.equals("Птица")) type = "PTICA";
        if(typeName.equals("Безгръбначно")) type = "BEZGRABNACHNO";
        if(typeName.equals("Влечуго")) type = "VLECHUGO";
        if(typeName.equals("Риба")) type = "RIBA";

        return String.format("%s:%s", type, typeName);
    }
}
