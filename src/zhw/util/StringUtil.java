package zhw.util;

/**
 * @auther 张鸿伟
 * @date 2021/1/6 10:51:09
 * @description
 */

/**
 * 项目名 BookManager
 * <br>包名 util
 * <br>描述 字符串处理工具类
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        if(str==null||"".equals(str.trim())){
            return true;
        }
        else{
            return false;
        }
    }
}
