package GoogleTask7;

class Parent {
    private String parentName;
    private String parentBirthday;

        public Parent ( String parentName, String parentBirthday ) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }
        @Override
        public String toString () {
            return String.format ( "%s %s%n", this.parentName,this.parentBirthday);
        }

}
