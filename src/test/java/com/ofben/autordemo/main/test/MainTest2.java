package com.ofben.autordemo.main.test;

import com.ofben.autordemo.response.resp.ResultMsgEnum;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainTest2 {

    /*

    1.企业：
    高层可以不变
    中层一定是流动的

    2.5年的晋升计划：（2-3倍）

    3.职场阶段：
        初入职场：杜绝学生思维(破表：拨一下，转一下)(A -> A')
        职业发展：主动承担某一部分工作(资源：可以作为资源的一部分)
        确定方向：独当一面，或者负责一个事业线（管理：5-8人小团队）
        行业精英：有一定的行业知名度（独立名片：行业之间会谈到）

    4.职业工作年限：
        25岁-60岁=35年工龄

        ①第一个15年：添加燃料

    5.必要性与合理性
        必要性：我要带项目
        合理性：我没有带项目经验

    6.阶段性目标


    7.GZ的涨不上去的根本性原因
        大环境？
        个人工作量？
        哪些是个人原因？
        哪些是企业原因？
        当前岗位能有多少工资？

    8.如何利用5年时间：
    第一年：选对赛道：领导重视业绩增长，且有增长空间
    第二年：1年的时间，向上管理，超额完成业绩，获得领导的信任
    第三年：学会定计划，不仅自己做好，还能帮助下属做好
    第四年：精通流程管理，不仅完成目标，还能持续提升效率
    第五年：胜任中层干部，能够带领一个部门完成经营目标

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
