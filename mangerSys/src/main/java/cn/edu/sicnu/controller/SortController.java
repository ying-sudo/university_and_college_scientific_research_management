package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.Sort;
import cn.edu.sicnu.service.SortService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sort)表控制层
 *
 * @author makejava
 * @since 2020-11-20 22:47:33
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("sort")
public class SortController {
    /**
     * 服务对象
     */
    @Resource
    private SortService sortService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sort selectOne(String id) {
        return this.sortService.queryById(id);
    }

    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @GetMapping("findAll")
    public String findAll() {
        String re="{\"resultCode\": \"0\",\"resultMsg\": \"成功\",\"data\":{";

        List<Sort> sorts = sortService.selectByNote("1");
        re+="\"firstDiscipline\":[";
        for(int i=0;i<sorts.size();i++){
            if(i==sorts.size()-1){
                re+="\""+sorts.get(i).getValue()+"\"],";
            }else{
                re+="\""+sorts.get(i).getValue()+"\",";
            }
        }

        List<Sort> sorts1 = sortService.selectByNote("2");
        re+="\"level\":[";
        for(int i=0;i<sorts1.size();i++){
            if(i==sorts1.size()-1){
                re+="\""+sorts1.get(i).getValue()+"\"],";
            }else{
                re+="\""+sorts1.get(i).getValue()+"\",";
            }
        }

        List<Sort> sorts2 = sortService.selectByNote("3");
        re+="\"sort\":[";
        for(int i=0;i<sorts2.size();i++){
            if(i==sorts2.size()-1){
                re+="\""+sorts2.get(i).getValue()+"\"]";
            }else{
                re+="\""+sorts2.get(i).getValue()+"\",";
            }
        }
        re+="}}";
        return re;
    }

}