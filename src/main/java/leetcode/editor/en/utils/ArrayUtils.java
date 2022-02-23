package leetcode.editor.en.utils;

/**
 * @Author yida
 * @Date 2022-02-23 18:10
 * @Description TODO
 */
public class ArrayUtils {
    public static void printArray(int[] arr) {
        if (null == arr || arr.length <= 0) {
            System.out.println("Empty Array.");
            return;
        }
        int len = arr.length - 1;
        StringBuilder builder = new StringBuilder("[");
        int index = 0;
        for (int el : arr) {
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
