package info.tourkorea.token;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

import static info.tourkorea.token.DateUtil.*;

public class JwtTokenUtils {

    private static SecretKey key = Jwts.SIG.HS512.key().build();

    public static String generateAccessToken() {

        Date oneHourAfter = generateHoursAfterDate(1);

        return Jwts.builder()
                .subject("Bob") // JSON Claims
                .expiration(oneHourAfter)
                .signWith(key)
                .compact();
    }

    public static String generateAccessTokenWithSecondsParameter(int seconds) {

        Date secondsAfter = generateSecondsAfterDate(seconds);

        return Jwts.builder()
                .subject("Bob") // JSON Claims
                .expiration(secondsAfter)
                .signWith(key)
                .compact();
    }

    public static String generateRefreshToken() {
        Date threeMonthsAfter = generateDaysAfterDate(90);

        return Jwts.builder()
                .subject("Bob") // JSON Claims
                .expiration(threeMonthsAfter)
                .signWith(key)
                .compact();
    }

    public static void validate(String token) {
        try {
            Jwt<?, ?> parse = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
        } catch (ExpiredJwtException e) {
            throw ExpiredJwtException();
        } catch (JwtException e) {

        }
    }
}
