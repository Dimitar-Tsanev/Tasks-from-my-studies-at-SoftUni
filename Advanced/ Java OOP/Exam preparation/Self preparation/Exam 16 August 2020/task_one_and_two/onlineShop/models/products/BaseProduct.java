package onlineShop.models.products;


import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;

public abstract class BaseProduct implements Product{
    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;

    public BaseProduct ( int id, String manufacturer, String model, double price, double overallPerformance ) {
        this.setId ( id );
        this.setManufacturer ( manufacturer );
        this.setModel ( model );
        this.setPrice ( price );
        this.setOverallPerformance ( overallPerformance );
    }

    private void setId ( int id ) {
        if (isNumberLessOrEqualZero ( id ) ){
            throw new IllegalArgumentException ( ExceptionMessages.INVALID_PRODUCT_ID );
        }
        this.id = id;
    }

    private void setManufacturer ( String manufacturer ) {
        if ( isStringNullOrEmpty ( manufacturer )){
            throw new IllegalArgumentException ( ExceptionMessages.INVALID_MANUFACTURER );
        }
        this.manufacturer = manufacturer;
    }

    private void setModel ( String model ) {
        if(isStringNullOrEmpty ( model )){
            throw new IllegalArgumentException ( ExceptionMessages.INVALID_MODEL );
        }
        this.model = model;
    }

    private void setPrice ( double price ) {
        if (isNumberLessOrEqualZero ( price )){
            throw new IllegalArgumentException ( ExceptionMessages.INVALID_PRICE );
        }
        this.price = price;
    }

    private void setOverallPerformance ( double overallPerformance ) {
        if(isNumberLessOrEqualZero ( overallPerformance )){
            throw new IllegalArgumentException ( ExceptionMessages.INVALID_OVERALL_PERFORMANCE );
        }
        this.overallPerformance = overallPerformance;
    }

    @Override
    public int getId () {
        return this.id;
    }

    @Override
    public String getManufacturer () {
        return this.manufacturer;
    }

    @Override
    public String getModel () {
        return this.model;
    }

    @Override
    public double getPrice () {
        return this.price;
    }

    @Override
    public double getOverallPerformance () {
        return this.overallPerformance;
    }

    @Override
    public String toString () {
        return String.format ( OutputMessages.PRODUCT_TO_STRING,
                this.getOverallPerformance (),
                this.getPrice (),
                this.getClass ().getSimpleName (),
                this.getManufacturer (),
                this.getModel (),
                this.getId () );
    }

    private static boolean isStringNullOrEmpty( String string){
         return null == string || string.trim ().isEmpty ();
    }
    private static boolean isNumberLessOrEqualZero(double number ){
        return number <= 0.00;

    }
}
