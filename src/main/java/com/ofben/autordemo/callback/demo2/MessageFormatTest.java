package com.ofben.autordemo.callback.demo2;

import java.text.MessageFormat;
import java.util.Date;

public class MessageFormatTest {

    /*
    int planet = 7;
   String event = "a disturbance in the Force";

   String result = MessageFormat.format(
       "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
       planet, new Date(), event);
     */
    public static void main(String[] args) {

        String pattern = "hello {0, time} on {0, date}, and {1}  ooooo {2,number, integer}.";

        String str = MessageFormat.format(pattern,new Date(), "world", 222);

        System.out.println(str);
    }
}
