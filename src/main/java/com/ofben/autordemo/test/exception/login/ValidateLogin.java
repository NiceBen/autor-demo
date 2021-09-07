package com.ofben.autordemo.test.exception.login;

/**
 * 登录校验类
 *
 * @date 2021-09-07
 * @since 1.0.0
 */
public class ValidateLogin {

    public String login(String username, String pwd) {
        boolean loginFlag = this.validateLogin(username, pwd);
        return loginFlag ? "登录成功！" : "登录失败，请尝试从新登录！";
    }

    /**
     * 假设在某仓库管理系统的登录界面中需要输入用户名和密码，
     * 其中用户名只能由 6~10 位数字组成，密码只能有 6 位，
     * 任何不符合用户名或者密码要求的情况都视为异常，并且需要捕获并处理该异常。
     * @param username
     * @param pwd
     * @return
     */
    public boolean validateLogin(String username, String pwd) {
        // 用户名和密码是否正确
        boolean con = false;
        // 用户格式是否正确
        boolean conUname = false;

        // 校验用户名
        conUname = validateUsername(username);
        // 校验密码
        if (conUname) {
            con = validatePwd(pwd);
        }

        return con;
    }

    private boolean validatePwd(String pwd) {
        boolean checkFlag = false;
        try {
            if (pwd.length() == 6) {
                checkFlag = true;
            } else {
                throw new LoginException("密码长度必须为 6 位！");
            }
        } catch (LoginException e) {
            // 捕获 LoginException 异常
            System.out.println(e.getMessage());
        }
        return checkFlag;
    }

    private boolean validateUsername(String username) {
        boolean checkFlag = false;
        try {
            if (username.length() >= 6 && username.length() <= 10) {
                for (int i = 0; i < username.length(); i++) {
                    char ch = username.charAt(i);
                    if (ch >= '0' && ch <= '9') {
                        checkFlag = true;
                    } else {
                        checkFlag = false;
                        throw new LoginException("用户名中包含有非数字的字符！");
                    }
                }
            } else {
                // 如果用户名长度不在6~10位之间，拋出异常
                throw new LoginException("用户名长度必须在6〜10位之间！");
            }
        } catch (LoginException e) {
            // 捕获 LoginException 异常
            System.out.println(e.getMessage());
        }
        return checkFlag;
    }
}
