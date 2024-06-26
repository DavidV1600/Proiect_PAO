package Proiect_PAO.Stadiums;

public class Stadium {
    private String name;
    private String location;
    private int capacity;

    public Stadium(String name, String location, int capacity) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }
    @Override
    public String toString() {
        return "Stadium name: " + name +
                "\nLocation: " + location +
                "\nCapacity" + capacity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

