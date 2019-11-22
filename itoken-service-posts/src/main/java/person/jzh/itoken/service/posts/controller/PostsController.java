package person.jzh.itoken.service.posts.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.jzh.itoken.common.domain.TbPostsPost;
import person.jzh.itoken.common.dto.BaseResult;
import person.jzh.itoken.common.utils.MapperUtils;
import person.jzh.itoken.service.posts.service.PostsService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author jzh
 * @date 2019/10/18 8:38
 * @description
 */
@RestController
@RequestMapping(value = "v1/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    /**
     * 根据 ID 获取文章
     *
     * @param postGuid
     * @return
     */
    @RequestMapping(value = "/id/{postGuid}", method = RequestMethod.GET)
    public BaseResult get(@PathVariable(value = "postGuid") String postGuid) {
        TbPostsPost tbPostsPost = new TbPostsPost();
        tbPostsPost.setPostGuid(postGuid);
        TbPostsPost obj = postsService.selectOne(tbPostsPost);
        return BaseResult.ok(obj);
    }

    /**
     * 保存文章
     *
     * @param tbPostsPostJson
     * @param optsBy
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public BaseResult save(
            @RequestParam("tbPostsPostJson") String tbPostsPostJson,
            @RequestParam("optsBy") String optsBy) throws Exception {
        int result = 0;

        TbPostsPost tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson, TbPostsPost.class);

        if (tbPostsPost != null) {
            // 新增
            if (StringUtils.isBlank(tbPostsPost.getPostGuid())) {
                // 初始化
//                tbPostsPost.setPostGuid(UUID.randomUUID().toString());
                tbPostsPost.setTimePublished(new Date());
                tbPostsPost.setStatus(2);
                tbPostsPost.setCreateBy(optsBy);
                tbPostsPost.setUpdateBy(optsBy);
                result = postsService.insert(tbPostsPost);
            }
            // 修改
            else {
                tbPostsPost.setUpdateBy(optsBy);
                result = postsService.update(tbPostsPost);
            }
        }

        if (result > 0) {
            return BaseResult.ok("保存文章成功");
        }

        return BaseResult.ok("保存文章失败");
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param tbPostsPostJson
     * @return
     */
    @ApiOperation(value = "文章服务查询分页接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "tbPostsPostJson", value = "对象 JSON 格式", required = false, dataTypeClass = String.class, paramType = "json")
    })
    @RequestMapping(value = "page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public BaseResult page(
            @PathVariable(required = true) int pageNum,
            @PathVariable(required = true) int pageSize,
            @RequestParam(required = false) String tbPostsPostJson
    ) throws Exception {
        TbPostsPost tbPostsPost = null;
        if (tbPostsPostJson != null) {
            tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson, TbPostsPost.class);
        }

        IPage iPage = postsService.page(pageNum, pageSize, tbPostsPost);


        // 分页后的结果集
        List<TbPostsPost> list = iPage.getRecords();

        // 封装 Cursor 对象
        BaseResult.Cursor cursor = new BaseResult.Cursor();
        cursor.setTotal(new Long(iPage.getTotal()).intValue());
        cursor.setOffset(new Long(iPage.getCurrent()).intValue());
        cursor.setLimit(new Long(iPage.getSize()).intValue());

        return BaseResult.ok(list, cursor);
    }

//    @RequestMapping(value = "list", method = RequestMethod.GET)
//    public BaseResult list(){
//        List<TbPostsPost> list = postsService.list();
//        return BaseResult.ok(list);
//    }
}
