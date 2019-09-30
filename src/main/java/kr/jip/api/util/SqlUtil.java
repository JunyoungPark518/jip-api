package kr.jip.api.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlUtil {
	public static String escape(Object o){
		return StringUtils.remove(o.toString(),'\'');
	}

	public static String toField(Object o){
		return o.toString().replaceAll("([A-Z]+)","\\_$1").toUpperCase();
	}

	public static String apostrophe(Object value){ return (value instanceof String) ? "'" + value + "'" : value + ""; }

	public static String is(Object v) {	return " = " + apostrophe(v);	}

	public static String like(Object v) { return " LIKE '%" + v.toString() + "%'"; }

	public static String between(Object a, Object b) { return " BETWEEN " + apostrophe(a) + " AND " + apostrophe(b); };

	/**
	 * 다건 Insert Query
	 * @param table   입력할 테이블 명
	 * @param columns 컬럼명을 가진 String List
	 * @param values  입력할 값을 가진 Map List (Map의 key:컬럼명, value:값)
	 * @return
	 */
	public static String insert(String table, List<String> columns, List<Map> values) {
		StringBuilder sb = new StringBuilder("INSERT INTO " + table + " (");
		columns.forEach((col) ->sb.append("`" + toField(col) + "`,"));
		sb.deleteCharAt(sb.length()-1);
		sb.append(") VALUES ");
		values.forEach(row -> {
			sb.append("\n (");
			columns.forEach(col -> sb.append(apostrophe(row.get(col)) + ","));
			sb.deleteCharAt(sb.length()-1);
			sb.append("),");
		});
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	/**
	 * 단건 Insert Query
	 * @param table 입력할 테이블 명
	 * @param row   key: 컬럼명 , value: 컬럼값
	 * @return
	 */
	public static String insert(String table, Map row) {
		List<String> columns = new ArrayList<>();
		row.forEach((key, value) -> columns.add(key.toString()));
		return insert(table, columns, new ArrayList<Map>(){{ add(row); }});
	}

	/**
	 * Update Query
	 * @param table  수정할 테이블 명
	 * @param set    key: 컬럼명, value: 변경될 값
	 * @param where  수정 조건
	 * @return
	 */
	public static String update(String table, Map set, String where) {
		StringBuilder sb = new StringBuilder("UPDATE " + table + "\n");
		sb.append("SET ");
		set.forEach((key, value) -> sb.append(toField(key) + "=" + apostrophe(value) + "\n,"));
		sb.deleteCharAt(sb.length()-1);
		sb.append("\nWHERE " + where);
		return sb.toString();
	}

	/**
	 * Delete Query
	 * @param table   삭제할 테이블 명
	 * @param where   삭제 조건
	 * @return
	 */
	public static String delete(String table, String where) {
		return "DELETE FROM " + table + " WHERE " + where;
	}
}
