package base;

import org.apache.commons.codec.binary.Base64;

public class Test {
	public static void main(String[] args) {
		String msg="Welcome To INDIA";

		byte[] input=msg.getBytes();

		byte[] out=Base64.encodeBase64(input);

		String encodedOutput=new String(out);

		System.out.println(encodedOutput);


		//again Decoding
		input=encodedOutput.getBytes();

		out=Base64.decodeBase64(input);

		String decodedOutput=new String(out);

		System.out.println(decodedOutput);

	}

}
