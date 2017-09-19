package se.rosa.fishi.model;

public class Fish {

    private final String id;

    private final FishType fishType;

    private final String length;

    private final String weight;

    public Fish(String id ,FishType fishType, double length, double weight){
        this.id = id;
        this.fishType = fishType;
        this.length = length + "cm";
        this.weight = weight + "kg";
    }

    public enum FishType {
        PERCH, PIKE
    }

    public FishType getFishType() {
        return fishType;
    }

    public String getLength() {
        return length;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fishType=" + fishType +
                ", length='" + length + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
