package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.springmvc.pojo.DiseaseType;
import com.springmvc.pojo.Person;
import com.springmvc.pojo.Test;
import com.springmvc.service.DiseaseTypeService;
import com.springmvc.service.PersonService;
import com.springmvc.service.TestService;
import com.springmvc.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Resource
    private HttpServletRequest request;

    @Resource
    private PersonService personService;

    @Autowired
    private TestService testService;

    @Resource
    private DiseaseTypeService  diseaseTypeService;


    @Resource
    private RedisDao redisDao;

    @RequestMapping("listda")
    @ResponseBody
    public List<Test> gt(){
        return testService.listDa();
    }


    @RequestMapping(value = "/inde")
    public String find(Model model){
        System.out.println("123");
        model.addAttribute("ty","4545");
        return "page/he";
    }

    @RequestMapping(value = "list")
    public @ResponseBody Object getList(@RequestParam(value = "id",defaultValue = "1") int id){

        PageHelper.startPage(1 , 5);
        List<Test> list=testService.find();
        Page<Test> page=new Page <Test>(list);
        return page;

    }

    @RequestMapping(value = "save")
    public String save (Model model,Test test){
       String summary=test.getUsername();
       String title=test.getPassword();
       int insertlist=testService.insertlist(test);
       List<Test> list=testService.find();
       model.addAttribute("list",list);
       return  "page/success";
    }

    @RequestMapping(value = "selectid")
    @ResponseBody
    public String selectid(HttpServletResponse response) throws  Exception{
        String selectid=request.getParameter("selectid");
        System.out.println(selectid);
        request.getRequestDispatcher("/WEB-INF/page/list.jsp").forward(request,response);
        return  selectid;
    }
    @ResponseBody
    @RequestMapping(value = "arraylisttset")
    public String arraylisttset(){
        String [] liststring=request.getParameterValues("datelist");
        System.out.println("数组数据的打印以+"+liststring);
        int reu=testService.listinsert(liststring);
        return "GOOD";
    }

    @RequestMapping(value = "listsert")
    public String listsert (Model model){
            List<Test> list= new ArrayList <Test>();
            Test test = new Test();
            test.setUsername("张三");
            test.setPassword("123456");
            list.add(test);
            Test test1 = new Test();
            test1.setUsername("李四");
            test1.setPassword("1234");
            list.add(test1);

            Test test2 = new Test();
            test2.setUsername("王五");
            test2.setPassword("123456789");
            list.add(test2);

            Test test3 = new Test();
            test3.setUsername("张柳");
            test3.setPassword("123456789123456789965495");
            list.add(test3);

            model.addAttribute("itest","这个是我传递过过阿里的参数列表");
            int re=testService.listsert(list);
            model.addAttribute("reults",re);
       return "page/sueecss";
    }

    @RequestMapping(value = "fileupload")
    public String fileupload(MultipartFile file , Test test) throws  Exception{
       String reult= ServerFileUploadUtil.load(file , request);
       String gg=test.getTitle();
       String hh=test.getName();
       test.setFile(reult);
       String ff=test.getFile();
        return "success";
    }

    @RequestMapping(value = "datezhujie")
    public String datezhujie(Person person,Model model){

        List<Person> list = personService.findAllList();
        String ll=request.getParameter("birthday");
        model.addAttribute("da",ll);
        model.addAttribute("listf",list);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "nulltest")
    public String nulltest(){
/*        DesensitizationNumber desensitizationNumber = new DesensitizationNumber();*/


        String phonenumber  = request.getParameter("id");
        return DesensitizationNumber.toConceal(phonenumber);
    }

   /* @RequestMapping(value = "nutest")
    public DiseaseType nutest(){
        return diseaseTypeService.testfindnull();
    }*/
   @RequestMapping(value = "redistest")
   @ResponseBody
   public String redistest(Person person,Model model){

       return redisDao.get("06bbe294f8374da0bf31546c2d24631curl");
   }
    @RequestMapping(value = "ceshi")
    @ResponseBody
    public ObjectRestResponse<Test> getinfo(){
       return new ObjectRestResponse<Test>().result(testService.finding());
    }
}
