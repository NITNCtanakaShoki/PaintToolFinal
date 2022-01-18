package model.draw.taste;

import model.draw.position.DrawPosition;

import java.awt.*;

public interface Drawable {
    void drawLine(DrawPosition start, DrawPosition end);
    void drawLine(DrawPosition start, DrawPosition end, Color color);
    void drawPanda(DrawPosition position);
}
