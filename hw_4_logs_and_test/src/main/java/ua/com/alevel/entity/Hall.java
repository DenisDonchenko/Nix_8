package ua.com.alevel.entity;

public class Hall extends BaseEntity {

    private String nameHall;
    private int capacity;

    public Hall(String nameHall, int capacity) {
        this.nameHall = nameHall;
        this.capacity = capacity;
    }


    public String getNameHall() {
        return nameHall;
    }

    public void setNameHall(String nameHall) {
        this.nameHall = nameHall;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id='" + super.getId() + '\'' +
                ", nameHall='" + nameHall + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
