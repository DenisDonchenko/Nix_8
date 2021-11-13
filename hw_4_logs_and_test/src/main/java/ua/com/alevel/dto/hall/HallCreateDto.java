package ua.com.alevel.dto.hall;

public class HallCreateDto {

    private String nameHall;
    private int capacity;

    public HallCreateDto(String nameHall, int capacity) {
        this.nameHall = nameHall;
        this.capacity = capacity;
    }

    public HallCreateDto() {
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
}
