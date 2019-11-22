package person.jzh.itoken.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jzh
 * @since 2019-10-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_sys_user")
public class TbSysUser extends BaseDomain {

    private static final long serialVersionUID = -8004589863615691026L;

    /**
     * 用户编码
     */
    @TableId(value = "user_code", type = IdType.UUID)
    private String userCode;

    /**
     * 登录账号
     */
    @TableField("login_code")
    private String loginCode;

    /**
     * 用户昵称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 办公电话
     */
    private String phone;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 绑定的微信号
     */
    @TableField("wx_openid")
    private String wxOpenid;

    /**
     * 绑定的手机串号
     */
    @TableField("mobile_imei")
    private String mobileImei;

    /**
     * 用户类型
     */
    @TableField("user_type")
    private String userType;

    /**
     * 用户类型引用编号
     */
    @TableField("ref_code")
    private String refCode;

    /**
     * 用户类型引用姓名
     */
    @TableField("ref_name")
    private String refName;

    /**
     * 管理员类型（0非管理员 1系统管理员  2二级管理员）
     */
    @TableField("mgr_type")
    private String mgrType;

    /**
     * 密码安全级别（0初始 1很弱 2弱 3安全 4很安全）
     */
    @TableField("pwd_security_level")
    private Short pwdSecurityLevel;

    /**
     * 密码最后更新时间
     */
    @TableField("pwd_update_date")
    private Date pwdUpdateDate;

    /**
     * 密码修改记录
     */
    @TableField("pwd_update_record")
    private String pwdUpdateRecord;

    /**
     * 密保问题
     */
    @TableField("pwd_question")
    private String pwdQuestion;

    /**
     * 密保问题答案
     */
    @TableField("pwd_question_answer")
    private String pwdQuestionAnswer;

    /**
     * 密保问题2
     */
    @TableField("pwd_question_2")
    private String pwdQuestion2;

    /**
     * 密保问题答案2
     */
    @TableField("pwd_question_answer_2")
    private String pwdQuestionAnswer2;

    /**
     * 密保问题3
     */
    @TableField("pwd_question_3")
    private String pwdQuestion3;

    /**
     * 密保问题答案3
     */
    @TableField("pwd_question_answer_3")
    private String pwdQuestionAnswer3;

    /**
     * 密码问题修改时间
     */
    @TableField("pwd_quest_update_date")
    private Date pwdQuestUpdateDate;

    /**
     * 最后登陆IP
     */
    @TableField("last_login_ip")
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    @TableField("last_login_date")
    private Date lastLoginDate;

    /**
     * 冻结时间
     */
    @TableField("freeze_date")
    private Date freezeDate;

    /**
     * 冻结原因
     */
    @TableField("freeze_cause")
    private String freezeCause;

    /**
     * 用户权重（降序）
     */
    @TableField("user_weight")
    private Integer userWeight;

    /**
     * 状态（0正常 1删除 2停用 3冻结）
     */
    private String status;

    /**
     * 归属集团Code
     */
    @TableField("corp_code")
    private String corpCode;

    /**
     * 归属集团Name
     */
    @TableField("corp_name")
    private String corpName;

    @Override
    protected Serializable pkVal() {
        return this.userCode;
    }
}