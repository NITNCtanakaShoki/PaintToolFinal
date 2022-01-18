package model.draw.taste;

import model.draw.position.DrawPosition;
import model.draw.taste.thickness.Thicknessable;

import java.awt.*;

public class DrawTaste implements Drawable {

    private final Component component;
    private final Colorable colorable;
    private final Thicknessable thicknessable;

    public DrawTaste(Component component, Colorable colorable, Thicknessable thicknessable) {
        this.component = component;
        this.colorable = colorable;
        this.thicknessable = thicknessable;
    }

    public Graphics graphics() {
        final var graphics = component.getGraphics();
        setColor(graphics);
        setThickness(graphics);
        return graphics;
    }
    public void drawLine(DrawPosition start, DrawPosition end) {
        drawLine(graphics(), start, end);
    }

    @Override
    public void drawLine(DrawPosition start, DrawPosition end, Color color) {
        final var graphics = graphics();
        graphics.setColor(color);
        drawLine(graphics, start, end);
    }

    private void setColor(Graphics graphics) {
        graphics.setColor(colorable.color());
    }
    private void drawLine(Graphics graphics, DrawPosition start, DrawPosition end) {
        graphics.drawLine(start.x(), start.y(), end.x(), end.y());
    }
    private void setThickness(Graphics graphics) {
        final var graphics2D = (Graphics2D)graphics;
        graphics2D.setStroke(new BasicStroke(thicknessable.thickness()));
    }
}
