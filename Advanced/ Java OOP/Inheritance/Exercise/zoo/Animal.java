package zoo;

class Animal {
    private String name;

    public Animal (String name){
        this.setName ( name );
    }

    private void setName ( String name ) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
