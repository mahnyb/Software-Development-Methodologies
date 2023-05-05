
// Mahny Barazandehtar - 20210702004 - Section 1 - CSE 212 - Assignment 6

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

// Room Types

class Single extends Room {
    public Single() {
        super("Single", 100, 15, false);
    }
}

class Double extends Room {
    public Double() {
        super("Double", 180, 30, false);
    }
}

class Club extends Room {
    public Club() {
        super("Club", 250, 45, true);
    }
}

class Family extends Room {
    public Family() {
        super("Family", 400, 50, false);
    }
}

class FamilyView extends Room {
    public FamilyView() {
        super("Family with View", 450, 50, true);
    }
}

class Suite extends Room {
    public Suite() {
        super("Suite", 650, 80, true);
    }
}
