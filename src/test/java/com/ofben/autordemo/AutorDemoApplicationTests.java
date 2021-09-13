package com.ofben.autordemo;

import com.ofben.autordemo.optimize.usertest.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class AutorDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {

//        complexTypeTransmit();

//        simpleTypeTransmit();

//        testParallelStream();

        testDate();
    }

    private static void testDate() {
        LocalDate beforeDate = LocalDate.now();
        LocalDate afterDate = beforeDate.plusDays(100);
        System.out.println(afterDate);
    }

    private static void testParallelStream() {

        /*
        SysCountryCovidExample example = new SysCountryCovidExample();
        List<SysCountryCovid> countryCovids = sysCountryCovidMapper.selectByExample(example);

        List<String> covidList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(countryCovids)) {
            countryCovids.parallelStream().forEach(covid -> covidList.add(covid.getCountryCode()));
        }

        return covidList;
         */
        List<String> demoList = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            demoList.add("hello" + i);
            demoList.add("world" + i);
        }
        List<String> targetList = new ArrayList<>();
        List<String> listTo = demoList.parallelStream().collect(Collectors.toList());

        System.out.println("------------");
        listTo.forEach(System.out::println);
        System.out.println(listTo.size());

    }

    private static void simpleTypeTransmit() {
        String str = "hello";
        int intArg = 12;

        operationArgs(str, intArg);

        System.out.println("source str = " + str);
        System.out.println("source intArg = " + intArg);
    }

    private static void operationArgs(String str, int intArg) {
        System.out.println("target str = " + str);
        System.out.println("target intArg = " + intArg);
        System.out.println("------------");
        str = "world";
        intArg = 21;
    }

    private static void complexTypeTransmit() {
        UserModel user = new UserModel();
        user.setName("hello");
        operationUser(user);
        System.out.println("user.age=" + user.getAge());
    }

    private static void operationUser(UserModel user) {
        System.out.println("operationUser内：" + user.getName());
        System.out.println("operationUser内：" + user.getAge());
        user.setAge(22);
    }
}
