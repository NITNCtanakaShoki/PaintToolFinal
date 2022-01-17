package ui.frame;

import ui.Composable;

import javax.swing.*;
import java.awt.*;

public class Frame implements Composable {

    private final JFrame frame;

    public Frame() {
        frame = new JFrame();
        frameSetting(frame);
    }

    private Frame(JFrame jFrame) {
        frame = jFrame;
        frameSetting(frame);
    }

    public Frame title(String title) {
        final var jFrame = new JFrame(title);
        jFrame.setBounds(frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
        return new Frame(jFrame);
    }

    public Frame size(int width, int height) {
        final var jFrame = new JFrame(frame.getTitle());
        jFrame.setSize(width, height);
        return new Frame(jFrame);
    }

    private static void frameSetting(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
    }

    public void view() {
        frame.setVisible(true);
    }
    @Override
    public Component asComponent() {
        return frame;
    }
}
