import java.io.IOException;

public class ThrowsExp {

    public static void main(String[] args) throws HiSpeed, DefectEngine, IOException
    {
        HiSpeed e = new HiSpeed("Very fast!");
        e.initCause(new DefectEngine("Broken carburetor"));
        int speed = 0;
        byte[] commandLine = new byte[20];

        try
        {
            try
            {
                System.out.print("Input speed: ");
                System.in.read(commandLine);
            }
            catch (IOException ex)
            {
                System.out.println(ex);
            }

            for (byte symb : commandLine) {
                if(symb != 0 & symb != 10)
                    speed = speed * 10 + (symb - 48);
            }

            System.out.println("Current speed: " + speed);

            if(speed < 10)
            {
                LowSpeed excp = new LowSpeed("Low speed (" + speed + ")");
                excp.initCause(new DefectEngine("Brake carb. Low flow"));
                throw excp;
            }

            if(speed > 120)
            {
                HiSpeed excp = new HiSpeed("Hi speed (" + speed + ")");
                excp.initCause(new DefectEngine("Brake carb. Hi flow"));
                throw excp;
            }
        }
        catch (HiSpeed | LowSpeed ex)
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

class LowSpeed extends Exception
{
    private String _message;

    LowSpeed(String message)
    {
        _message = message;
    }

    @Override
    public String toString()
    {
        return _message;
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
