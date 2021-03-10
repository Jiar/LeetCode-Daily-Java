import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/// https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
class Solution_2021_03_09 {

    /// https://leetcode-cn.com/submissions/detail/153325238/
    public static void main(String args[]) {
        String example = "abbaca";
        Solution_2021_03_09 solution = new Solution_2021_03_09();
        String result1 = solution.removeDuplicates1(example);
        System.out.println(result1);
        String result2 = solution.removeDuplicates2(example);
        System.out.println(result2);
    }

    public String removeDuplicates1(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }
        List<Character> result = new ArrayList<Character>();
        for (int i=0; i < length; i++) {
            if (result.isEmpty()) {
                result.add(s.charAt(i));
                continue;
            }
            int index = result.size()-1;
            if (index < 0) {
                index = 0;
            }
            char last = result.get(index);
            char head = s.charAt(i);
            if (last == head) {
                result.remove(index);
            } else {
                result.add(head);
            }
        }
        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }

    /// https://leetcode-cn.com/submissions/detail/153324013/
    public String removeDuplicates2(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }
        char[] result = new char[s.length()];
        int offset = 0;
        for (int i=0; i < length; i++) {
            if (offset == 0 && result[offset] == '\0') {
                result[offset] = s.charAt(i);
                continue;
            }
            char last = result[offset];
            char head = s.charAt(i);
            if (last == head) {
                result[offset] = '\0';
                offset -= 1;
                if (offset < 0) {
                    offset = 0;
                }
            } else {
                offset += 1;
                result[offset] = head;
            }
        }
        if (offset == 0 && result[offset] == '\0') {
            return "";
        } else {
            return String.valueOf(result, 0, offset+1);
        }
    }

}
