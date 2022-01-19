import model.draw.DrawControllerBuilder;
import model.draw.DrawMouseMentionable;
import model.draw.mouse.ToolRepository;
import model.draw.mouse.ToolSelection;
import model.draw.mouse.tools.*;
import model.draw.taste.DrawTasteBuilder;
import model.draw.taste.color.ColorRepository;
import model.draw.taste.color.ColorSelection;
import model.draw.taste.thickness.ThicknessRepository;
import model.draw.taste.thickness.ThicknessSelection;
import ui.button.Button;
import ui.colorchooser.ColorChooser;
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
                        new ToolSelection("三角形", new TrianglePen()),
                        new ToolSelection("消しゴム", new EraiserPen()),
                        new ToolSelection("虹色ペン", new RainbowPen()),
                        new ToolSelection("パンダスタンプ", new PandaStamp())
                })
                ;

        final var eraseAllButton = new Button()
                .title("全削除")
                .size(50, 20)
                ;



        final var toolPromise = paintToolComboBox.promise();
        toolPromise.resolve(toolRepository::set);

        final var customColorButton = new Button()
                .title("Custom Color")
                .size(100, 20)
                ;

        final var colorChooser = new ColorChooser()
                .hidden()
                ;


        final var settingPanel = new Panel()
                .position(0, 0)
                .backgroundColor(Color.blue)
                .size(500, 50)
                .components(menuBar, paintToolComboBox, customColorButton, eraseAllButton)
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
                .components(colorChooser)
                ;

        final var eraseAllPromise = eraseAllButton.promise();
        eraseAllPromise.resolve(btn -> {
            paintPanel.visible(false);
            paintPanel.visible(true);
        });

        final var customColorPromise = customColorButton.promise();
        customColorPromise.resolve(btn -> {
            final var title = "Custom Color";
            final var confirm = "OK";
            if (btn.getText().equals(title)) {
                btn.setText(confirm);
                colorChooser.isVisible(true);
                return;
            }
            btn.setText(title);
            colorRepository.set(colorChooser.color());
            toolRepository.set(new NormalPen());
            colorChooser.isVisible(false);
        });


        final var frame = new Frame()
                .title("お絵描き")
                .size(500, 500)
                .components(paintPanel, settingPanel)
                ;

        frame.view();
    }
}
