import java.io.IOException;
import MyExceptions.*;

public class ThrowsExp {

    public static void main(String[] args) throws HiSpeed, DefectEngine, IOException, ParseException {
        HiSpeed e = new HiSpeed("Very fast!");
        e.initCause(new DefectEngine("Broken carburetor"));
        int speed = 0;
        byte[] commandLine = new byte[20];

        try {
            System.out.print("Input speed: ");
            System.in.read(commandLine);

            speed = Parse.ToInt(commandLine);

            System.out.println("Current speed: " + speed);

            if (speed < 10) {
                LowSpeed excp = new LowSpeed("Low speed (" + speed + ")");
                excp.initCause(new DefectEngine("Broken carb. Low flow"));
                throw excp;
            }

            if (speed > 120) {
                HiSpeed excp = new HiSpeed("Hi speed (" + speed + ")");
                excp.initCause(new DefectEngine("Broken carb. Fat flow"));
                throw excp;
            }
        } catch (HiSpeed | LowSpeed ex) {
            System.out.println(ex);
            System.out.println(ex.getCause());
        } finally {
            System.out.println("brake!");
        }
    }
}