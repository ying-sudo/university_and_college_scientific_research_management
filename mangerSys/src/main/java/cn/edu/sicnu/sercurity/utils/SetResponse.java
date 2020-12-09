package cn.edu.sicnu.sercurity.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * springSecurity的统一返回方法
 */
public class SetResponse {
    public static void REResponse(HttpServletResponse response,String...results)
            throws IOException, ServletException {
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String, String> map = new LinkedHashMap<>();
        int length = results.length;
        if(length==2){
            map.put("resultCode",results[0]);
            map.put("resultMsg", results[1]);
        }else if(length==3){
            map.put("resultCode",results[0]);
            map.put("resultMsg", results[1]);
            map.put("data", results[2]);
        }

        response.setContentType("Application/json;charset=UTF-8");
        Writer writer = response.getWriter();

        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string+"= " + map.get(string));
        }

        writer.write(objectMapper.writeValueAsString(map));
        writer.flush();
        writer.close();
    }

}
