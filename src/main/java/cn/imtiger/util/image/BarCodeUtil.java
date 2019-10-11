package cn.imtiger.util.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

/**
 * �����빤����
 * @author ShenHongtai
 * @date 2019-7-13
 */
public class BarCodeUtil {
	/**
	 * ����������<br>
	 * <b>ע��</b>������Ŀ�Ȳ��ܵ���ͼƬ�Ŀ�ȣ��������������,�����������������Ӵ�offset��ֵ
	 * 
	 * @param contents
	 *            ����
	 * @param dest
	 *            ������ͼƬ��ַ
	 * @param width
	 *            ���
	 * @param height
	 *            �߶�
	 * @param offset
	 *            ƫ����
	 * @throws WriterException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void encode(String contents, String dest, int width, int height, int offset)
			throws WriterException, FileNotFoundException, IOException {

		/**
		 * Code128A�ַ��� ������д��ĸ�����֡����ñ����ź�һЩ���Ʒ��� Code128B�ַ��� ������Сд��ĸ�����֡����ñ����š�
		 * Code128C�ַ��� Ϊ���������С� Code128Auto �ǽ����������ַ�������Ż���ϡ� EAN128��������
		 * ����UPC/EANָ��������������128�룬���뷽ʽͬcode128���롣 Code39���������ַ����������� ����д��ĸ�Լ�- . $ / + % *
		 * �ո���ַ�,����"*" ֻ���ڱ�ǿ�ʼ�ͽ����� Code93���������� full ASCII ģʽ����ʹ��ASCIIȫ��128���ַ���
		 * ��°��루Codabar���������ɣ��ַ����������ֺ�- $ : /. + �Լ�ABCD���ַ��� ����ABCDֻ���ڿ�ʼ���߽�β����Ϊ��ʶ��ʹ�á�
		 * ����25�루Interleaved 2 of 5���������ɣ����������������ַ�����Ϊ�����Ҹ���Ϊż��, Ϊ�������Զ���ǰ���"0"�� Code11����
		 * ֻ����11����Ԫ���ֱ���0-9��"-",Ϊ���ͼ������ʣ���ʹ����λ�ļ����롣 MSI������ �����Ǵ�������0-9������һλ�����롣
		 * EAN13��Ʒ�����Ǵ����֣�����λ����12λ���ڱ���������һλУ���룬���13λ���֡�
		 * EAN8��Ʒ�����Ǵ����֣�����λ����7λ���ڱ���������һλУ���룬���8λ���֡�
		 * UPC-A������Ʒ�����Ǵ����֣�����λ����11λ���ڱ���������һλУ���룬 ���12λ����,��Ҫ�������ͼ��ô�ʹ�á�
		 * UPC-E������Ʒ�����Ǵ����֣�����UPC-A�������ɣ�λ����7λ��������λ����Ϊ0�� �ڱ���������һλУ���룬���8λ���֡�
		 */
		contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");
		BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.CODE_128, width - offset, height);
		// BitMatrix matrix=new MultiFormatWriter().encode(contents,
		// BarcodeFormat.EAN_13, width-offset, height);
		MatrixToImageWriter.writeToStream(matrix, "jpg", new FileOutputStream(new File(dest)));
	}

	/**
	 * ����������
	 * 
	 * @param dest
	 *            Ҫ�����ͼƬ��ַ
	 * @return String ����������
	 */
	public static String decode(String dest) throws IOException, NotFoundException {
		BufferedImage image = ImageIO.read(new File(dest));
		LuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap imageBinaryBitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result = new MultiFormatReader().decode(imageBinaryBitmap, null);
		return result.getText();
	}

	/**
	 * ��Ʒ����У��
	 * 
	 * @return String У����
	 */
	/**
	 * �������� 693 69838 0001 3 Ϊ�� ���������Ϊ4�����֣������ҷֱ�Ϊ�� 1-3λ����3λ����Ӧ�������693�����й��Ĺ��Ҵ���֮һ��
	 * ��690--695�����й���½�Ĵ��룬�ɹ����Ϸ��䣩 4-8λ����5λ����Ӧ�������69838���������������̴��룬�ɳ������룬���ҷ���
	 * 9-12λ����4λ����Ӧ�������0001�������ų�����Ʒ���룬�ɳ�������ȷ��
	 * ��13λ����1λ����Ӧ�������3����У���룬����һ�����㷨����ǰ��12λ���ּ�����õ� ����ʽ��13λ�㷨
	 * 1��ȡ������������λ�ĺͣ�c1=6+3+9+3+0+0=21�� 2��ȡ��������ż��λ�ĺͣ�c2=9+6+8+8+0+1=32��
	 * 3��������λ�ĺ��롰ż��λ�ĺ͵���������ӡ� 4��ȡ������ĸ�λ����117��117%10=7���� 5����10��ȥ�����λ����10-7=3��
	 * 6���Եõ�������ȡ��λ������10ȥ�ࣩ3%10=3 �ο���<a
	 * href="http://baike.baidu.com/view/13740.htm?fr=aladdin">�ٶȰٿ�-������
	 */
	public static String checksum(String countryCode, String factoryCode, String productCode) throws Exception {
		String temp = countryCode + factoryCode + productCode;

		if (!(isNumber(countryCode) && isNumber(factoryCode) && isNumber(productCode))) {
			throw new Exception("���ܺ��з������ַ�");
		}
		int defaultCountryCode = 3;
		if (countryCode.length() != defaultCountryCode) {
			throw new Exception("���ҵ������벻�Ϲ淶,����3λ");
		}
		int defaultFactoryCode = 5;
		if (factoryCode.length() != defaultFactoryCode) {
			throw new Exception("���̴��벻�Ϲ淶,����5λ");
		}
		int defaultProductCode = 4;
		if (productCode.length() != defaultProductCode) {
			throw new Exception("��Ʒ���벻�Ϲ淶,����4λ");
		}

		char[] code = temp.toCharArray();
		int oddSum = 0;
		int evenSum = 0;
		for (int i = 0; i < code.length; i++) {
			if ((i + 1) % 2 == 1) {
				oddSum += Integer.valueOf(code[i] + "");
			} else {
				evenSum += Integer.valueOf(code[i] + "");
			}
		}

		int digit = (10 - ((oddSum + evenSum * 3) % 10)) % 10;

		return temp + digit;
	}

	/**
	 * У������
	 * 
	 * @param number
	 *            ����
	 * @return Boolean
	 */
	public static boolean isNumber(String number) {
		if (null == number || "".equals(number)) {
			return false;
		}
		String regex = "[0-9]*";
		return number.matches(regex);
	}

	public static void main(String[] args) throws Exception {
		// ����һά��
		// BarCodeUtil.encode(checksum("695", "32321", "2133"), "D:\\Target.jpg", 300,
		// 60, 10);
		BarCodeUtil.encode("CLBX201712260001", "D:\\Target.jpg", 360, 60, 10);
		// ʶ��һά��
		System.out.println("�������:" + BarCodeUtil.decode("D:\\Target.jpg"));
	}

}
