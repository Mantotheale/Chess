package chess.exceptions;

public class GLFWWindowCreationException extends IllegalArgumentException {
    public GLFWWindowCreationException() {
        super("Failed to create the GLFW window");
    }
}