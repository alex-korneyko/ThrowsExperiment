package MyExceptions;

public class HiSpeed extends Exception {
    private String _exc;

    public HiSpeed(String exception) {
        _exc = exception;
    }

    @Override
    public String toString() {
        return _exc;
    }
}
