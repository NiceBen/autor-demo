package com.ofben.autordemo.main.test;

import com.ofben.autordemo.response.resp.ResultMsgEnum;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainTest3 {

    /*

    1.主动找领导汇报：目标，方向，得到反馈。不要让领导找到你，挤牙膏的方式。
        ①杜绝好学生态度：不要随时想着单挑
        ②对组织负责，为团队制定工作计划
        ③培养的选拔接班人
        ④作为领导者，应该有气度打破公司内的技术壁垒

    2.需求不明确，以及困难程度不同
        ①给领导选择题

    3.问题类型：
        ①2个星期，评价公司部门内的所有人员，对于项目是否有利
        ②资源类：人和物

    4.争取资源：
        ①不管什么样的领导，你都要主动争取资源
        ②资源永远是稀缺的，在优秀的上司，都不可能每次都满足你的需求
        ③跟坦诚相比，更重要的时机和方式
        ④争取资源师正式沟通，一定要有理有据

    5.决策没有对错，只是有不同的成果
        ①不要等到老了之后，再后悔年轻的时候没有努力

    6.上司的需求是什么？
        ①获得上级认可
        ②持续完成上级交代的目标
        ③实现更低的管理成本
        ④被下属尊重和信任

    7.表达不同意见四个误区：
        ①太看重立场，忽略了目标
        ②只反馈问题，没有解决方案
        ③总想证明自己比上司强
        ④总想拯救自己的上司

    8.话术：
        争取资源要做的准备：明确下一步
        领导，根据目前的差距，我是这么打算的：
        首先，我们识别到客户需求里面，有两个需求是客户正常情况下用不到的。
        这一点跟客户的业务人员进行了确认。所以我们打算跟客户谈暂时先不做这两个需求。
        另外，为了保证进度，我这边需求额外的一个资源加入团队，以保证在DL之前完成工作。
        同时，我们也准备好了新人的培训计划，能够保证新加入的资源在短期内，即可胜任项目工作。






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
