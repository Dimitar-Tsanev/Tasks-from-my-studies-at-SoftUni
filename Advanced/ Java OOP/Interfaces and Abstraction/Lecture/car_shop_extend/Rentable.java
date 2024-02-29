package car_shop_extend;

interface Rentable extends Car{
    Integer getMinRentDay();
    Double getPricePerDay();

}
