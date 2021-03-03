package utils;

import constants.WaitTime;

public class ThreadHelper {
    public static void sleep(WaitTime waitTime)
    {
        try
        {
            long waitMilliseconds = 1000;

            if (waitTime == WaitTime.SHORT)
            {
                waitMilliseconds = 2000;
            }
            else if (waitTime == WaitTime.MEDIUM)
            {
                waitMilliseconds = 6000;
            }
            else if (waitTime == WaitTime.LONG)
            {
                waitMilliseconds = 10000;
            }

            Thread.sleep(waitMilliseconds);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
    }
}
