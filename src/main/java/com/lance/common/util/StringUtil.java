package com.lance.common.util;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;

/**
 * 字符串处理类
 *
 * @author lance
 * @since 2018/8/29
 */
public class StringUtil extends StringUtils
{
    /**
     * 在字符串上加CDATA。
     *
     * @param string
     * @return String
     */
    public static String addCDATA(String string)
    {
        String returnStr = "<![CDATA[";
        returnStr += string;
        returnStr += "]]>";
        return returnStr;
    }


    /**
     * 是否非空
     *
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str)
    {
        return !isEmpty(str);
    }

    /**
     * 判断是否一致
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean equals(String a, String b)
    {
        if (a == null)
        {
            return b == null;
        }
        else
        {
            return a.equals(b);
        }
    }

    /**
     * 判断输入的字符串是否为null，如果是null则返回"",否则，返回原字符串。
     *
     * @param str
     * @return String
     */
    public static String null2String(String str)
    {
        if (isEmpty(str))
        {
            return "";
        }
        else
        {
            return str;
        }
    }

    /**
     * MD5加密
     *
     * @param s
     * @return String
     */
    public static String MD5(String s)
    {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try
        {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++)
            {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str).toUpperCase();
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * 字符串进行escape编码
     *
     * @param src
     * @return
     */
    public static String escape(String src)
    {
        int i;
        char j;
        StringBuffer temp = new StringBuffer();
        temp.ensureCapacity(src.length() * 6);
        for (i = 0; i < src.length(); i++)
        {
            j = src.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
            {
                temp.append(j);
            }
            else if (j < 256)
            {
                temp.append("%");
                if (j < 16)
                {
                    temp.append("0");
                }
                temp.append(Integer.toString(j, 16).toUpperCase());
            }
            else
            {
                temp.append("%u");
                temp.append(Integer.toString(j, 16).toUpperCase());
            }
        }
        return temp.toString();
    }

    /**
     * 字符串进行escape解码
     *
     * @param src
     * @return
     */
    public static String unescape(String src)
    {
        StringBuffer temp = new StringBuffer();
        temp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < src.length())
        {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos)
            {
                if (src.charAt(pos + 1) == 'u')
                {
                    ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
                    temp.append(ch);
                    lastPos = pos + 6;
                }
                else
                {
                    ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
                    temp.append(ch);
                    lastPos = pos + 3;
                }
            }
            else
            {
                if (pos == -1)
                {
                    temp.append(src.substring(lastPos));
                    lastPos = src.length();
                }
                else
                {
                    temp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return temp.toString();
    }

    /**
     * 是否为中文
     *
     * @param str
     * @return
     */
    public static boolean isChinese(String str)
    {
        return str.getBytes().length != str.length();
    }

    /**
     * 生成16位数字格式的唯一标识符
     *
     * @return
     */
    public static String generateNumberUid()
    {
        Long stamp = System.currentTimeMillis();
        int random = (int) (Math.random() * 900 + 100);
        return stamp + "" + random;
    }
}
