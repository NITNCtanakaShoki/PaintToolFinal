import ui.frame.Frame;

public class Main {

    public static void main(String[] args) {
         final var frame = new Frame()
                .title("お絵描き")
                .size(500, 500);

         frame.view();
    }
}
