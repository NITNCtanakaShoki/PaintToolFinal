package ui.frame;

import ui.Composable;

import javax.swing.*;

public class Frame {

    private final JFrame frame;

    public Frame() {
        frame = new JFrame();
    }

    private Frame(JFrame jFrame) {
        frame = jFrame;
    }

    public Frame title(String title) {
        final var jFrame = jFrameClone();
        jFrame.setTitle(title);
        return new Frame(jFrame);
    }

    public Frame size(int width, int height) {
        final var jFrame = jFrameClone();
        jFrame.setSize(width, height);
        return new Frame(jFrame);
    }

    public Frame components(Composable... components) {
        final var jFrame = jFrameClone();
        for (final var component: components) {
            jFrame.add(component.asComponent());
        }
        return new Frame(jFrame);
    }

    public void view() {
        frame.setVisible(true);
    }

    private JFrame jFrameClone() {
        final var jFrame = new JFrame(frame.getTitle());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        for (final var component: frame.getComponents()) {
            jFrame.add(component);
        }
        jFrame.setSize(frame.getWidth(), frame.getHeight());
        return jFrame;
    }


}
