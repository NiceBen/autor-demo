package com.ofben.autordemo.main.test;

import com.ofben.autordemo.response.resp.ResultMsgEnum;
import lombok.Data;

public class MainTest {

    /*
        职场思维，决定职场高度

        团队遇到绩效不足时，怎么想问题：
        黄牛思维：40%（绝大数人都是黄牛。开项目周会时，其他人没有听这个人在说什么，都在想一会我怎么说）
            业绩一般，追求稳定
            跟着干，薪资稳定上升，不主动找领导要工资。

        猎豹思维：20%
            能力突出，单打独斗
            个人能力突出，个人薪资涨幅较快

        秃鹰思维：15%
            说的比做的好听，机会到了，接不住
            学习成绩未必会好，但是喜欢展示自己，容易有下滑趋势，能力接不住领导的信任

        狮子思维：05%（几年以上，什么样规模的项目）工作履历ok之后，就能获得这种岗位
            团队作战，争取资源
            前边领着干，没有时间将自己的能力提高到突出。借助团队的力量


        =====

        做事之前先定目标：
        目标要符合“5W”原则，具体的目标才是真目标
        求其上者得其中，求其中者得其下



        计划是为了调动资源的


     */
    public static void main(String[] args) {
        String str = "AT_220111132855449-97fa9dc9e14a46e08735de8bdebd0da4";
        System.out.println(str.length());
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
