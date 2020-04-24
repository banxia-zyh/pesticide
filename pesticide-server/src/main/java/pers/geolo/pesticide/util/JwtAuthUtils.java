package pers.geolo.pesticide.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.UUID;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/13
 */
public class JwtAuthUtils {

    private static String secret = UUID.randomUUID().toString();

    public static String createToken(int userId, long expireTime) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expireTime);
        String token = JWT.create()
                .withClaim("userId", userId)
                .withIssuedAt(nowDate)
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    public static int parseId(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT jwt = verifier.verify(token);
        int userId = jwt.getClaim("userId").asInt();
        return userId;
    }
}
