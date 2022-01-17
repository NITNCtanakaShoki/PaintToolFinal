package model.draw.taste;

import model.draw.position.DrawPosition;

import java.awt.*;

public class DrawTaste implements Drawable {

    private final Component component;
    private final Colorable colorable;

    public DrawTaste(Component component, Colorable colorable) {
        this.component = component;
        this.colorable = colorable;
    }

    public Graphics graphics() {
        final var graphics = component.getGraphics();
        graphics.setColor(colorable.color());
        return graphics;
    }
    public void drawLine(DrawPosition start, DrawPosition end) {
        graphics().drawLine(start.x(), start.y(), end.x(), end.y());
    }
}
