package ui.button;

import ui.Composable;
import ui.menubar.menu.Promise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button implements Composable {
    private final JButton button;
    private final Promise<JButton> promise;

    public Button() {
        button = new JButton();
        promise = new Promise<>();
    }

    private Button(JButton jButton, Promise<JButton> promise) {
        button = jButton;
        this.promise = promise;
    }

    public Button title(String title) {
        final var jButton = buttonClone();
        jButton.setText(title);
        return new Button(jButton, promise);
    }

    public Button size(int width, int height) {
        final var jButton = buttonClone();
        jButton.setSize(width, height);
        return new Button(jButton, promise);
    }

    public Promise<JButton> promise() {
        return promise;
    }

    private JButton buttonClone() {
        final var jButton = new JButton();
        jButton.addActionListener(new Listener(jButton));
        jButton.setText(button.getText());
        jButton.setBounds(button.getX(), button.getY(), button.getWidth(), button.getHeight());
        return jButton;
    }

    private class Listener implements ActionListener {
        private final JButton button;
        public Listener(JButton button) {
            this.button = button;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            promise.action(button);
        }
    }

    @Override
    public Component asComponent() {
        return button;
    }
}
