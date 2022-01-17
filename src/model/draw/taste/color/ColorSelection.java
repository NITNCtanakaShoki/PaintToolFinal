package model.draw.taste.color;

import ui.menubar.menu.Selectable;

import java.awt.*;

public class ColorSelection implements Selectable<Color> {

    private final String name;
    private final Color color;

    public ColorSelection(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String label() {
        return name;
    }

    @Override
    public Color value() {
        return color;
    }
}
