package com.ofben.autordemo.main.test;

import com.ofben.autordemo.response.resp.ResultMsgEnum;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainTest4 {

    /*

    一.如何理解一份工作的价值

    1.产品团队的职级：
    产品副总裁——负责整个产品部门——月薪：45k
    产品群经理——负责某个独立的产品领域——月薪：25K
    产品经理——负责某个产品/简单的产品先——月薪：14k
    产品专员——负责某个模块，RP图——月薪：10K



    二.理解薪酬的本质

    三.如何盘点个人业绩

    四.总结





     */
    public static void main(String[] args) {
        String str = "AT_220111132855449-97fa9dc9e14a46e08735de8bdebd0da4";
        System.out.println(str.length());

        List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu", null, "zhaoliu");
        List<String> collect = list.stream().filter(Objects::nonNull).collect(Collectors.toList());

        String str2 = Strings.join(list, ',');
        System.out.println(str2);
        String str3 = Strings.join(collect, ',');
        System.out.println(str3);
    }

    @Data
    static class Result<T> {

        private int code;

        private String message;

        private T data;

        private Result() {
        }

        private Result(int code, String message) {
            this.code = code;
            this.message = message;
        }

        /**
         * 成功
         */
        public static <T> Result<T> success(T data) {
            Result<T> result = new Result<>();
            result.setCode(ResultMsgEnum.SUCCESS.getCode());
            result.setMessage(ResultMsgEnum.SUCCESS.getMessage());
            result.setData(data);
            return result;
        }

        /**
         * 失败
         */
        public static <T> Result<T> error(int code, String message) {
            return new Result<>(code, message);
        }


    }
}
