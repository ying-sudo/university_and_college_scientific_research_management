package cn.edu.sicnu.sercurity.utils;


import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * token相应的方法，生成token以及解码token
 */
@Component
public class TokenManger implements Serializable {
    private static String SECRECT_KEY = "ljkasdfsfggsdfgs";//jwt 加密解密密钥
    private static Long TIMEOUT = 60 * 60 * 2 * 1000L; //有效时间
    public static final String TOKEN_PREFIX = "Bearer "; //前缀
    public static final String AUTHORIZATION = "Authorization";//表头授权



    public String createToken(String username){
        String token=Jwts.builder()
                .setSubject(TOKEN_PREFIX+username)
                .setExpiration(new Date(System.currentTimeMillis()+TIMEOUT))
                .signWith(SignatureAlgorithm.HS512, SECRECT_KEY).compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    /**
     * 根据token得到用户信息
     *
     * @param token 令牌
     * @return 数据声明
     */
    public String getUserInfoFromToken(String token){
        String subject = Jwts.parser().setSigningKey(SECRECT_KEY).parseClaimsJws(token).getBody().getSubject();
        subject=subject.substring(7);
        return subject;
    }

    /**
     * 删除token
     */
    public void removeToken(String token){

    }

}