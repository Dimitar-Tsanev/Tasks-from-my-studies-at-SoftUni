package hotel_reservation;

class PriceCalculator {
    private double pricePerDay;
    private int days;
    private int seasonMultiplier;
    private double discount;

    public PriceCalculator ( double pricePerDay, int days, String season, String discountType ) {
        this.setPricePerDay ( pricePerDay );
        this.setDays ( days );
        this.setSeason ( season );
        this.setDiscountType ( discountType );
    }
    private void setPricePerDay ( double pricePerDay ) {
        this.pricePerDay = pricePerDay;
    }
    private void setDays ( int days ) {
        this.days = days;
    }
    private void setSeason ( String season ) {
        this.seasonMultiplier = Season.valueOf ( season.toUpperCase () ).getMultiplier ();
    }
    private void setDiscountType ( String discountType ) {
        switch (discountType){
            case "VIP":
                this.discount = Discount.VIP.getDiscount ();
                break;
            case "SecondVisit":
                this.discount = Discount.SECOND_VISIT.getDiscount ( );
                break;
            case "None":
                this.discount = Discount.NONE.getDiscount ( );
                break;
        }
    }

    private double getPricePerDay () {
        return pricePerDay;
    }

    private int getDays () {
        return days;
    }

    private int getSeasonMultiplier () {
        return seasonMultiplier;
    }

    private double getDiscount () {
        return discount;
    }
    public double getPrice (){
        double regularPrice = (getPricePerDay () * getSeasonMultiplier ()) * getDays ();

        return regularPrice - regularPrice * getDiscount ();
    }
}
