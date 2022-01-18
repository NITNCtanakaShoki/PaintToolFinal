package model.draw.mouse.tools;

import model.draw.DrawMouseMentionable;
import model.draw.position.DrawPosition;
import model.draw.taste.Drawable;

public class TrianglePen implements DrawMouseMentionable {
    private DrawPosition first;
    private DrawPosition second;

    @Override
    public void init() {
        first = DrawPosition.NOTHING;
        second = DrawPosition.NOTHING;
    }

    public TrianglePen() {
        init();
    }

    public void mouseClicked(Drawable drawable, DrawPosition position) {}

    public void mousePressed(Drawable drawable, DrawPosition position) {}

    public void mouseReleased(Drawable drawable, DrawPosition position) {
        if (isFirst()) {
            first = position;
            return;
        }
        if (isSecond()) {
            second = position;
            drawable.drawLine(first, second);
            return;
        }
        drawable.drawLine(first, position);
        drawable.drawLine(second, position);
        init();
    }

    public void mouseEntered(Drawable drawable, DrawPosition position) {}

    public void mouseExited(Drawable drawable, DrawPosition position) {}

    public void mouseDragged(Drawable drawable, DrawPosition position) {}

    public void mouseMoved(Drawable drawable, DrawPosition position) {}

    private boolean isFirst() {
        return first.isNothing();
    }

    private boolean isSecond() {
        return second.isNothing();
    }
}
