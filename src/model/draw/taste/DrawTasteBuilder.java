package model.draw.taste;

import model.draw.taste.thickness.Thicknessable;
import model.draw.tool.DrawableBuilder;

import java.awt.*;

public class DrawTasteBuilder implements DrawableBuilder {

    private final Colorable colorable;
    private final Thicknessable thicknessable;

    public DrawTasteBuilder(Colorable colorable, Thicknessable thicknessable) {
        this.colorable = colorable;
        this.thicknessable = thicknessable;
    }
    @Override
    public Drawable build(Component component) {
        return new DrawTaste(component, colorable, thicknessable);
    }
}
