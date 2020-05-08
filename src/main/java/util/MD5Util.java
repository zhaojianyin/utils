package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密url
 *
 * @author zhaojianyin
 * @date 2020-05-08 下午4:07
 */
public class MD5Util {

	private static final String SALT = "12afs。/。，";

	public static void main(String[] args) {
		int goodId = 1;
		String kuaiShouSignUrl = getKuaiShouSign(goodId + "");
		System.out.println("url : " + kuaiShouSignUrl);
		System.out.println(kuaiShou(goodId, kuaiShouSignUrl));
		goodId += 1;
		System.out.println(kuaiShou(goodId, kuaiShouSignUrl));
	}


	/**
	 * 用户在获取获取到下单URL的时候，当秒杀开启后则会得到一个md5值。通过该md5值来完成下单具体的秒杀交易:
	 * <p>
	 * MD5加密,结合秒杀的商品id与混淆字符串生成通过md5加密
	 *
	 * @param url
	 * @return
	 */
	public static String getKuaiShouSign(String url) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update((url + SALT).getBytes("UTF-8"));
			byte[] b = messageDigest.digest();

			int i;
			StringBuffer stringBuffer = new StringBuffer();
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					stringBuffer.append("0");
				}
				stringBuffer.append(Integer.toHexString(i));
			}
			url = stringBuffer.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}


	public static boolean kuaiShou(int goodId, String md5) {
		return getKuaiShouSign(goodId + "").equals(md5);
	}

}
