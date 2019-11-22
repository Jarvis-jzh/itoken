package person.jzh.itoken.common.config;

import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import net.sf.jsqlparser.statement.delete.Delete;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import person.jzh.itoken.common.interceptor.PageSettingCacheInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jzh
 * @date 2019/10/21 17:40
 * @description MybatisPlus 插件配置
 */
@Configuration
@MapperScan("person.jzh.itoken.**.mapper.**")
public class MybatisPlusConfig {

    /**
     * mybatis-plus 分页插件
     * 文档：http://mp.baomidou.com
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        List<ISqlParser> sqlParserList = new ArrayList<>();
//        // 攻击 SQL 阻断解析器、加入解析链
//        sqlParserList.add(new BlockAttackSqlParser() {
//            @Override
//            public void processDelete(Delete delete) {
//                // 如果你想自定义做点什么，可以重写父类方法像这样子
//                if ("user".equals(delete.getTable().getName())) {
//                    // 自定义跳过某个表，其他关联表可以调用 delete.getTables() 判断
//                    return ;
//                }
//                super.processDelete(delete);
//            }
//        });
//        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

    /**
     * mybatis-plus 乐观锁插件
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 逻辑删除
     *
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new DefaultSqlInjector();
    }

    /**
     * mybatis-plus 分页查询拦截器
     *
     * @return
     */
    @Bean
    public PageSettingCacheInterceptor pageSettingCacheInterceptor(){
        return new PageSettingCacheInterceptor();
    }

}
