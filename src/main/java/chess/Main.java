package chess;

public class Main {
    public static void main(String[] args) {
        Window window = new Window(600, 600, "Chess");

        window.setClearColor(1.0f, 0.0f, 0.0f, 0.0f);

        while (!window.shouldClose()) {
            window.clearColor();

            window.swapBuffers();
            window.pollEvents();
        }
    }
}
