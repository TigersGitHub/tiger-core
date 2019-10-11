package cn.imtiger.util.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * XML����
 * @author ShenHongtai
 * @date 2019-7-13
 */
public class XMLUtil {
	/**
	 * XMLת��ΪJSON
	 * @param xml
	 * @return com.alibaba.fastjson.JSONObject
	 * @throws DocumentException
	 */
	public static JSONObject parseJSON(String xml) throws DocumentException {
		return (JSONObject) JSON.toJSON(parseMap(xml));
	}
	
	/**
	 * XMLת��ΪMap
	 * @param xml
	 * @return java.util.Map
	 * @throws DocumentException
	 */
	public static Map<String, Object> parseMap(String xml) throws DocumentException {
		// XMLת��doc����
		Document doc = DocumentHelper.parseText(xml);
		// ��ȡ��Ԫ�أ�׼���ݹ�������XML��
		Element root = doc.getRootElement();
		Map<String, Object> map = new HashMap<>();
		map.put(root.getName(), getValue(root));
		return map;
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Object> getValue(Element root) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (root.elements() != null) {
			// �����ǰ���ڵ����ӽڵ㣬�ҵ��ӽڵ�
			List<Element> list = root.elements();
			// ����ÿ���ڵ�
			for (Element e : list) {
				if (e.elements().size() > 0) {
					// ��ǰ�ڵ㲻Ϊ�գ��ݹ�����ӽڵ�
					Map<String, Object> childMap = getValue(e);
					// ���븸�ڵ�map
					putAllowDuplicate(map, e.getName(), childMap);
				}
				if (e.elements().size() == 0) {
					// ���ΪҶ�ӽڵ㣬��ôֱ�Ӱ�ֵ���븸�ڵ�map
					putAllowDuplicate(map, e.getName(), e.getTextTrim());
				}
			}
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	private static void putAllowDuplicate(Map<String, Object> map, String childName, Object child) {
		// �жϷ����key�Ƿ����
		if (map.containsKey(childName)) {
			// �ж��Ѵ��ڵĶ����Ƿ�ΪList
			Object existChild = map.get(childName);
			if (existChild instanceof List) {
				// ����ԭ��List
				((List<Object>) existChild).add(child);
			} else if (existChild instanceof Map) {
				// �����ж���תΪList
				List<Object> childList = new ArrayList<>();
				childList.add(existChild);
				childList.add(child);
				map.put(childName, childList);
			}
		} else {
			map.put(childName, child);
		}
	}
}
