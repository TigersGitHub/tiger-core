package cn.imtiger.util.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ���Ϲ�����
 * @author ShenHongtai
 * @date 2019-10-11
 */
public class CollectionUtil {
	/**
	 * ������Map��keyֵȫ��ת��Ϊ��д
	 * @param list
	 * @return
	 */
	public static List<Map<String, Object>> toUpperKeyMaps(List<Map<String, Object>> list) {
		List<Map<String, Object>> listNew = new ArrayList<>();
		for (Map<String, Object> map : list) {
			listNew.add(toUpperKeyMap(map));
		}
		return listNew;
	}

	/**
	 * Map��keyֵȫ��ת��Ϊ��д
	 * @param map
	 * @return
	 */
	public static Map<String, Object> toUpperKeyMap(Map<String, Object> map) {
		Map<String, Object> mapNew = new HashMap<>();
		Set<Map.Entry<String, Object>> entries = map.entrySet();
		for (Map.Entry<String, Object> entry : entries) {
			mapNew.put(entry.getKey().toUpperCase(), entry.getValue());
		}
		return mapNew;
	}

	/**
	 * ������Map��keyֵȫ��ת��ΪСд
	 * @param list
	 * @return
	 */
	public static List<Map<String, Object>> toLowerKeyMaps(List<Map<String, Object>> list) {
		List<Map<String, Object>> listNew = new ArrayList<>();
		for (Map<String, Object> map : list) {
			listNew.add(toLowerKeyMap(map));
		}
		return listNew;
	}

	/**
	 * Map��keyֵȫ��ת��ΪСд
	 * @param map
	 * @return
	 */
	public static Map<String, Object> toLowerKeyMap(Map<String, Object> map) {
		Map<String, Object> mapNew = new HashMap<>();
		Set<Map.Entry<String, Object>> entries = map.entrySet();
		for (Map.Entry<String, Object> entry : entries) {
			mapNew.put(entry.getKey().toLowerCase(), entry.getValue());
		}
		return mapNew;
	}
}
