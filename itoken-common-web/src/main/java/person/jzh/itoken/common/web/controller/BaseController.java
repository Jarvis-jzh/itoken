package person.jzh.itoken.common.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import person.jzh.itoken.common.domain.BaseDomain;
import person.jzh.itoken.common.utils.MapperUtils;
import person.jzh.itoken.common.web.components.datatables.DataTablesResult;
import person.jzh.itoken.common.web.service.BaseClientService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jzh
 * @date 2019/10/24 10:28
 * @description 通用的 Controller
 */
public abstract class BaseController<T extends BaseDomain, S extends BaseClientService> {

    @Autowired
    protected S service;

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public DataTablesResult page(HttpServletRequest request){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        String json = service.page(start, length, null);
        DataTablesResult dataTablesResult = null;
        try {
            dataTablesResult = MapperUtils.json2pojo(json, DataTablesResult.class);
            dataTablesResult.setDraw(dataTablesResult.getCursor().getOffset());
            dataTablesResult.setRecordsTotal(dataTablesResult.getCursor().getTotal());
            dataTablesResult.setRecordsFiltered(dataTablesResult.getCursor().getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataTablesResult;
    }
}
