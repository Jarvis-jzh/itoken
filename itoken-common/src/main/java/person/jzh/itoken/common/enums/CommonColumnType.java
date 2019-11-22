package person.jzh.itoken.common.enums;

import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

/**
 * @author jzh
 * @date 2019/10/21 16:27
 * @description mybatis-plus 类型转换枚举类
 */
public enum CommonColumnType implements IColumnType {
    DATE_Util("Date", "java.utils.Date"),;

    /**
     * 类型
     */
    private final String type;

    /**
     * 包路径
     */
    private final String pkg;

    CommonColumnType(final String type, final String pkg) {
        this.type = type;
        this.pkg = pkg;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getPkg() {
        return pkg;
    }
}
