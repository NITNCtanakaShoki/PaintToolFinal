package model.draw.taste;

import model.draw.tool.DrawableBuilder;

import java.awt.*;

public class DrawTasteBuilder implements DrawableBuilder {
    @Override
    public Drawable build(Component component) {
        return new DrawTaste(component);
    }
}
