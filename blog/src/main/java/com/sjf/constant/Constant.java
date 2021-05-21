package com.sjf.constant;

/**
 * 外部接口常量，如交易代码，错误代码等
 * 
 * @author GuoFeng
 */
public enum Constant {

    /**
     * 00-成功
     */
    RSP_CODE_00("00", "成功"),


    /**
     * 01-失败
     */
    RSP_CODE_01("01", "失败"),
    /**
     * 02-用户名为空
     */
    RSP_CODE_02("02", "用户名不能为空"),
    /**
     * 03-密码名为空
     */
    RSP_CODE_03("03", "密码不能为空"),
    /**
     * 04-用户未注册
     */
    RSP_CODE_04("04", "用户未注册"),
    /**
     * 96-后台系统错误
     */
    RSP_CODE_96("000096", "后台系统错误"),
    ;
    private String code;
    private String name;

    private Constant(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
