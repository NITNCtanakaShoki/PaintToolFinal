package model.draw.mouse;

import model.draw.DrawMouseMentionable;
import model.draw.position.DrawPosition;
import model.draw.taste.Drawable;

public class ToolRepository implements DrawMouseMentionable {

    private DrawMouseMentionable tool;

    public ToolRepository(DrawMouseMentionable defaultTool) {
        this.tool = defaultTool;
    }

    public void set(DrawMouseMentionable tool) {
        this.tool = tool;
        this.tool.init();
    }

    public void init() {
        tool.init();
    }

    public void mouseClicked(Drawable drawable, DrawPosition position) {
        tool.mouseClicked(drawable, position);
    }

    public void mousePressed(Drawable drawable, DrawPosition position) {
        tool.mousePressed(drawable, position);
    }

    public void mouseReleased(Drawable drawable, DrawPosition position) {
        tool.mouseReleased(drawable, position);
    }

    public void mouseEntered(Drawable drawable, DrawPosition position) {
        tool.mouseEntered(drawable, position);
    }

    public void mouseExited(Drawable drawable, DrawPosition position) {
        tool.mouseExited(drawable, position);
    }

    public void mouseDragged(Drawable drawable, DrawPosition position) {
        tool.mouseDragged(drawable, position);
    }

    public void mouseMoved(Drawable drawable, DrawPosition position) {
        tool.mouseMoved(drawable, position);
    }
}
