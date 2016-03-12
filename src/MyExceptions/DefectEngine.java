package MyExceptions;


public class DefectEngine extends Exception {
    private String _exc;

    public DefectEngine(String exception) {
        _exc = exception;
    }

    @Override
    public String toString() {
        return _exc;
    }
}
