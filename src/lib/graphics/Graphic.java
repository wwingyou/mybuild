package graphics;

public abstract class Graphic {
    protected int x;
    protected int y;
    protected int size;

    public Graphic() {
        this.x = 0;
        this.y = 0;
        this.size = 1;
    }
    
    public Graphic(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Graphic(int x, int y, int size) {
        this(x, y);
        this.size = size;
    }

    public void Draw() {
        throw new UnsupportedOperationException();
    }
}

