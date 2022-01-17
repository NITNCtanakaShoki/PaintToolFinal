package model.draw.tool;

import model.draw.taste.Drawable;

import java.awt.*;

public interface DrawableBuilder {
    Drawable build(Component component);
}
