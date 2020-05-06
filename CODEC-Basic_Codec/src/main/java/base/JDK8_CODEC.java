package base;

import java.util.Base64;

public class JDK8_CODEC {
	public static void main(String[] args) {
		//ENCODING MSG
		String msg="Welcome to INDIA";
		byte[] b=msg.getBytes();
		Base64.Encoder en=Base64.getEncoder();
		byte[] encoded=en.encode(b);
		String encodedMsg=new String(encoded);
		System.out.println("Encoding "+msg+" ::->  "+encodedMsg);

		//USING SHORT FORM FOR ENCODING
		//		byte[] encoded1=Base64.getEncoder().encode(msg.getBytes());
		//		String msg1=new String(encoded1);
		//		System.out.println(msg1);



		//DECODING MSG
		byte[] b1=encodedMsg.getBytes();
		Base64.Decoder decoded=Base64.getDecoder();
		byte[] b2=decoded.decode(b1);
		String decodedMsg=new String(b2);
		System.out.println("Decoding "+encodedMsg+" ::->  "+decodedMsg);

		//USING SHORT FORM OF DECODING
		//		byte[] decoded1=Base64.getDecoder().decode(encodedMsg.getBytes());
		//		String msg2=new String(decoded1);
		//		System.out.println(msg2);
	}
}
