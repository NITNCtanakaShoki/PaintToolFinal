import model.draw.DrawControllerBuilder;
import model.draw.mouse.NormalPen;
import model.draw.taste.DrawTasteBuilder;
import model.draw.taste.color.ColorRepository;
import model.draw.taste.color.ColorSelection;
import ui.frame.Frame;
import ui.menubar.MenuBar;
import ui.menubar.menu.Menu;
import ui.panel.Panel;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        final var colorRepository = new ColorRepository();

        final var colorMenu = new Menu<Color>()
                .title("色")
                .selections(new ColorSelection[]{
                        new ColorSelection("赤", Color.RED),
                        new ColorSelection("青", Color.BLUE),
                        new ColorSelection("黒", Color.BLACK)
                })
                ;

        final var promise = colorMenu.promise();
        promise.resolve(colorRepository::set);

        final var menuBar = new MenuBar()
                .position(0, 0)
                .size(100, 20)
                .menus(colorMenu)
                ;

        final var paintPanel = new Panel()
                .position(0, 20)
                .backgroundColor(Color.WHITE)
                .size(500, 480)
                .mouseInputListeners(
                        new DrawControllerBuilder(
                                new DrawTasteBuilder(colorRepository),
                                new NormalPen()
                        )
                )
                ;


        final var frame = new Frame()
                .title("お絵描き")
                .size(500, 500)
                .components(paintPanel, menuBar)
                ;

        frame.view();
    }
}
