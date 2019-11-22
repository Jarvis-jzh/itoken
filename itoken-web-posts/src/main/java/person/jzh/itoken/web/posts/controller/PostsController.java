package person.jzh.itoken.web.posts.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import person.jzh.itoken.common.domain.TbPostsPost;
import person.jzh.itoken.common.domain.TbSysUser;
import person.jzh.itoken.common.dto.BaseResult;
import person.jzh.itoken.common.service.PostsService;
import person.jzh.itoken.common.utils.MapperUtils;
import person.jzh.itoken.common.web.constants.WebConstants;
import person.jzh.itoken.common.web.controller.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jzh
 * @date 2019/10/24 8:58
 * @description
 */
@Controller
public class PostsController extends BaseController<TbPostsPost, PostsService> {

    @Autowired
    private PostsService postsService;

    @ModelAttribute
    public TbPostsPost tbSysUser(String postGuid) {
        TbPostsPost tbPostsPost = null;

        if (StringUtils.isBlank(postGuid)) {
            tbPostsPost = new TbPostsPost();
        } else {
            String json = postsService.get(postGuid);
            try {
                tbPostsPost = MapperUtils.json2pojo(json, TbPostsPost.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (tbPostsPost == null) {
                tbPostsPost = new TbPostsPost();
            }
        }

        return tbPostsPost;
    }

    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping(value = {"", "main"}, method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    /**
     * 跳转列表页
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     * 跳转到新增文章
     *
     * @return
     */
    @RequestMapping(value = {"form"}, method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    /**
     * 保存文章
     *
     * @param tbPostsPost
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbPostsPost tbPostsPost, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        TbSysUser admin = (TbSysUser) request.getSession().getAttribute(WebConstants.SESSION_USER);

        String tbPostsPostJson = MapperUtils.obj2json(tbPostsPost);

        String json = postsService.save(tbPostsPostJson, admin.getUserCode());

        BaseResult baseResult = MapperUtils.json2pojo(json, BaseResult.class);

        redirectAttributes.addFlashAttribute("baseResult", baseResult);
        redirectAttributes.addFlashAttribute(WebConstants.SESSION_USER, admin);

        if (baseResult.getSuccess().contains("成功")){
            return "redirect:/index";
        }
        return "redirect:/form";
    }

}
