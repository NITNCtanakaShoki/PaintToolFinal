import model.draw.DrawControllerBuilder;
import model.draw.DrawMouseMentionable;
import model.draw.mouse.ToolRepository;
import model.draw.mouse.ToolSelection;
import model.draw.mouse.tools.NormalPen;
import model.draw.mouse.tools.StraightLinePen;
import model.draw.mouse.tools.TrianglePen;
import model.draw.taste.DrawTasteBuilder;
import model.draw.taste.color.ColorRepository;
import model.draw.taste.color.ColorSelection;
import model.draw.taste.thickness.ThicknessRepository;
import model.draw.taste.thickness.ThicknessSelection;
import ui.combobox.ComboBox;
import ui.frame.Frame;
import ui.menubar.MenuBar;
import ui.menubar.menu.Menu;
import ui.panel.Panel;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        /* 状態保存ストア */
        final var colorRepository = new ColorRepository();
        final var thicknessRepository = new ThicknessRepository();
        final var toolRepository = new ToolRepository(new NormalPen());
        /*              */

        final var colorMenu = new Menu<Color>()
                .title("色")
                .selections(new ColorSelection[]{
                        new ColorSelection("赤", Color.RED),
                        new ColorSelection("青", Color.BLUE),
                        new ColorSelection("黒", Color.BLACK)
                })
                ;

        final var colorPromise = colorMenu.promise();
        colorPromise.resolve(colorRepository::set);

        final var thicknessMenu = new Menu<Float>()
                .title("太さ")
                .selections(new ThicknessSelection[]{
                        new ThicknessSelection("大", 5.0f),
                        new ThicknessSelection("中", 3.0f),
                        new ThicknessSelection("小", 1.0f),
                })
                ;


        final var thicknessPromise = thicknessMenu.promise();
        thicknessPromise.resolve(thicknessRepository::set);


        final var menuBar = new MenuBar()
                .position(0, 0)
                .size(100, 50)
                .menus(colorMenu, thicknessMenu)
                ;

        final var paintToolComboBox = new ComboBox<DrawMouseMentionable>()
                .items(new ToolSelection[]{
                        new ToolSelection("ノーマル", new NormalPen()),
                        new ToolSelection("直線", new StraightLinePen()),
                        new ToolSelection("三角形", new TrianglePen())
                })
                ;

        final var toolPromise = paintToolComboBox.promise();
        toolPromise.resolve(toolRepository::set);

        final var settingPanel = new Panel()
                .position(0, 0)
                .backgroundColor(Color.blue)
                .size(500, 50)
                .components(menuBar, paintToolComboBox)
                ;

        final var paintPanel = new Panel()
                .position(0, 50)
                .backgroundColor(Color.WHITE)
                .size(500, 450)
                .mouseInputListeners(
                        new DrawControllerBuilder(
                                new DrawTasteBuilder(colorRepository, thicknessRepository),
                                toolRepository
                        )
                )
                ;


        final var frame = new Frame()
                .title("お絵描き")
                .size(500, 500)
                .components(paintPanel, settingPanel)
                ;

        frame.view();
    }
}
