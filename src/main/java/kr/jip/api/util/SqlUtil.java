package kr.jip.api.util;

import org.apache.commons.lang3.StringUtils;

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
}
