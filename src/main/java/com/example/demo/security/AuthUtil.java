package com.example.demo.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class AuthUtil {
    // Header 정보를 날릴때 jwt 형식의 데이터를 날려서 식별할 수 있게 해야한다.
    public static long getUserNo(String header) throws Exception {
        String token = header.substring(7);

        byte[] signingKey = SecurityConstants;

        // parsedToken은 아래의 subject까지 포함하여 디코딩된 데이터를 얻는다.
        Jws<Claims> parsedToken = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token);

        String subject = parsedToken.getBody().getSubject();

        long userNo = Integer.parseInt(subject);

        return userNo;
    }
}
