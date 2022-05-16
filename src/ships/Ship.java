package ships;

public class Ship {
    private Size size;
    private Type type;
    private int count;

    public Ship(Size size, Type type) {
        this.size = size;
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public void add(int count){
        this.count += count;
    }

    public boolean countCheck(){
        return count < size.getValue();
    }

}
