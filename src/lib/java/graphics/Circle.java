package graphics;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Circle extends Graphic implements Draggable {

    private final ObjectMapper mapper = new ObjectMapper();
    private int r;

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    @Override
    public int[] drag(int dx, int dy) {
        return new int[]{ this.x + dx, this.y + dy };
    }

    @Override
    public String toString() {
        return mapper.writeValueAsString(this);
    }
}

