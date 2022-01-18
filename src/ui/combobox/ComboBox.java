package ui.combobox;

import ui.Composable;
import ui.menubar.menu.Promise;
import ui.menubar.menu.Selectable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBox<T> implements Composable {

    private final JComboBox<Item> comboBox;
    private final Promise<T> promise;

    public ComboBox() {
        comboBox = new JComboBox<>();
        promise = new Promise<>();
    }

    private ComboBox(JComboBox<Item> jComboBox, Promise<T> promise) {
        comboBox = jComboBox;
        this.promise = promise;
    }

    public ComboBox<T> items(Selectable<T>[] selectables) {
        final var jComboBox = comboBoxClone();
        for (final var selection: selectables) {
            final var item = new Item(selection.label(), selection.value());
            jComboBox.addItem(item);
        }
        return new ComboBox<T>(jComboBox, promise);
    }

    public Promise<T> promise() {
        return promise;
    }

    private JComboBox<Item> comboBoxClone() {
        final var jComboBox = new JComboBox<Item>();
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            jComboBox.addItem(comboBox.getItemAt(i));
        }
        jComboBox.addItemListener(new Listener());
        return jComboBox;
    }

    @Override
    public Component asComponent() {
        return comboBox;
    }

    private class Listener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            final var item = (Item)e.getItem();
            promise.action(item.value);
        }
    }

    private class Item {
        private final String label;
        private final T value;

        public Item(String label, T value) {
            this.label = label;
            this.value = value;
        }
        @Override
        public String toString() {
            return label;
        }
    }
}
