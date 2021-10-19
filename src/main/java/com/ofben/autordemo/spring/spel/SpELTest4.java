package com.ofben.autordemo.spring.spel;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link ExpressionParser}
 * {@link SpelExpressionParser}
 *
 * @date 2021-10-18
 * @since 1.0.0
 */
public class SpELTest4 {

    public static void main(String[] args) throws NoSuchMethodException {
        ExpressionParser parser = new SpelExpressionParser();

//        textTest(parser);

//        propertiesTest(parser);

//        arraysTest(parser);

//        mapTest(parser);

//        innerList(parser);

//        innerMap(parser);

//        innerArrays(parser);

//        invokeMethod(parser);

//        invokeRelation(parser);

//        invokeRule(parser);

//        logic(parser);

//        type(parser);

//        variable(parser);

//        method(parser);

//        beans(parser);

//        threeLogic(parser);

//        operation(parser);

        template(parser);
    }

    private static void template(ExpressionParser parser) {
        String randomPhrase = parser.parseExpression(
                "random number is #{T(java.lang.Math).random()}",
                new TemplateParserContext()).getValue(String.class);
        System.out.println(randomPhrase);
    }

    private static void operation(ExpressionParser parser) {
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        Operation operation = new Operation();
        DoDemo doDemo = new DoDemo();
        doDemo.setName("hello");
        operation.setDoDemo(doDemo);

        String name = parser.parseExpression("doDemo?.name").getValue(context, operation, String.class);
        System.out.println(name);

        operation.setDoDemo(null);
        name = parser.parseExpression("doDemo?.name").getValue(context, operation, String.class);
        System.out.println(name);
    }

    static class Operation {
        private DoDemo doDemo;

        public DoDemo getDoDemo() {
            return doDemo;
        }

        public void setDoDemo(DoDemo doDemo) {
            this.doDemo = doDemo;
        }
    }

    private static void threeLogic(ExpressionParser parser) {
        String value = parser.parseExpression("'false'?'hello':'world'").getValue(String.class);
        System.out.println(value);

        DoDemo doDemo = new DoDemo();
//        doDemo.name = "hello";
        String value1 = parser.parseExpression("name?:'unknown'").getValue(doDemo, String.class);
        System.out.println(value1);
    }

    private static void beans(ExpressionParser parser) {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new myBeanResolver2());
        context.setBeanResolver(new myBeanResolver());

