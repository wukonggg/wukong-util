package band.wukong.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class FileUtil {

    /**
     * 获取文件扩展名，如果没有找到扩展名就返回空字符串
     *
     * @param file file
     * @return 扩展名。。。。
     */
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    /**
     * 获取文件名称，不含扩展名
     *
     * @param fileName fileName
     * @return 文件名。。。。
     */
    public static String getFileNameWithoutExtension(String fileName) {
        if (null == fileName || "".equals(fileName)) {
            throw new RuntimeException("文件名不合法");
        }

        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(0, fileName.lastIndexOf("."));
        } else {
            return "";
        }
    }

    /**
     * 读取文件所有行
     *
     * @param file 文件路径及文件名
     * @return 所有行组成的List
     */
    public static List<String> readLines(String file) {
        List<String> slist = new ArrayList<String>();

        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(new File(file)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("找不到文件。param.file=" + file);
        }

        try {
            String s;
            while (null != (s = in.readLine())) {
                slist.add(s);
            }
        } catch (IOException e) {
            throw new RuntimeException("按行读取文件失败。", e);
        } finally {
            try {
                in.close();
            } catch (IOException ignore) {
            }
        }
        return slist;
    }
}
