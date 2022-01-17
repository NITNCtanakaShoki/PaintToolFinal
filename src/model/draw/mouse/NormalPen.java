package model.draw.mouse;

import model.draw.DrawMouseMentionable;
import model.draw.position.DrawPosition;
import model.draw.taste.Drawable;

public class NormalPen implements DrawMouseMentionable {
    private DrawPosition previous;

    public NormalPen() {
        previous = DrawPosition.NOTHING;
    }

    public void mouseClicked(Drawable drawable, DrawPosition position) {}

    public void mousePressed(Drawable drawable, DrawPosition position) {
        previous = position;
    }

    public void mouseReleased(Drawable drawable, DrawPosition position) {
        previous = DrawPosition.NOTHING;
    }

    public void mouseEntered(Drawable drawable, DrawPosition position) {}

    public void mouseExited(Drawable drawable, DrawPosition position) {}

    public void mouseDragged(Drawable drawable, DrawPosition position) {
        if (isFirst()) return;
        drawable.drawLine(previous, position);
        previous = position;
    }

    public void mouseMoved(Drawable drawable, DrawPosition position) {}

    private boolean isFirst() {
        return previous.isNothing();
    }
}
