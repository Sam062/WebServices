package base;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class DemoApp {
	public static void main1(String[] args) {

		String secretKey="SAM-KEY-2612";
		String token=Jwts.builder().setId("101-ID")
				.setSubject("AMAZON IND.")
				.setIssuer("PHONE PAY IND.")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1)))
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secretKey.getBytes()))
				.compact();

		System.out.println(token);
		System.out.println("---------- CLAIMS BELOW --------------");

		Claims claim=Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(secretKey.getBytes()))
				.parseClaimsJws(token)
				.getBody();
		System.out.println(claim.getId());
		System.out.println(claim.getSubject());
	}
	public static void main(String[] args) {

		JWTUtil j=new JWTUtil();

		String token=j.generateToken("SAM-ID-2612", "AMAZON IND.");
		System.out.println(token);
		System.out.println("-------------------------");

		Claims claims=j.getClaim(token);
		System.out.println(claims);
		System.out.println(claims.getId());
		System.out.println(claims.getSubject());
		System.out.println(claims.getIssuer());
		System.out.println(claims.getIssuedAt());
		System.out.println(claims.getExpiration());

		System.out.println("-----------------------------");

		String subject=j.getSubject(token);
		System.out.println(subject);


	}

}
