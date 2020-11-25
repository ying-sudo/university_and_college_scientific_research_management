package cn.edu.sicnu.controller;

import cn.edu.sicnu.entity.CharactersRight;
import cn.edu.sicnu.entity.RightsAndcharacters;
import cn.edu.sicnu.service.CharactersRightService;
import cn.edu.sicnu.service.RightsService;
import cn.edu.sicnu.service.UserCharacterService;
import cn.edu.sicnu.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class getRights {

    public getRights() {
    }

    @Resource
    private UserCharacterService userCharacterService;

    @Resource
    private UserService userService;

    @Resource
    private RightsService rightsService;

    @Resource
    private CharactersRightService charactersRightService;

    public String getRightsByCharacters(String id){
        Integer rowPosition=0; //横向递增
        Integer columnPosition=1; //纵向递增
        Integer temp; //暂存
        RightsAndcharacters r1;
        RightsAndcharacters r2;
        String Sumt="{\"headerLists\": [";
        List<RightsAndcharacters> rights = charactersRightService.getRights(userCharacterService.queryByuserId(id).getCharacterId());
        temp=rights.get(0).getAbscissa();
        rights.forEach(i-> System.out.println("i = " + i.toString()));
        for (int s=0;s<rights.size();s++) {
            if(s==rights.size()-1){
                if(rights.get(s).getOrdinate()==1){
                    Sumt+="{\"id\":"+rights.get(s).getId()+",\"index\":"+"\""+columnPosition.toString()+"\""+",\"title\":"+"\""+rights.get(s).getName()+"\""+",\"urlPath\":"+"\""+rights.get(s).getUrlPath()+"\""+",\"subMenu\":\"null\"}";
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
        return "\"data\":"+Sumt;
//        System.out.println("Sumt = " + Sumt);
//        return Sumt;
    }

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
}
