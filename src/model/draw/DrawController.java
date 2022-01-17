package model.draw;

import model.draw.position.DrawPosition;
import model.draw.taste.Drawable;
import model.draw.tool.DrawableBuilder;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class DrawController implements MouseInputListener {

    private final Drawable drawable;
    private final DrawMouseMentionable mouse;

    public DrawController(Component component, DrawableBuilder drawableBuilder, DrawMouseMentionable mouse) {
        drawable = drawableBuilder.build(component);
        this.mouse = mouse;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouse.mouseClicked(drawable, DrawPosition.make(e));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouse.mousePressed(drawable, DrawPosition.make(e));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouse.mouseReleased(drawable, DrawPosition.make(e));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouse.mouseEntered(drawable, DrawPosition.make(e));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouse.mouseExited(drawable, DrawPosition.make(e));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouse.mouseDragged(drawable, DrawPosition.make(e));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse.mouseMoved(drawable, DrawPosition.make(e));
    }

}
