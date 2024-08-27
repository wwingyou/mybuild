package graphics;

public class Circle extends Graphic implements Draggable {

    @Override
    public int[] drag(int dx, int dy) {
        return new int[]{ this.x + dx, this.y + dy };
    }
}

