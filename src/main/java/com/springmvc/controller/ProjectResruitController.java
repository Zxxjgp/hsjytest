package com.springmvc.controller;


import com.springmvc.pojo.*;
import com.springmvc.service.*;
import com.springmvc.utils.MakeUUID;
import com.springmvc.utils.PageBean;
import com.springmvc.utils.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.Map;

/**
 * @author jgp
 * @date 2018.04.17
 */
@Controller
public class ProjectResruitController {


    @Resource
    private ProjectResruitService projectResruitService;
    @Resource
    private HttpServletRequest request;

    @Resource
    private HospitalService hospitalService;
    @Resource
    private RecruitRelationHospitalService recruitRelationHospitalService;
    @Resource
    private RegisteredUsersService registeredUsersService;

    @Resource

    private DiseaseTypeService diseaseTypeService;

    /**
     * 返回免费用药首页的全部信息和分类查询
     * @param model
     * @param projectResruit
     * @return
     */
    @RequestMapping(value = "/querylist")
    public String querylist(Model model, ProjectResruit projectResruit){

        List<ProjectResruit> projectResruitslist= projectResruitService.findList(projectResruit);
        List<DiseaseType>  diseaseTypeList=diseaseTypeService.findAllList(null);

        model.addAttribute("projectResruitslist",projectResruitslist);
        model.addAttribute("diseaseTypeList",diseaseTypeList);

        return "/freemedication";
    }

    /**
     * 招募详情
     * @param model
     * @return
     */
    @RequestMapping(value = "/resruitdetail")
    public String resruitdetail(Model model,ProjectResruit diseaseType){
        ProjectResruit projectResruit=projectResruitService.findproject(diseaseType.getId());//获得详情页面
        List<Hospital> hospital=hospitalService.findlist(projectResruit.getId());

        model.addAttribute("projectResruitslist",projectResruit);
        model.addAttribute("hospital",hospital);

        return "/projectdetail";
    }

    /**
     * 招募添加
     * @return
     */

    @RequestMapping(value = "/add")
    public String addresruit(Model model){

        return "/manager/main";
    }

    /**
     * 添加招募信息
     * @param selectlist
     * @param response
     * @param model
     * @param projectResruit
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "esruitadd")
    public String esruitadd(@RequestParam(value="selectlist")String selectlist, HttpServletResponse response, Model model, ProjectResruit projectResruit) throws Exception{
        String projectcruid = MakeUUID.makerandomuuid();
        RecruitRelationHospital recruitRelationHospital =  new RecruitRelationHospital();
        recruitRelationHospital.setRecruitId(projectcruid);
        int resultTotal=0;//记录数据

        String []idsStr=selectlist.split(",");
        for(int i=0;i<idsStr.length;i++){
            recruitRelationHospital.setHospitalId(idsStr[i]);
            resultTotal=recruitRelationHospitalService.insert(recruitRelationHospital);
        }

        projectResruit.setId(projectcruid);
        projectResruit.setRecruitTime(new Date());
        projectResruit.setState("1");

        resultTotal = projectResruitService.add(projectResruit);
        JSONObject result=new JSONObject();
        if (resultTotal < 0){
            result.put("success", false);
            ResponseUtil.write(response, result);
        }else {
            ResponseUtil.write(response, result);
        }
        return null;
    }

    /**
     * 全部的查找信息和分页查询
     * @param page
     * @param rows
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findalllist")
    public String findallist(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows, HttpServletResponse response) throws  Exception{
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List <ProjectResruit> linkList = projectResruitService.findalllist(map);
        for (ProjectResruit projectResruit: linkList) {
            if (projectResruit.getState().equals("1")){
                projectResruit.setState("已发布");
            }else {
                projectResruit.setState("未发布");
            }
        }
        Long total = projectResruitService.getTotal(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(linkList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return  null;
    }

    /**
     * 取消发布
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "delete")
    public String deletediseasetype(@RequestParam(value = "ids") String ids,@RequestParam(value = "state") String state, HttpServletResponse response) throws Exception {
        String [] idstr = ids.split(",");
        String oo=request.getParameter("state");
        if (request.getParameter("state").equals("已发布")){
            for (int i = 0; i < idstr.length; i++) {
                projectResruitService.delestate(idstr[i]);
            }
        }else {
            for (int i = 0; i < idstr.length; i++) {
                projectResruitService.addstate(idstr[i]);
            }
        }
        JSONObject result = new JSONObject();
        result.put("success",true);
        ResponseUtil.write(response, result);
        return null;
    }



    @RequestMapping(value = "searchhospital")
    @ResponseBody
    public Map<String, Object> searchhospital(HttpServletResponse response, Model model){
        String userName=request.getParameter("recruitTitle");
        List<ProjectResruit> blogger=projectResruitService.searchhospital(userName);
        Map<String, Object> result=new HashMap<>();
        if(blogger.size() == 0){
            result.put("success", false);
        }else{
            result.put("success", true);
        }
        return result;
    }
    @RequestMapping(value = "pagejump")
    public ModelAndView pagejumphospital(){
        ModelAndView mv= new ModelAndView("/manager/serprojectreult");
        String searchName=request.getParameter("recruitTitle");

        List<ProjectResruit> hospitallist=projectResruitService.searchhospital(searchName);
        mv.addObject("hospitallist",hospitallist);
        return mv;
    }

    @RequestMapping(value = "registration")
    private  String registration(Model model){
        String name=request.getParameter("recruitTitle");
        model.addAttribute("recruitTitle",name);
        return "/hospitalrecruitment/enrolmentmethod";
    }

    @RequestMapping(value="/info",method= RequestMethod.GET)
    public @ResponseBody List<Statistical> charts(HttpServletResponse response){
        int h =projectResruitService.queryall();
        ArrayList <Statistical> user= new ArrayList <>();
        Statistical statistical=new Statistical();
        statistical.setCount(String.valueOf(h));
        statistical.setNamel("招募项目人数");
        user.add(statistical);
        int pro=registeredUsersService.finds();
        Statistical statistical2=new Statistical();
        statistical2.setCount(String.valueOf(pro));
        statistical2.setNamel("注册患者人数");
        user.add(statistical2);
        return user;
    }
}
