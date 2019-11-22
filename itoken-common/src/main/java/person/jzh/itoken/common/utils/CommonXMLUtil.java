package person.jzh.itoken.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author jzh
 * @date 2019/10/16 9:15
 * @description 通用XML工具
 */
public class CommonXMLUtil {

    /**
     * 解析xml，返回第一级元素键值对，如果第一级元素有子节点， 则此节点的值是子节点的xml数据
     *
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Map doXMLParse(String strxml) throws JDOMException, IOException{
        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");
        if (StringUtils.isBlank(strxml)){
            return null;
        }

        Map m = new HashMap();

        InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator it = list.iterator();
        while (it.hasNext()){
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List children = e.getChildren();
            if (children.isEmpty()){
                v = e.getTextNormalize();
            }else{
                v = CommonXMLUtil.getChildrenText(children);
            }
            m.put(k, v);
        }
        in.close();
        return m;
    }

    /**
     * 获取子结点的xml
     *
     * @param children
     * @return
     */
    public static String getChildrenText(List children){
        StringBuffer sb = new StringBuffer();
        if (!children.isEmpty()){
            Iterator it = children.iterator();
            while (it.hasNext()){
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<").append(name).append(">");
                if (!list.isEmpty()){
                    sb.append(CommonXMLUtil.getChildrenText(list));
                }
                sb.append(value);
                sb.append("</").append(name).append(">");
            }
        }

        return sb.toString();
    }
}
