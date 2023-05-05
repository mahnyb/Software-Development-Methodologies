
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 3

public class Room {
	private String type;
    private int dailyCost;
    private int roomSize;
    private boolean hasBath;
    
    public Room(String type, int dailyCost, int roomSize, boolean hasBath) {
        this.type = type;
        this.dailyCost = dailyCost;
        this.roomSize = roomSize;
        this.hasBath = hasBath;
    }
    
    public String getType() {
        return type;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public boolean gethasBath() {
        return hasBath;
    }

    public void setCost(int dailyCost) {
        this.dailyCost = dailyCost;
    }

    public int getCost() {
        return dailyCost;
    }
    
}
