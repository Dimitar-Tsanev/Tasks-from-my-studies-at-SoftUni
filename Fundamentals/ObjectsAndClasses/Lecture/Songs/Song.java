package Songs;

public class Song {
    private  String typeList;
    private String name;
    private String duration;

    public Song (String typeList, String name, String duration){
        this.typeList = typeList;
        this.name = name;
        this.duration = duration;
    }
    public String getTypeList (){
        return typeList;
    }
    public String getName (){
        return name;
    }
}
