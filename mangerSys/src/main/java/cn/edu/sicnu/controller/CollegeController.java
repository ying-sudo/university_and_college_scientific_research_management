package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.College;
import cn.edu.sicnu.service.CollegeService;
import cn.edu.sicnu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (College)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:25
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("college")
public class CollegeController {
    /**
     * 服务对象
     */
    @Resource
    private CollegeService collegeService;

    @Autowired
    private Message message;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public College selectOne(String id) {
        return this.collegeService.queryById(id);
    }

    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @GetMapping("findAll")
    public Message findAll() {
        List<College> all = collegeService.findAll();
//        System.out.println(all);
//        String re="{\"resultCode\": \"0\",\"resultMsg\": \"请求成功\",\"data\":[";
//        for (int i=0;i<all.size();i++) {
//            if(all.get(i).getState()==1){
//                if(i==all.size()-1){
//                    re+="{\"id\":\""+all.get(i).getId()+"\",\"name\":\""+all.get(i).getName()+"\"}";
//                }else{
//                    re+="{\"id\":\""+all.get(i).getId()+"\",\"name\":\""+all.get(i).getName()+"\"},";
//                }
//            }
//        }
//        re+="]}";
//        System.out.println("re = " + re);

        message.setResultCode(0);
        message.setResultMsg("请求成功");
        message.setData(all);
        return message;
    }

}