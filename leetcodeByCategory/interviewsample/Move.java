package leetcodeByCategory.interviewsample;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Move  {

    public static void main(String[] a) throws Exception{

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try{
                    click(2,3);

                   // System.out.println("clicked");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, 0, 20, TimeUnit.SECONDS);
    }
    public void run() {


    }
    public static void click(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
