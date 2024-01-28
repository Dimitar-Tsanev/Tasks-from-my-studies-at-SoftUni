package RawData;

 class Tier {
     private int age;
     private double pressure;

     public Tier ( double pressure, int age ) {
         this.pressure = pressure;
         this.age = age;
     }

     public double getPressure () {
         return this.pressure;
     }
 }
