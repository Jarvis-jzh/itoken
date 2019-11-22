package person.jzh.itoken.common.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import person.jzh.itoken.common.domain.BaseDomain;

import java.util.List;

/**
 * @author jzh
 * @date 2019/10/21 11:06
 * @description
 */
public interface BaseService<T extends BaseDomain> {

    T selectOne(T t);

    List<T> list(T t);

    int insert(T t);

    int update(T t);

    int deleted(T t);

    IPage page(int pageNum, int pageSize, T t);
}
