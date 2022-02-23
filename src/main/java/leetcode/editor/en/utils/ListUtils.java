package leetcode.editor.en.utils;

import java.util.List;

/**
 * @Author yida
 * @Date 2022-02-23 19:26
 * @Description List工具类
 */
public class ListUtils {
    public static void printList(List list) {
        if (null == list || list.size() <= 0) {
            System.out.println("Empty List.");
            return;
        }
        int len = list.size() - 1;
        StringBuilder builder = new StringBuilder("[");
        int index = 0;
        for (Object el : list) {
            if (index < len) {
                builder.append(el).append(",");
            } else {
                builder.append(el);
            }
            index++;
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
