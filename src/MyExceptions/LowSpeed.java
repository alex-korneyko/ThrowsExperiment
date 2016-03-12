package MyExceptions;


public class LowSpeed extends Exception {
    private String _message;

    public LowSpeed(String message) {
        _message = message;
    }

    @Override
    public String toString() {
        return _message;
    }
}
