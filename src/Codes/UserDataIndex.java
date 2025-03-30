package Codes;

public enum UserDataIndex {
    USER_NAME(0),
    DATE(1),
    WAKE_TIME(2),
    SLEEP_TIME(3),
    WATER_GOAL(4),
    CURRENT_TAKE(5),
    LAST_WATER_TAKEN(6),
    FEEDBACK(1);

    private final int index;

    UserDataIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}

