package base;

import org.apache.commons.codec.binary.Base64;

public class TestApacheCODEC {
	public static void main(String[] args) {
		//ENCODING String msg VALUE
		String msg="Welcome To INDIA";

		byte[] input=msg.getBytes();

		byte[] out=Base64.encodeBase64(input);

		String encodedOutput=new String(out);

		System.out.println("ENCODING----------------"+msg);
		System.out.println(encodedOutput);


		//AGAIN DECODING LINE 13 encodedOutput VALUE
		input=encodedOutput.getBytes();

		out=Base64.decodeBase64(input);

		String decodedOutput=new String(out);

		System.out.println("DECODING---------------- "+encodedOutput);
		System.out.println(decodedOutput);
	}
}
