package model.draw.taste.thickness;

import ui.menubar.menu.Selectable;

public class ThicknessSelection implements Selectable<Float> {

    private final String label;
    private final float value;

    public ThicknessSelection(String label, Float value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String label() {
        return label;
    }

    @Override
    public Float value() {
        return value;
    }
}
