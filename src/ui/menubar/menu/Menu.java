package ui.menubar.menu;

import ui.Composable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu<T> implements Composable {

    private final JMenu menu;
    private final Promise<T> promise;

    public Menu() {
        menu = new JMenu();
        promise = new Promise<>();
    }
    private Menu(JMenu jMenu, Promise<T> promise) {
        menu = jMenu;
        this.promise = promise;
    }
    public Menu<T> title(String title) {
        final var jMenu = menuClone();
        jMenu.setText(title);
        return new Menu<>(jMenu, promise);
    }

    public Menu<T> selections(Selectable<T>[] selections) {
        final var jMenu = menuClone();
        for (final var selection: selections) {
            final var item = new JMenuItem(selection.label());
            item.addActionListener(new Listener(selection.value()));
            jMenu.add(item);
        }
        return new Menu<>(jMenu, promise);
    }

    public JMenu menuClone() {
        final var jMenu = new JMenu(menu.getText());
        for (int i = 0; i < jMenu.getMenuComponents().length; i++) {
            jMenu.add(jMenu.getMenuComponent(i));
        }
        return jMenu;
    }

    public Promise<T> promise() {
        return promise;
    }

    @Override
    public Component asComponent() {
        return menu;
    }

    private class Listener implements ActionListener {
        private final T value;

        Listener(T value) {
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            promise.action(value);
        }
    }
}
