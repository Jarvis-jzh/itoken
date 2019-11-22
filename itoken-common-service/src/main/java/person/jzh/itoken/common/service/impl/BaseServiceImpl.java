package person.jzh.itoken.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import person.jzh.itoken.common.domain.BaseDomain;
import person.jzh.itoken.common.service.BaseService;
import person.jzh.itoken.common.utils.MapperUtils;

import java.util.List;
import java.util.Map;

/**
 * @author jzh
 * @date 2019/10/21 11:09
 * @description 通用Service具体实现
 */
@Transactional(readOnly = true)
public class BaseServiceImpl<T extends BaseDomain, M extends BaseMapper<T>> extends ServiceImpl<M, T> implements BaseService<T> {

    @Override
    @SuppressWarnings("unchecked")
    public T selectOne(T t) {
        QueryWrapper wrapper = MapperUtils.objToQueryWrapper(t);
        return (T) this.baseMapper.selectOne(wrapper);
    }

    @Override
    public List<T> list(T t) {
        QueryWrapper wrapper = MapperUtils.objToQueryWrapper(t);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    @Transactional(readOnly = false)
    public int insert(T t) {
        return this.baseMapper.insert(t);
    }

    @Override
    @Transactional(readOnly = false)
    public int update(T t) {
        return this.baseMapper.updateById(t);
    }

    @Override
    @Transactional(readOnly = false)
    public int deleted(T t) {
        Map<String, Object> map = MapperUtils.objToMap(t);
        return this.baseMapper.deleteByMap(map);
    }

    @Override
    public IPage page(int pageNum, int pageSize, T t) {
        Page<T> page = new Page<>(pageNum, pageSize);
        QueryWrapper wrapper = MapperUtils.objToQueryWrapper(t);
        return this.baseMapper.selectPage(page, wrapper);
    }
}
