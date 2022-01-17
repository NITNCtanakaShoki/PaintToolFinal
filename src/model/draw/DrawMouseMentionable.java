package model.draw;

import model.draw.position.DrawPosition;
import model.draw.taste.Drawable;

public interface DrawMouseMentionable {
    void mouseClicked(Drawable drawable, DrawPosition position);

    void mousePressed(Drawable drawable, DrawPosition position);

    void mouseReleased(Drawable drawable, DrawPosition position);

    void mouseEntered(Drawable drawable, DrawPosition position);

    void mouseExited(Drawable drawable, DrawPosition position);

    void mouseDragged(Drawable drawable, DrawPosition position);

    void mouseMoved(Drawable drawable, DrawPosition position);
}
