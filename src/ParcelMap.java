import java.util.*;
class ParcelMap {
    private Map<String, Parcel> parcels;

    public ParcelMap() {
        parcels = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcels.put(parcel.getId(), parcel);
    }

    public Parcel getParcel(String id) {
        return parcels.get(id);
    }

    public void removeParcel(String id) {
        parcels.remove(id);
    }

    public Collection<Parcel> getAllParcels() {
        return parcels.values();
    }

    @Override
    public String toString() {
        return "Parcels: " + parcels.values();
    }
}