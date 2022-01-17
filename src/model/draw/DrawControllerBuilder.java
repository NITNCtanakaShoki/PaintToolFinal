package model.draw;

import model.draw.event.MouseInputListenerBuilder;
import model.draw.tool.DrawableBuilder;

import javax.swing.event.MouseInputListener;
import java.awt.*;

public class DrawControllerBuilder implements MouseInputListenerBuilder {

    private final DrawableBuilder drawableBuilder;
    private final DrawMouseMentionable mouse;

    public DrawControllerBuilder(DrawableBuilder drawableBuilder, DrawMouseMentionable mouse) {
        this.drawableBuilder = drawableBuilder;
        this.mouse = mouse;
    }
    @Override
    public MouseInputListener build(Component component) {
        return new DrawController(component, drawableBuilder, mouse);
    }
}
