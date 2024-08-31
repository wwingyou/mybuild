package graphics;

public class Rectangle extends Graphic implements Draggable {

    @Override
    public int[] drag(int dx, int dy) {
        return new int[]{ this.x + dx, this.y + dy };
    }

}

