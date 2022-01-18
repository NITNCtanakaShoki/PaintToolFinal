package ui.colorchooser;

import ui.Composable;

import javax.swing.*;
import java.awt.*;

public class ColorChooser implements Composable {

    private final JColorChooser colorChooser;

    public ColorChooser() {
        colorChooser = new JColorChooser();
    }
    private ColorChooser(JColorChooser jColorChooser) {
        colorChooser = jColorChooser;
    }

    public void isVisible(boolean isVisible) {
        colorChooser.setVisible(isVisible);
    }

    public Color color() {
        return colorChooser.getColor();
    }

    public ColorChooser hidden() {
        final var jColorChooser = new JColorChooser();
        jColorChooser.setVisible(false);
        return new ColorChooser(jColorChooser);
    }

    @Override
    public Component asComponent() {
        return colorChooser;
    }
}
