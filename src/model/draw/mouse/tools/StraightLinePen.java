package model.draw.mouse.tools;

import model.draw.DrawMouseMentionable;
import model.draw.position.DrawPosition;
import model.draw.taste.Drawable;

public class StraightLinePen implements DrawMouseMentionable {

    private DrawPosition previous;

    @Override
    public void init() {
        previous = DrawPosition.NOTHING;
    }

    public StraightLinePen() {
        previous = DrawPosition.NOTHING;
    }

    public void mouseClicked(Drawable drawable, DrawPosition position) {}

    public void mousePressed(Drawable drawable, DrawPosition position) {}

    public void mouseReleased(Drawable drawable, DrawPosition position) {
        if (isFirst()) {
            previous = position;
            return;
        }
        drawable.drawLine(previous, position);
        init();
    }

    public void mouseEntered(Drawable drawable, DrawPosition position) {}

    public void mouseExited(Drawable drawable, DrawPosition position) {}

    public void mouseDragged(Drawable drawable, DrawPosition position) {}

    public void mouseMoved(Drawable drawable, DrawPosition position) {}

    private boolean isFirst() {
        return previous.isNothing();
    }
}
