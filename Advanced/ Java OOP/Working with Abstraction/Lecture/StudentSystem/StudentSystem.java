package StudentSystem;

import java.util.HashMap;
import java.util.Map;

class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.setRepo ();
    }

    public void setRepo ( ) {
        this.repo = new HashMap<>();
    }

    public  Map<String, Student> getRepo() {
        return this.repo;
    }

    public void addStudent ( Student student){
        repo.putIfAbsent ( student.getName (),student );

    }
    public Student containsStudent ( String name){
        if (getRepo ().containsKey ( name )){
            return getRepo ().get ( name );
        }
        return null;
    }
    public String info (String name) {
        Student student = containsStudent ( name );
        if (student != null) {
            return String.format ( "%s is %d years old. %s.", student.getName ( ), student.getAge ( ), student.getCommentary ( ) );
        }
        return "";
    }
}
