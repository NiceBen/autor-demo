package com.ofben.autordemo.test.enums;

/**
 * {@link Enum} Test
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
public enum WeekDayEnum {
    Mon("Monday"),
    Tue("Tuesday"),
    Web("Wednesday"),
    Thu("Thursday"),
    Fri("Friday"),
    Sat("Saturday"),
    Sun("Sunday");

    private final String day;

    WeekDayEnum(String day) {
        this.day = day;
    }

    public static void printDay(int i) {
        switch (i) {
            case 1:
                System.out.println(WeekDayEnum.Mon);
                break;
            case 2:
                System.out.println(WeekDayEnum.Tue);
                break;
            case 3:
                System.out.println(WeekDayEnum.Web);
                break;
            case 4:
                System.out.println(WeekDayEnum.Thu);
                break;
            case 5:
                System.out.println(WeekDayEnum.Fri);
                break;
            case 6:
                System.out.println(WeekDayEnum.Sat);
                break;
            case 7:
                System.out.println(WeekDayEnum.Sun);
                break;
            default:
                System.out.println("wrong number!");
        }
    }

    public String getDay() {
        return day;
    }
}
