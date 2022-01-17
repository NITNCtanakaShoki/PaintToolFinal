import model.draw.DrawController;
import model.draw.DrawControllerBuilder;
import model.draw.mouse.NormalPen;
import model.draw.taste.DrawTaste;
import model.draw.taste.DrawTasteBuilder;
import ui.frame.Frame;
import ui.panel.Panel;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        final var paintPanel = new Panel()
                .position(0, 20)
                .backgroundColor(Color.WHITE)
                .size(500, 480)
                .mouseInputListeners(
                        new DrawControllerBuilder(
                                new DrawTasteBuilder(),
                                new NormalPen()
                        )
                )
                ;


        final var frame = new Frame()
                .title("お絵描き")
                .size(500, 500)
                .components(paintPanel)
                ;

        frame.view();
    }
}
