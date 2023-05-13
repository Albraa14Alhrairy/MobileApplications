package DatabaseHandler;

public class Tasks {

    private String name, desc, start, end;
    private int id;

    public Tasks(String name, String desc, String start, String end, int id) {
        this.name = name;
        this.desc = desc;
        this.start = start;
        this.end = end;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getId() {
        return id;
    }
}

