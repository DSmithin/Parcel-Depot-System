class Worker {
    private ParcelMap parcelMap;
    private Log log;

    public Worker(ParcelMap parcelMap) {
        this.parcelMap = parcelMap;
        this.log = Log.getInstance();
    }

    public void processCustomer(Customer customer) {
        Parcel parcel = parcelMap.getParcel(customer.getParcelId());
        if (parcel != null && !parcel.isCollected()) {
            double fee = parcel.calculateFee();
            parcel.markCollected();
            log.logEvent("Processed parcel for customer: " + customer.getName() + ", Fee: $" + fee);
        } else {
            log.logEvent("Parcel not found or already collected for customer: " + customer.getName());
        }
    }
}