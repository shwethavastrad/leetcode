public class _1460_Make_Two_Arrays_Equal_by_Reversing_Subarrays {
    class Solution {
        public boolean canBeEqual(int[] target, int[] arr) {

            int count[] = new int[1001];

            for (int i = 0; i < target.length; i++) {
                count[target[i]]++;
                count[arr[i]]--;
            }

            for (int i : count) {
                if (i != 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
