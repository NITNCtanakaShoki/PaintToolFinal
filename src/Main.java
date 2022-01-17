import ui.frame.Frame;
import ui.panel.Panel;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        final var paintPanel = new Panel()
                .position(0, 20)
                .backgroundColor(Color.RED)
                .size(500, 480);


        final var frame = new Frame()
                .title("お絵描き")
                .size(500, 500)
                .components(paintPanel);

        frame.view();
    }
}
