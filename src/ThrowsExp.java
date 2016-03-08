
public class ThrowsExp {

    public static void main(String[] args) throws HiSpeed, DefectEngine
    {
        HiSpeed e = new HiSpeed("Very fast!");
        e.initCause(new DefectEngine("Broken carburetor"));

        try
        {
            throw e;
        }
        catch (HiSpeed ex)
        {
            System.out.println(ex);
            System.out.println(ex.getCause());
        }
        finally {
            System.out.println("brake!");
        }
    }


}

class HiSpeed extends Exception
{
    private String _exc;

    HiSpeed(String exception)
    {
        _exc = exception;
    }

    @Override
    public String toString()
    {
        return _exc;
    }
}

class DefectEngine extends Exception
{
    private String _exc;

    DefectEngine(String exception)
    {
        _exc = exception;
    }

    @Override
    public String toString()
    {
        return _exc;
    }
}
