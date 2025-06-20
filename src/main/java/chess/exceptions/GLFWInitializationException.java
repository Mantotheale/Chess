package chess.exceptions;

public class GLFWInitializationException extends IllegalArgumentException {
    public GLFWInitializationException() {
        super("Unable to initialize GLFW");
    }
}
