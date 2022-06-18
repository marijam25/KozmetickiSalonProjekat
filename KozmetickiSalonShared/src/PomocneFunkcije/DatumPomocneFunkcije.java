/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PomocneFunkcije;

import java.text.SimpleDateFormat;

/**
 *
 * @author milic
 */
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
}
