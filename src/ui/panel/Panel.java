package ui.panel;

import ui.Composable;

import javax.swing.*;
import java.awt.*;

public class Panel implements Composable {
    private final JPanel panel;

    public Panel() {
        panel = new JPanel();
    }

    private Panel(JPanel jPanel) {
        panel = jPanel;
    }

    public Panel position(int x, int y) {
        final var jPanel = panelClone();
        jPanel.setBounds(x, y, panel.getWidth(), panel.getHeight());
        return new Panel(jPanel);
    }

    public Panel size(int width, int height) {
        final var jPanel = panelClone();
        jPanel.setBounds(panel.getX(), panel.getY(), width, height);
        return new Panel(jPanel);
    }

    public Panel backgroundColor(Color color) {
        final var jPanel = panelClone();
        jPanel.setBackground(color);
        return new Panel(jPanel);
    }

    private JPanel panelClone() {
        final var jPanel = new JPanel();
        jPanel.setBounds(panel.getX(), panel.getY(), panel.getWidth(), panel.getHeight());
        jPanel.setBackground(panel.getBackground());
        return jPanel;
    }

    @Override
    public Component asComponent() {
        return panel;
    }
}
