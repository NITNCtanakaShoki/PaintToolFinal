package ui.menubar;

import ui.Composable;

import javax.swing.*;
import java.awt.*;

public class MenuBar implements Composable {

    private final JMenuBar menuBar;

    public MenuBar() {
        menuBar = new JMenuBar();
    }

    private MenuBar(JMenuBar jMenuBar) {
        menuBar = jMenuBar;
    }

    public MenuBar size(int width, int height) {
        final var jMenuBar = menubarClone();
        jMenuBar.setSize(width, height);
        return new MenuBar(jMenuBar);
    }

    public MenuBar position(int x, int y) {
        final var jMenuBar = menubarClone();
        jMenuBar.setLocation(x, y);
        return new MenuBar(jMenuBar);
    }

    public MenuBar menus(Composable... menus) {
        final var jMenuBar = menubarClone();
        for (final var menu: menus) {
            jMenuBar.add(menu.asComponent());
        }
        return new MenuBar(jMenuBar);
    }

    private JMenuBar menubarClone() {
        final var jMenuBar = new JMenuBar();
        jMenuBar.setBounds(menuBar.getX(), menuBar.getY(), menuBar.getWidth(), menuBar.getHeight());
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            jMenuBar.add(menuBar.getMenu(i));
        }
        return jMenuBar;
    }

    @Override
    public Component asComponent() {
        return menuBar;
    }
}
