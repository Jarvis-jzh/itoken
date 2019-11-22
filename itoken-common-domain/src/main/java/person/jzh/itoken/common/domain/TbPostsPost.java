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

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_posts_post")
public class TbPostsPost extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -126358104319736717L;

    /**
     * 文章编码
     */
    @TableId(value = "post_guid", type = IdType.UUID)
    private String postGuid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章发布时间
     */
    @TableField(value = "time_published")
    private Date timePublished;

    /**
     * 文章状态（0草稿 1已发布的文章 2待审核的文章 3被拒绝文章 4定时发布的文章）
     */
    private Integer status;

    /**
     * 文章别名
     */
    private String alias;

    /**
     * 文章得分
     */
    private Short score;

    /**
     * 被赞数
     */
    @TableField(value = "number_of_upvotes")
    private Integer numberOfUpvotes;

    /**
     * 被踩数
     */
    @TableField(value = "number_of_downvotes")
    private Integer numberOfDownvotes;

    /**
     * 被阅读数
     */
    @TableField(value = "number_of_reads")
    private Integer numberOfReads;

    /**
     * 被分享数
     */
    @TableField(value = "number_of_shares")
    private Integer numberOfShares;

    /**
     * 被收藏数
     */
    @TableField(value = "number_of_bookmarks")
    private Integer numberOfBookmarks;

    /**
     * 被评论数
     */
    @TableField(value = "number_of_comments")
    private Integer numberOfComments;

    /**
     * 文章审核被拒理由
     */
    @TableField(value = "reject_msg")
    private String rejectMsg;

    /**
     * 文章的阅读权限（0无限制 1会员）
     */
    private String access;

    /**
     * 文章摘要
     */
    private String summary;

    /**
     * 文章正文
     */
    private String main;

    /**
     * 文章作者对象
     */
    private String authors;

    /**
     * 封面缩略图片
     */
    @TableField(value = "thumb_image")
    private String thumbImage;

    /**
     * 裁剪后不带尺寸的正文图片数组
     */
    @TableField(value = "original_images")
    private String originalImages;

    /**
     * 裁剪后带尺寸的正文图片数组
     */
    private String images;

    /**
     * 裁剪前的正文图片数组
     */
    @TableField(value = "full_size_images")
    private String fullSizeImages;

    /**
     * 文章标签
     */
    private String tags;

    /**
     * 文章特色标签
     */
    @TableField(value = "v_tags")
    private String vTags;

    /**
     * 一篇文章的系列集合
     */
    private String series;
}