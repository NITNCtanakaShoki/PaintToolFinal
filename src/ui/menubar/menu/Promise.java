package ui.menubar.menu;

public class Promise<T> {
    private Method<T> method;

    public void resolve(Method<T> method) {
        this.method = method;
    }

    void action(T value) {
        method.run(value);
    }

    @FunctionalInterface
    public interface Method<T> {
        void run(T value);
    }
}