package model.draw.mouse.tools;

import model.draw.DrawMouseMentionable;
import model.draw.position.DrawPosition;
import model.draw.taste.Drawable;

public class PandaStamp implements DrawMouseMentionable {
    public void init() {}

    public void mouseClicked(Drawable drawable, DrawPosition position) {}

    public void mousePressed(Drawable drawable, DrawPosition position) {}

    public void mouseReleased(Drawable drawable, DrawPosition position) {
        drawable.drawPanda(position);
    }

    public void mouseEntered(Drawable drawable, DrawPosition position) {}

    public void mouseExited(Drawable drawable, DrawPosition position) {}

    public void mouseDragged(Drawable drawable, DrawPosition position) {}

    public void mouseMoved(Drawable drawable, DrawPosition position) {}

}
