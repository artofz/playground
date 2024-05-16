package info.tourkorea.token;

import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static info.tourkorea.token.DateUtil.generateHoursAfterDate;
import static info.tourkorea.token.DateUtil.generateSecondsAfterDate;

class JwtTokenUtilsTest {

    @Test
    void validTokenTest() {
        String token = JwtTokenUtils.generateAccessToken();
        Assertions.assertDoesNotThrow(() -> JwtTokenUtils.validate(token));
    }

    @Test
    void expirationTest() throws InterruptedException {
        String token = JwtTokenUtils.generateAccessTokenWithSecondsParameter(1);
        Thread.sleep(1000);
        Assertions.assertThrows(JwtException.class, () -> JwtTokenUtils.validate(token));
    }

}