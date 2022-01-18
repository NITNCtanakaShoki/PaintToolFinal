package model.draw.mouse.tools;

import model.draw.DrawMouseMentionable;
import model.draw.position.DrawPosition;
import model.draw.taste.Drawable;

import java.awt.*;

public class RainbowPen implements DrawMouseMentionable {
    private DrawPosition previous;
    private int index;

    private static final Color[] colors = {
            new Color(255, 0, 0),
            new Color(255, 40, 0),
            new Color(255, 80, 0),
            new Color(255, 120, 0),
            new Color(255, 160, 0),
            new Color(255, 200, 0),
            new Color(255, 240, 0),
            new Color(215, 240, 0),
            new Color(150, 200, 0),
            new Color(100, 200, 0),
            new Color(50, 180, 0),
            new Color(0, 135, 0),
            new Color(0, 145, 80),
            new Color(0, 145, 120),
            new Color(0, 145, 200),
            new Color(0, 145, 255),
            new Color(0, 120, 220),
            new Color(0, 110, 190),
            new Color(70, 0, 160),
            new Color(140, 0, 130),
    };

    @Override
    public void init() {
        previous = DrawPosition.NOTHING;
        index = 0;
    }

    public RainbowPen() {
        previous = DrawPosition.NOTHING;
    }

    public void mouseClicked(Drawable drawable, DrawPosition position) {}

    public void mousePressed(Drawable drawable, DrawPosition position) {
        previous = position;
    }

    public void mouseReleased(Drawable drawable, DrawPosition position) {
        init();
    }

    public void mouseEntered(Drawable drawable, DrawPosition position) {}

    public void mouseExited(Drawable drawable, DrawPosition position) {}

    public void mouseDragged(Drawable drawable, DrawPosition position) {
        if (isFirst()) return;
        drawable.drawLine(previous, position, colors[index]);
        updateIndex();
        previous = position;
    }

    public void mouseMoved(Drawable drawable, DrawPosition position) {}

    private boolean isFirst() {
        return previous.isNothing();
    }

    private void updateIndex() {
        index++;
        if (colors.length == index) index = 0;
    }
}
