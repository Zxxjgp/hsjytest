package com.springmvc.controller;

import com.springmvc.pojo.Hospital;
import com.springmvc.service.HospitalService;
import com.springmvc.utils.MakeUUID;
import com.springmvc.utils.PageBean;
import com.springmvc.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2018.4.22
 * @author jgp
 */
@Controller
@RequestMapping(value = "hospital")
public class HospitalController {
    @Resource
    private HospitalService hospitalService;
    @Resource
    private HttpServletRequest request;

    @RequestMapping(value = "findalllist")
    public String list(@RequestParam(value="page",required=false)String page, @RequestParam(value="rows",required=false)String rows, HttpServletResponse response) throws Exception {
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map=new HashMap <String,Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Hospital> linkList=hospitalService.findalllist(map);
        Long total=hospitalService.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(linkList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }
    @RequestMapping(value = "adds")
    public String addhospital(Hospital hospital , HttpServletResponse response) throws  Exception{
        // 操作的记录条数
        int resultTotal=0;
        hospital.setState("1");
        if(hospital.getId()==null){

            hospital.setId(MakeUUID.makerandomuuid());
            resultTotal=hospitalService.add(hospital);
        }else{
            hospital.setId(request.getParameter("id"));
            resultTotal=hospitalService.update(hospital);
        }
        JSONObject result=new JSONObject();
        if(resultTotal>0){
            result.put("success", true);
        }else{
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return  null;
    }
    @RequestMapping(value = "delete")
    public String deletehospital(@RequestParam(value="ids")String ids, HttpServletResponse response) throws  Exception{
        String []idsStr=ids.split(",");
        for(int i=0;i<idsStr.length;i++){
            hospitalService.delete(idsStr[i]);
        }
        JSONObject result=new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping(value = "searchhospital")
    @ResponseBody
    public  Map<String, Object>  searchhospital(HttpServletResponse response, Model model){
        String userName=request.getParameter("hospitalNames");
        List<Hospital> blogger=hospitalService.searchhospital(userName);
        Map<String, Object> result=new HashMap<>();
        if(blogger.size() == 0){
            result.put("success", false);
        }else{
            result.put("success", true);
        }
        result.put("list", blogger);
        return result;
    }

    @RequestMapping(value = "pagejump")
    public ModelAndView pagejumphospital(){
        ModelAndView mv= new ModelAndView("/manager/serhospitalreult");
        String userName = request.getParameter("hospitallists");
        List<Hospital> hospitallist=hospitalService.searchhospital(userName);
        mv.addObject("hospitallist",hospitallist);
        return mv;
    }

    @RequestMapping(value = "sec")
    @ResponseBody
    public List<Hospital> sec(){
        String str= request.getParameter("q");
        return hospitalService.searchhospital(str);
    }
}