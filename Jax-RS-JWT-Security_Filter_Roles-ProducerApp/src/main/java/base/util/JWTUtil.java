package base.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	private static String secret="SAM-1997-MCA-SEC";

	public static String generateToken(String id,String subject) {

		String token=Jwts.builder()
				.setId(id)
				.setSubject(subject)
				.setIssuer("NITS HYD.")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5)))
				.signWith(SignatureAlgorithm.HS256, Base64.encodeBase64(secret.getBytes()))
				.compact();

		return token;
	}

	public static Claims getClaims(String token) {
		Claims claim=Jwts.parser()
				.setSigningKey(Base64.encodeBase64(secret.getBytes()))
				.parseClaimsJws(token)
				.getBody();

		return claim;
	}

	public static String getSubject(String token) {
		return getClaims(token).getSubject();
	}

	public static String getId(String token) {
		return getClaims(token).getId();
	}

}