        Object value = parser.parseExpression("@something22").getValue(context);
        System.out.println(value);
    }

    static class myBeanResolver implements BeanResolver {
        @Override
        public Object resolve(EvaluationContext context, String beanName) throws AccessException {
            DoDemo doDemo = new DoDemo();
            context.setVariable("something", doDemo);
            return doDemo;
        }
    }

    static class myBeanResolver2 implements BeanResolver {
        @Override
        public Object resolve(EvaluationContext context, String beanName) throws AccessException {
            DoDemo2 doDemo2 = new DoDemo2();
            context.setVariable("something", doDemo2);
            return doDemo2;
        }
    }

    static class DoDemo2 {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static void method(ExpressionParser parser) throws NoSuchMethodException {
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        context.setVariable("reverseString",
                StringUtils.class.getDeclaredMethod("reverseString", String.class));

        String value = parser.parseExpression("#reverseString('hello')").getValue(context, String.class);
        System.out.println(value);
    }

    static class StringUtils {
        public static String reverseString(String input) {
            StringBuilder builder = new StringBuilder(input.length());
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                builder.insert(0, chars[i]);
            }
            return builder.toString();
        }
    }

    private static void variable(ExpressionParser parser) {
        DoDemo doDemo = new DoDemo();
        doDemo.name = "world";

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        context.setVariable("variableName", "hello");

        parser.parseExpression("setName(#variableName)").getValue(context, doDemo);
        System.out.println(doDemo.name);
    }

    static class DoDemo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static void type(ExpressionParser parser) {
        Class dataClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
        System.out.println(dataClass);
    }

    private static void logic(ExpressionParser parser) {
        Boolean true_and_false = parser.parseExpression("true and false").getValue(Boolean.class);
        System.out.println(true_and_false);

        String expression = "isMember('Nokola') and isMember('ddd')";
        Member member = new Member();
        Boolean value = parser.parseExpression(expression).getValue(member, Boolean.class);
        System.out.println(value);

        Boolean true_or_false = parser.parseExpression("true or false").getValue(Boolean.class);
        System.out.println(true_or_false);

        Boolean value1 = parser.parseExpression("!true").getValue(Boolean.class);
        System.out.println(value1);
    }

    private static void invokeRule(ExpressionParser parser) {
        Boolean falseValue = parser.parseExpression("'xyz' instanceof T(String)").getValue(Boolean.class);
        System.out.println(falseValue);

        Boolean trueValue = parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        System.out.println(trueValue);
    }

    private static void invokeRelation(ExpressionParser parser) {
        Boolean value = parser.parseExpression("2 == 2").getValue(Boolean.class);
        System.out.println(value);

        Boolean value1 = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
        System.out.println(value1);

        Boolean value2 = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);
        System.out.println(value2);
    }

    private static void invokeMethod(ExpressionParser parser) {
        String bc = parser.parseExpression("'abc'.substring(1,3)").getValue(String.class);
        System.out.println(bc);

        Member member = new Member();
        Boolean isMember = parser.parseExpression("isMember('hello world')").getValue(member, Boolean.class);
        System.out.println(isMember);
    }

    static class Member {
        public boolean isMember(String msg) {
            System.out.println("msg:" + msg);
            return true;
        }

    }

    private static void innerArrays(ExpressionParser parser) {
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        int[] numbers1 = (int[]) parser.parseExpression("new int[4]").getValue(context);
        System.out.println(numbers1.length);

        int[] numbers2 = (int[]) parser.parseExpression("new int[]{1, 2, 3}").getValue(context);
        Arrays.stream(numbers2).forEach(System.out::println);

        int[][] number3 = (int[][]) parser.parseExpression("new int[4][5]").getValue(context);
    }

    private static void innerMap(ExpressionParser parser) {
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        Map map = (Map) parser.parseExpression("{name:'zhangsan',age:13}").getValue(context);
        map.forEach((key, value) -> System.out.println(key + ":" + value));

        Map<String, Map> maps = (Map) parser.parseExpression("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}").getValue(context);
        maps.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((innerKey, innerVal) -> System.out.println(innerKey + ":" + innerVal));
        });
    }

    private static void innerList(ExpressionParser parser) {
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        List number = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
        number.forEach(System.out::println);

        List listOfLists = (List) parser.parseExpression("{{'a', 'b'}, {'x', 'y'}}").getValue(context);
        listOfLists.forEach(list -> {
            if (List.class.isAssignableFrom(list.getClass())) {
                List innerList = (List) list;
                for (Object s :innerList) {
                    System.out.println(s);
                }
            }
        });
    }

    private static void mapTest(ExpressionParser parser) {
        Person person = new Person();
        Map<String, City> myCity = new HashMap<>();
        person.myCity = myCity;
        City city1 = new City("cityName1");
        City city2 = new City("cityName2");
        City city3 = new City("cityName3");
        myCity.put("city1", city1);
        myCity.put("city2", city2);
        myCity.put("city3", city3);

        String city = parser.parseExpression("myCity['city2'].name").getValue(person, String.class);
        System.out.println(city);

        parser.parseExpression("myCity['city2'].name").setValue(person, "hello");

        city = parser.parseExpression("myCity['city2'].name").getValue(person, String.class);
        System.out.println(city);
    }


    private static void arraysTest(ExpressionParser parser) {
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        Tesla tesla = new Tesla();
        tesla.strs = new String[]{"h1", "h2", "h3"};
        tesla.ieee = Arrays.asList("l1", "l2", "l3");

        String str = parser.parseExpression("strs[1]").getValue(context, tesla, String.class);
        System.out.println(str);

        String list1 = parser.parseExpression("ieee[0]").getValue(context, tesla, String.class);
        System.out.println(list1);

    }

    static class Tesla {

        private String[] strs;

        private List ieee;

        public List getIeee() {
            return ieee;
        }

        public String[] getStrs() {
            return strs;
        }
    }


    private static void propertiesTest(ExpressionParser parser) {
        Person person = new Person();
        BirthDate birthDate = new BirthDate();
        person.birthDate = birthDate;
        birthDate.year = 2021;
        Person.PlaceOfBirth placeOfBirth = new Person.PlaceOfBirth();
        placeOfBirth.city = "BEIJING";
        person.placeOfBirth = placeOfBirth;

        int year = (Integer) parser.parseExpression("birthDate.year + 10").getValue(person);
        System.out.println(year);

        String city = (String) parser.parseExpression("getPlaceOfBirth().getCity()").getValue(person);
        System.out.println(city);

        System.out.println("--------------------------");
    }

    private static void textTest(ExpressionParser parser) {
        String hello = parser.parseExpression("'Hello world'").getValue(String.class);
        System.out.println(hello);

        double number = parser.parseExpression("6.0221415E+23").getValue(Double.class);
        System.out.println(number);

        Integer maxValue = parser.parseExpression("0x7FFFFFFF").getValue(Integer.class);
        System.out.println(maxValue);

        Boolean aTrue = parser.parseExpression("true").getValue(Boolean.class);
        System.out.println(aTrue);

        Object aNull = parser.parseExpression("null").getValue();
        System.out.println(aNull);
    }

    static class Person {
        private BirthDate birthDate;

        private PlaceOfBirth placeOfBirth;

        private Map<String, City> myCity;


        public Map<String, City> getMyCity() {
            return myCity;
        }

        public BirthDate getBirthDate() {
            return birthDate;
        }

        public PlaceOfBirth getPlaceOfBirth() {
            return placeOfBirth;
        }

        static class PlaceOfBirth {
            private String city;

            public String getCity() {
                return city;
            }
        }
    }

    static class City {
        private String name;

        public City(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class BirthDate {
        private int year;

        public int getYear() {
            return year;
        }
    }

}
