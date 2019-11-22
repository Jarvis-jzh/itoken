package person.jzh.itoken.common.web.components.datatables;

import lombok.Data;
import lombok.EqualsAndHashCode;
import person.jzh.itoken.common.dto.BaseResult;

import java.io.Serializable;

/**
 * @author jzh
 * @date 2019/10/24 10:38
 * @description Datatables 结果集
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DataTablesResult extends BaseResult implements Serializable {

    private int draw;

    private int recordsTotal;

    private int recordsFiltered;

    private String error;
}
