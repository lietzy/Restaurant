public class Manager {
    private String name;
    private String id;
    private int accessLevel;

    //constructor
    public Manager(String name1, String id1, int level){
        name = name1;
        id = id1;
        accessLevel = level;
    }

    public String getName() {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public int getAccessLevel(){
        return accessLevel;
    }


}

