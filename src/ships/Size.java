package ships;

public enum Size {
    SMALL(10), MEDIUM(50), LARGE(100);


    Size(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}
