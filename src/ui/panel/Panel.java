package ui.panel;

import model.draw.event.MouseInputListenerBuilder;
import ui.Composable;

import javax.swing.*;
import java.awt.*;

public class Panel implements Composable {
    private final JPanel panel;
    private final MouseInputListenerBuilder[] mouseInputListenerBuilders;

    public Panel() {
        panel = new JPanel();
        mouseInputListenerBuilders = new MouseInputListenerBuilder[0];
    }

    private Panel(JPanel jPanel, MouseInputListenerBuilder[] mouseListenerBuilders) {
        panel = jPanel;
        mouseInputListenerBuilders = mouseListenerBuilders;
    }

    public Panel position(int x, int y) {
        final var jPanel = panelClone();
        jPanel.setBounds(x, y, panel.getWidth(), panel.getHeight());
        return new Panel(jPanel, mouseInputListenerBuilders);
    }

    public Panel size(int width, int height) {
        final var jPanel = panelClone();
        jPanel.setBounds(panel.getX(), panel.getY(), width, height);
        return new Panel(jPanel, mouseInputListenerBuilders);
    }

    public Panel backgroundColor(Color color) {
        final var jPanel = panelClone();
        jPanel.setBackground(color);
        return new Panel(jPanel, mouseInputListenerBuilders);
    }

    public Panel components(Composable... composables) {
        final var jPanel = panelClone();
        for (final var component: composables) {
            jPanel.add(component.asComponent());
        }
        return new Panel(jPanel, mouseInputListenerBuilders);
    }

    public Panel mouseInputListeners(MouseInputListenerBuilder... builders) {
        final var jPanel = panelClone();
        for (final var builder: builders) {
            jPanel.addMouseListener(builder.build(jPanel));
            jPanel.addMouseMotionListener(builder.build(jPanel));
        }
        return new Panel(jPanel, builders);
    }

    private JPanel panelClone() {
        final var jPanel = new JPanel();
        jPanel.setBounds(panel.getX(), panel.getY(), panel.getWidth(), panel.getHeight());
        jPanel.setBackground(panel.getBackground());
        for (final var builder: mouseInputListenerBuilders) {
            jPanel.addMouseListener(builder.build(jPanel));
            jPanel.addMouseMotionListener(builder.build(jPanel));
        }
        return jPanel;
    }

    public void removeAllComponents() {
        panel.removeAll();
    }
    public void initializeBy(Color color) {
        panel.setBackground(color);
    }

    public void visible(boolean isVisible) {
        panel.setVisible(isVisible);
    }

    @Override
    public Component asComponent() {
        return panel;
    }
}
