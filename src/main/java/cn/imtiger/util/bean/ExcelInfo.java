package cn.imtiger.util.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Excel��񵼳�����
 * @author shen_hongtai
 * @date 2019-7-13
 */
public class ExcelInfo implements Serializable {
    private static final long serialVersionUID = 4444017239100620999L;

    // ��ͷ
    private List<String> titles;
    
    // �п�
    private List<Integer> columnsWidth;

    // ����
    private List<List<Object>> rows;

    // ҳǩ����
    private String name;

    public List<Integer> getColumnsWidth() {
		return columnsWidth;
	}

	public void setColumnsWidth(List<Integer> columnsWidth) {
		this.columnsWidth = columnsWidth;
	}

	public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<List<Object>> getRows() {
        return rows;
    }

    public void setRows(List<List<Object>> rows) {
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
