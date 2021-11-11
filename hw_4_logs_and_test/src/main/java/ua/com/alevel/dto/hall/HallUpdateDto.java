package ua.com.alevel.dto.hall;

public class HallUpdateDto {
    private Long id;
    private String nameHall;
    private int capacity;

    public HallUpdateDto(Long id, String nameHall, int capacity) {
        this.id = id;
        this.nameHall = nameHall;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
