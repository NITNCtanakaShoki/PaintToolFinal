package model.draw.position;

import java.awt.event.MouseEvent;
import java.util.Objects;

public class DrawPosition {
    private final int x;
    private final int y;

    public DrawPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static DrawPosition NOTHING = new DrawPosition(-1, -1);

    public boolean isNothing() {
        return equals(NOTHING);
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public static DrawPosition make(MouseEvent e) {
        return new DrawPosition(e.getX(), e.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrawPosition that = (DrawPosition) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
