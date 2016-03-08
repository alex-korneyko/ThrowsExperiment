/**
 * Created by admin on 08.03.2016.
 */
public class Parse
{
    public static int ToInt(byte[] bytes) throws ParseException
    {
        int result = 0;

        for(byte bt: bytes)
        {
            if(bt == 0 | bt == 10)
                continue;

            try {
                if(bt < 48 | bt > 57)
                    throw new ParseException("Error parse");

                result = result * 10 + (bt - 48);
            }
            catch (ParseException ex)
            {
                return 0;
            }
        }

        return result;
    }
}

class ParseException extends Exception
{
    private String _mess;

    ParseException(String message)
    {
        _mess = message;
    }
}
