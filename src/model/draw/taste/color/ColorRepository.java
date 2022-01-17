package model.draw.taste.color;

import model.draw.taste.Colorable;

import java.awt.*;

public class ColorRepository implements Colorable {

    public ColorRepository() {
        color = Color.BLACK;
    }
    private Color color;

    public void set(Color color) {
        this.color = color;
    }

    @Override
    public Color color() {
        return color;
    }
}
