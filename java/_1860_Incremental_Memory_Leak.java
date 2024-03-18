public class _1860_Incremental_Memory_Leak {
    class Solution {
        public int[] memLeak(int memory1, int memory2) {

            int i = 1;

            while (true) {
                if (memory1 >= memory2) {
                    if (memory1 < i)
                        break;
                    else
                        memory1 -= i;
                }
                else {
                    if (memory2 < i)
                        break;
                    else
                        memory2 -= i;
                }

                i++;
            }

            return new int[] {i, memory1, memory2};

        }
    }
}
