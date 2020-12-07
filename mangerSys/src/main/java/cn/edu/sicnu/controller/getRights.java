package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.CharactersRight;
import cn.edu.sicnu.entity.RightsAndcharacters;
import cn.edu.sicnu.service.CharactersRightService;
import cn.edu.sicnu.service.UserCharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class getRights {

    public getRights() {
    }

    @Resource
    private UserCharacterService userCharacterService;

    @Resource
    private CharactersRightService charactersRightService;

    @Resource
    private PlatformTransactionManager platformTransactionManager;

    @Resource
    private TransactionDefinition transactionDefinition;

    private static ThreadLocal<Map<String,Integer>> t=new ThreadLocal<>();

    /**
     * 请求用户的所有权限
     * @param id 用户id
     * @return
     */
    public String getRightsByCharacters(String id){
        Map<String,Integer> map = new HashMap<>();
//        List<Logtable> logtables = logtableService.queryAllByLimit(0, 1);
//        if(logtables.size()==0){
//            map.put("count",0);
//        }else{
//            map.replace("count",logtables.get(0).getId()+1);
//            System.out.println("map = " + map.get("count"));
//        }
//        t.set();
        Integer rowPosition=0; //横向递增
        Integer columnPosition=1; //纵向递增
        Integer temp; //暂存
        RightsAndcharacters r1;
        RightsAndcharacters r2;
        String Sumt="{\"headerLists\": [";
        System.out.println("进入");
        List<RightsAndcharacters> rights = charactersRightService.getRights(userCharacterService.queryByuserId(id).getCharacterId());
        temp=rights.get(0).getAbscissa();
        rights.forEach(i-> System.out.println("i = " + i.toString()));
        for (int s=0;s<rights.size();s++) {
            if(s==rights.size()-1){
                if(rights.get(s).getOrdinate()==1){
                    Sumt+="\"{id:\""+rights.get(s).getId()+"\",index:\""+"\""+columnPosition.toString()+"\""+",\"title\":"+"\""+rights.get(s).getName()+"\""+",\"urlPath\":"+"\""+rights.get(s).getUrlPath()+"\""+",\"subMenu\":\"null\"}";
                }else{
                    Sumt+="{\"id\":"+rights.get(s).getId()+",\"index\":"+"\""+columnPosition.toString()+"-"+rowPosition.toString()+"\""+",\"title\":"+"\""+rights.get(s).getName()+"\""+",\"urlPath\":"+"\""+rights.get(s).getUrlPath()+"\""+",\"subMenu\":\"null\"}]}";
                }
            }else{
                r1=rights.get(s);
                r2=rights.get(s+1);
                if(r1.getAbscissa()==r2.getAbscissa()){
                    if(r1.getOrdinate()==1){
                        Sumt+="{\"id\":"+r1.getId()+",\"index\":"+"\""+columnPosition.toString()+"\""+",\"title\":"+"\""+r1.getName()+"\""+",\"urlPath\":"+"\""+r1.getUrlPath()+"\""+",\"subMenu\":[";
                    }else{
                        Sumt+="{\"id\":"+r1.getId()+",\"index\":"+"\""+columnPosition.toString()+"-"+rowPosition.toString()+"\""+",\"title\":"+"\""+r1.getName()+"\""+",\"urlPath\":"+"\""+r1.getUrlPath()+"\""+",\"subMenu\":\"null\"},";
                    }
                    rowPosition++;
                }else{
                    if(r1.getOrdinate()==1){
                        Sumt+="{\"id\":"+r1.getId()+",\"index\":"+"\""+columnPosition.toString()+"\""+",\"title\":"+"\""+r1.getName()+"\""+",\"urlPath\":"+"\""+r1.getUrlPath()+"\""+",\"subMenu\":\"null\"},";
                    }else{
                        Sumt+="{\"id\":"+r1.getId()+",\"index\":"+"\""+columnPosition.toString()+"-"+rowPosition.toString()+"\""+",\"title\":"+"\""+r1.getName()+"\""+",\"urlPath\":"+"\""+r1.getUrlPath()+"\""+",\"subMenu\":\"null\"}]},";
                    }
                    columnPosition++;
                    rowPosition=0;
                }
            }
        }
        Sumt+="]}";
        System.out.println("Sumt = " + Sumt);
        return Sumt;
//        System.out.println("Sumt = " + Sumt);
//        return Sumt;
    }

    /**
     * 修改用户的权限
     * @param map
     * @return
     */
    public String updataByMap(Map<String,Object> map){
        try{
            List<String> ls=new ArrayList<String>();
            for (String s : map.keySet()) {
                ls.add(s);
            }
            boolean b = charactersRightService.deleteById(map.get(ls.get(0)).toString());
            for (Object l : (List)map.get(ls.get(1))) {
                CharactersRight charactersRight = new CharactersRight(map.get(ls.get(0)).toString(), l.toString(),"无");
                charactersRightService.insert(charactersRight);
            }
            return "修改成功";
        }catch (Exception e){
            return e.toString()+" "+"修改失败";
        }
    }
    /**
     *
     * 添加日志操作
     */
    @Transactional
    public String insertLog(){
        while (true){
            Map<String, Integer> map = t.get();
            if(map!=null){
                break;
            }else{
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        logtableService.insert(new Logtable("1","projrct","增加项目",new Date()));
//        logcolumnService.insert(new Logcolumn("1","1","All"));
//        logoperationService.insert(new Logoperation("1","1","增加","123"));
        return "";
    }
}
