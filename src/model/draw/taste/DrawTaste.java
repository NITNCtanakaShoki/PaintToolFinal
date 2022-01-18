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
    public void drawPanda(DrawPosition position) {
        final var graphics = graphics();

        // 外枠
        graphics.setColor(Color.BLACK);
        graphics.fillOval(position.x() - 50, position.y() - 50, 100, 100);

        // 中白
        graphics.setColor(Color.WHITE);
        graphics.fillOval(position.x() - 46, position.y() - 46, 92, 92);

        graphics.setColor(Color.BLACK);

        // 目
        graphics.fillOval(position.x() - 25, position.y() - 21, 20, 20);
        graphics.fillOval(position.x() + 10, position.y() - 21, 20, 20);

        // 耳
        graphics.fillOval(position.x() - 70, position.y() - 50, 40, 40);
        graphics.fillOval(position.x() + 35, position.y() - 50, 40, 40);
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
