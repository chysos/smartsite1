package com.xingyun.smartsite.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * POJO Product
 */
public class GenEntity {
    private String packagename = "com.digital.wisdom.vo";//包名
    private String authorName = "tangcb";//作者名字  
    private String tablename = "t_student";//表名
    private List<String> colNames; // 列名数组
    private List<String> colTypes; //列名类型数组
    private List<String> colComments;//列名描述
    
    private boolean f_util = false; // 是否需要导入包java.util.*
    private boolean f_sql = false; // 是否需要导入包java.sql.*
     
    //数据库连接
     private static final String URL ="jdbc:mysql://112.2.58.251:3306/dt_wisdomclassroom";
     private static final String NAME = "dtchinav2";
     private static final String PASS = "jline!@#";
     private static final String DRIVER ="com.mysql.jdbc.Driver";
 

    /*
     * 构造函数
     */
    public GenEntity(){
        //创建连接
        Connection con;
        //查要生成实体类的表
        String sql = "SELECT  COLUMN_NAME as 'colName',COLUMN_COMMENT as 'colComment',DATA_TYPE as 'colType' ,COLUMN_TYPE as 'colComment' FROM information_schema.`COLUMNS` where TABLE_NAME = '"+tablename+"'";
        PreparedStatement pStemt = null;
        try {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            con = DriverManager.getConnection(URL,NAME,PASS);
            pStemt = con.prepareStatement(sql);
            
            Statement sm=con.createStatement();
            
            ResultSet rs=sm.executeQuery(sql);
            
            colNames = new ArrayList<String>();
            colTypes = new ArrayList<String>();
            colComments = new ArrayList<String>();

            while(rs.next()) { 
            	colNames.add(rs.getString("colName"));
            	colTypes.add(rs.getString("colType"));
            	colComments.add(rs.getString("colComment"));
            	 if(rs.getString("colType").equalsIgnoreCase("datetime")){
                     f_util = true;
                 }
                 if(rs.getString("colType").equalsIgnoreCase("image") || rs.getString("colType").equalsIgnoreCase("text")){
                     f_sql = true;
                 }
            } 
            
            String content = parse();
             
            try {
                File directory = new File("");
                //System.out.println("绝对路径："+directory.getAbsolutePath());
                //System.out.println("相对路径："+directory.getCanonicalPath());
                String path=this.getClass().getResource("").getPath();
                 
                System.out.println(path);
                
                FileWriter fw = new FileWriter(directory.getAbsolutePath()+ "/src/main/java/"+this.packagename.replace(".", "/")+"/" + initcap(tablename) + ".java");
                PrintWriter pw = new PrintWriter(fw);
                pw.println(content);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
//          try {
//              con.close();
//          } catch (SQLException e) {
//              // TODO Auto-generated catch block
//              e.printStackTrace();
//          }
        }
    }
 
    /**
     * 功能：生成实体类主体代码
     * @param colnames
     * @param colTypes
     * @param colSizes
     * @return
     */
    private String parse() {
        StringBuffer sb = new StringBuffer();
        sb.append("package "+packagename+";\r\n");
        sb.append("\r\n");
        //判断是否导入工具包
        if(f_util){
            sb.append("import java.util.Date;\r\n");
        }
        if(f_sql){
            sb.append("import java.sql.*;\r\n");
        }
       
        //注释部分
        sb.append("   /**\r\n");
        sb.append("    * "+tablename+" 实体类\r\n");
        sb.append("    * "+new Date()+"  "+authorName+"\r\n");
        sb.append("    */ \r\n");
        //实体部分
        sb.append("\r\n\r\npublic class " + initcap(tablename) + "{\r\n");
        processAllAttrs(sb);//属性
        processAllMethod(sb);//get set方法
        sb.append("}\r\n");
         
        //System.out.println(sb.toString());
        return sb.toString();
    }
     
    /**
     * 功能：生成所有属性
     * @param sb
     */
    private void processAllAttrs(StringBuffer sb) {
         
        for (int i = 0; i < colNames.size(); i++) {
            sb.append("\tprivate " + sqlType2JavaType(colTypes.get(i)) + " " + colNames.get(i) + ";//"+colComments.get(i)+"\r\n");
        }
         
    }
 
    /**
     * 功能：生成所有方法
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {
         
        for (int i = 0; i < colNames.size(); i++) {
            sb.append("\tpublic void set" + initcap(colNames.get(i)) + "(" + sqlType2JavaType(colTypes.get(i)) + " " + 
                    colNames.get(i) + "){\r\n");
            sb.append("\t\tthis." + colNames.get(i) + "=" + colNames.get(i) + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\tpublic " + sqlType2JavaType(colTypes.get(i)) + " get" + initcap(colNames.get(i)) + "(){\r\n");
            sb.append("\t\treturn " + colNames.get(i) + ";\r\n");
            sb.append("\t}\r\n");
        }
         
    }
     
    /**
     * 功能：将输入字符串的首字母改成大写
     * @param str
     * @return
     */
    private String initcap(String str) {
         
        char[] ch = str.toCharArray();
        if(ch[0] >= 'a' && ch[0] <= 'z'){
            ch[0] = (char)(ch[0] - 32);
        }
         
        return new String(ch);
    }
 
    /**
     * 功能：获得列的数据类型
     * @param sqlType
     * @return
     */
    private String sqlType2JavaType(String sqlType) {
         
        if(sqlType.equalsIgnoreCase("bit")){
            return "boolean";
        }else if(sqlType.equalsIgnoreCase("tinyint")){
            return "byte";
        }else if(sqlType.equalsIgnoreCase("smallint")){
            return "short";
        }else if(sqlType.equalsIgnoreCase("int")){
            return "int";
        }else if(sqlType.equalsIgnoreCase("bigint")){
            return "long";
        }else if(sqlType.equalsIgnoreCase("float")){
            return "float";
        }else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric") 
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money") 
                || sqlType.equalsIgnoreCase("smallmoney")){
            return "double";
        }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char") 
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar") 
                || sqlType.equalsIgnoreCase("text")){
            return "String";
        }else if(sqlType.equalsIgnoreCase("datetime")){
            return "Date";
        }else if(sqlType.equalsIgnoreCase("image")){
            return "Blod";
        }
         
        return null;
    }
     
    /**
     * 出口
     * TODO
     * @param args
     */
    public static void main(String[] args) {
         
        new GenEntity();
         
    }
 
}
