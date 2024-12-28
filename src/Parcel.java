class Parcel {
    private String id;
    private double weight;
    private String dimensions;
    private int daysInDepot;
    private boolean isCollected;

    public Parcel(String id, double weight, String dimensions, int daysInDepot) {
        this.id = id;
        this.weight = weight;
        this.dimensions = dimensions;
        this.daysInDepot = daysInDepot;
        this.isCollected = false;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public int getDaysInDepot() {
        return daysInDepot;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void markCollected() {
        this.isCollected = true;
    }

    public double calculateFee() {
        // Fee calculation: base + weight surcharge + day surcharge
        double baseFee = 10.0;
        double weightSurcharge = weight * 2.0;
        double daysSurcharge = daysInDepot * 1.0;
        return baseFee + weightSurcharge + daysSurcharge;
    }

    @Override
    public String toString() {
        return "Parcel ID: " + id + ", Weight: " + weight + ", Dimensions: " + dimensions +
                ", Days in Depot: " + daysInDepot + ", Collected: " + isCollected;
    }
}
