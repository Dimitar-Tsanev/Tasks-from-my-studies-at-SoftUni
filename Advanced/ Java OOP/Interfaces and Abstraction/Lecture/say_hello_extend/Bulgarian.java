package say_hello_extend;

class Bulgarian extends BasePerson {
    public Bulgarian ( String name ) {
        super ( name );
    }
    @Override
    public String sayHello () {
        return "Здравей";
    }
}
