package com.springmvc.controller;


import com.github.pagehelper.PageInfo;
import com.springmvc.pojo.DiseaseType;
import com.springmvc.pojo.Hospital;
import com.springmvc.service.DiseaseTypeService;
import com.springmvc.service.HospitalService;
import com.springmvc.utils.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XX
 * @date 2018.4.24
 */
@Controller
@RequestMapping(value = "diseasetype")
public class DiseaseController {
    @Resource
    private DiseaseTypeService diseaseTypeService;
    @Resource
    private HttpServletRequest request;

    @RequestMapping(value = "findalllist")
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map <String, Object> map = new HashMap <String, Object>(32);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List <DiseaseType> linkList = diseaseTypeService.findalllist(map);
        Long total = diseaseTypeService.getTotal(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(linkList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     *
     * @param diseaseType
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "adds")
    public String adddiseasetype(DiseaseType diseaseType, HttpServletResponse response) throws Exception {
        int  reult = 0;
        if (diseaseType.getId() == null){
            diseaseType.setState("1");
            diseaseType.setId(MakeUUID.makerandomuuid());
            reult = diseaseTypeService.add(diseaseType);
        }else {
            diseaseType.setId(request.getParameter("id"));
            reult = diseaseTypeService.update(diseaseType);
        }
        JSONObject result = new JSONObject();
        if (reult > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping(value = "delete")
    public String deletediseasetype(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
        String[] idss = ids.split(",");
        for (int i = 0; i < idss.length ; i++ ){
            diseaseTypeService.delestate(idss[i]);
        }
        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);

        return null;
    }

    @RequestMapping(value = "pagejump")
    public String pagejumphospital(Model model){
        String diseaseName = request.getParameter("diseaseName");
        List<DiseaseType> diseasetypelist=diseaseTypeService.searchdiseasetype(diseaseName);
        model.addAttribute("diseasetypelist",diseasetypelist);
        return "/manager/serdiseasereult";
    }

    @RequestMapping(value = "searchhospital")
    @ResponseBody
    public  Map<String, Object>  searchhospital(HttpServletResponse response, Model model){
        String userName=request.getParameter("linkNames");
        List<DiseaseType> diseaseTypeList=diseaseTypeService.searchdiseasetype(userName);
        Map<String, Object> result=new HashMap<>(32);
        if(diseaseTypeList.size() == 0){
            result.put("success", false);
        }else{
            result.put("success", true);
        }
        result.put("list", diseaseTypeList);
        return result;
    }

    /**
     * 分页插件对的使用以及测试用例
     */

    @RequestMapping(value = "pageinfotest")
    public  ModelAndView pageinfotest(Params params){
        ModelAndView modelAndView = new ModelAndView();
        //一开始第一页，查询10条
        params.setPageNo(1);
        params.setPageSize(10);
        PageInfo<DiseaseType> diseaseTypePageInfo = diseaseTypeService.finds(params);

        modelAndView.addObject("page",diseaseTypePageInfo.getList());
        modelAndView.addObject("size",diseaseTypePageInfo.getTotal());
        return  modelAndView;
    }


    @ResponseBody
    public EUDataGridResult getItemList(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows, HttpServletResponse response) throws IOException {
        EUDataGridResult result=diseaseTypeService.selectAll(page, rows);
        return result;
    }
}
