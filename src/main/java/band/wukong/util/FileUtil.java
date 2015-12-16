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
     * 获取文件扩展名
     *
     * @param file file
     * @return
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
     * @return
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
