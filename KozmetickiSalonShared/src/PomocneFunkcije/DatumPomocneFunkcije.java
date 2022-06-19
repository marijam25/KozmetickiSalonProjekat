package PomocneFunkcije;

import java.text.SimpleDateFormat;

public class DatumPomocneFunkcije {
    public static String format = "dd.MM.yyyy hh:mm";
    public static SimpleDateFormat sdf = new SimpleDateFormat(format);
    
    public static java.util.Date SQLDateUUtilDate(java.sql.Date datumSql) {
        java.util.Date datumUtil = new java.util.Date(datumSql.getTime());
        return datumUtil;
    }

    public static java.sql.Date UtilDateUSQLDate(java.util.Date datumUtil) {
        java.sql.Date datumSql = new java.sql.Date(datumUtil.getTime());
        return datumSql;
    }
    
    public static String UtilDateUString(java.util.Date datumUtil){
        String strDate = sdf.format(datumUtil); 
        return strDate;
    }
    
    public static String UtilDateUSQLString(java.util.Date datumUtil){
        SimpleDateFormat sqlSdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sqlSdf.format(datumUtil);
    }
}
