package cn.edu.sicnu.sercurity.utils;

import cn.edu.sicnu.entity.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class TokenUtil implements Serializable {
    private static String SECRECT_KEY = "admins";//jwt 加密解密密钥, 暂时使用admins
    private static Long timeout = 60 * 60 * 2 * 1000L; //过期时间2小时
    public static final String TOKEN_PREFIX = "Bearer "; //前缀
    public static final String AUTHORIZATION = "Authorization";//表头授权


    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private static String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + timeout);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRECT_KEY)//签名算法
                .compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRECT_KEY).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成令牌
     *
     * @param userDetails 用户
     * @return 令牌
     */
    public static String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());

        claims.put(AUTHORIZATION, userDetails.getAuthorities());
        return TOKEN_PREFIX + generateToken(claims);
    }

    /**
     * 得到权限字符串
     */
    public static String getAuthorStr( String authority) {

        String authoryStr = "";
        String[] authorityList = StringUtils.strip(authority, "[]").split(",");
        for (String s : authorityList) {
            System.out.println(StringUtils.strip(s,"{}"));
            authoryStr = authoryStr + s + ",";
        }
        return authoryStr.substring(0, authoryStr.length() - 1);
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public static String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public static Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public static String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token       令牌
     * @param userDetails 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        Users user = (Users) userDetails;
        String username = getUsernameFromToken(token);
        return (username.equals(user.getId()) && !isTokenExpired(token));
    }

    /**
     * 从Token中获取用户角色
     */
    public static String getUseAythoritys(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRECT_KEY).parseClaimsJws(token).getBody();
        return claims.get("Authorization").toString();
    }
}