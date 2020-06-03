package base;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	String secretKey="SAM-KEY-2612";
	public String generateToken(String id,String subject) {


		String token=Jwts.builder()
				.setId(id)
				.setSubject(subject)
				.setIssuer("AMAZON IND.")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1)))
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secretKey.getBytes()))
				.compact();


		return token;
	}

	public Claims getClaim(String token) {
		Claims claim=Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(secretKey.getBytes()))
				.parseClaimsJws(token)
				.getBody();

		return claim;
	}
	public String getSubject(String token) {
		return getClaim(token).getSubject();
	}

}
