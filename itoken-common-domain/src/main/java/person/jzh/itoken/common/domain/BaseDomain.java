package person.jzh.itoken.common.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jzh
 * @date 2019/10/17 11:16
 * @description 公用实体类字段(领域模型的基类)
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseDomain extends Model<BaseDomain> implements Serializable {

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;

    /**
     * 逻辑删除（0正常 1删除）
     */
    @TableLogic
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    private Integer deleted;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 扩展 String 1
     */
    @TableField("extend_s1")
    private String extendS1;

    /**
     * 扩展 String 2
     */
    @TableField("extend_s2")
    private String extendS2;

    /**
     * 扩展 String 3
     */
    @TableField("extend_s3")
    private String extendS3;

    /**
     * 扩展 String 4
     */
    @TableField("extend_s4")
    private String extendS4;

    /**
     * 扩展 String 5
     */
    @TableField("extend_s5")
    private String extendS5;

    /**
     * 扩展 String 6
     */
    @TableField("extend_s6")
    private String extendS6;

    /**
     * 扩展 String 7
     */
    @TableField("extend_s7")
    private String extendS7;

    /**
     * 扩展 String 8
     */
    @TableField("extend_s8")
    private String extendS8;

    /**
     * 扩展 Integer 1
     */
    @TableField("extend_i1")
    private BigDecimal extendI1;

    /**
     * 扩展 Integer 2
     */
    @TableField("extend_i2")
    private BigDecimal extendI2;

    /**
     * 扩展 Integer 3
     */
    @TableField("extend_i3")
    private BigDecimal extendI3;

    /**
     * 扩展 Integer 4
     */
    @TableField("extend_i4")
    private BigDecimal extendI4;

    /**
     * 扩展 Float 1
     */
    @TableField("extend_f1")
    private BigDecimal extendF1;

    /**
     * 扩展 Float 2
     */
    @TableField("extend_f2")
    private BigDecimal extendF2;

    /**
     * 扩展 Float 3
     */
    @TableField("extend_f3")
    private BigDecimal extendF3;

    /**
     * 扩展 Float 4
     */
    @TableField("extend_f4")
    private BigDecimal extendF4;

    /**
     * 扩展 Date 1
     */
    @TableField("extend_d1")
    private Date extendD1;

    /**
     * 扩展 Date 2
     */
    @TableField("extend_d2")
    private Date extendD2;

    /**
     * 扩展 Date 3
     */
    @TableField("extend_d3")
    private Date extendD3;

    /**
     * 扩展 Date 4
     */
    @TableField("extend_d4")
    private Date extendD4;

//    @Version
//    private Integer version;
}
