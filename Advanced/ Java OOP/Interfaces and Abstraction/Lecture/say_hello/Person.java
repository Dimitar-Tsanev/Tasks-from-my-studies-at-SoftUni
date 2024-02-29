package say_hello;

interface Person {
    String getName();
    default String sayHello(){return "Hello";}
}
