package model.draw.taste;

import model.draw.tool.DrawableBuilder;

import java.awt.*;

public class DrawTasteBuilder implements DrawableBuilder {

    private final Colorable colorable;

    public DrawTasteBuilder(Colorable colorable) {
        this.colorable = colorable;
    }
    @Override
    public Drawable build(Component component) {
        return new DrawTaste(component, colorable);
    }
}
