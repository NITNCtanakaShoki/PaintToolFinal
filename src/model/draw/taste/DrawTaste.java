package model.draw.taste;

import model.draw.position.DrawPosition;

import java.awt.*;

public class DrawTaste implements Drawable {

    private final Component component;

    public DrawTaste(Component component) {
        this.component = component;
    }

    public void drawLine(DrawPosition start, DrawPosition end) {
        final var graphics = component.getGraphics();
        graphics.drawLine(start.x(), start.y(), end.x(), end.y());
    }
}
