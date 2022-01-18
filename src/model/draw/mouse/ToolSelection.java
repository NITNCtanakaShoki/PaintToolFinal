package model.draw.mouse;

import model.draw.DrawMouseMentionable;
import ui.menubar.menu.Selectable;

public class ToolSelection implements Selectable<DrawMouseMentionable> {
    private final String label;
    private final DrawMouseMentionable value;

    public ToolSelection(String label, DrawMouseMentionable value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String label() {
        return label;
    }

    @Override
    public DrawMouseMentionable value() {
        return value;
    }
}
