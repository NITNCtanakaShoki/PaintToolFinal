package ui.menubar.menu;

public class Selection implements Selectable<String> {

    private final String label;
    private final String value;
    @Override
    public String label() {
        return label;
    }

    @Override
    public String value() {
        return value;
    }

    public Selection(String label, String value) {
        this.label = label;
        this.value = value;
    }
}
