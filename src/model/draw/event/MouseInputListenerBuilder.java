package model.draw.event;

import javax.swing.event.MouseInputListener;
import java.awt.*;

public interface MouseInputListenerBuilder {
    MouseInputListener build(Component component);
}
