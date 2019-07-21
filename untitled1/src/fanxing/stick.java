package fanxing;

public class stick {
    //        public static int[] list = new int[]{2,3,4,6,4,6};
    public static int[] list = new int[]{1, 3, 4, 2, 5, 8};
    public static int length = list.length;
    public static int aim = 0;
    public static boolean[] use = new boolean[length];

    public static void main(String[] args) {

        int res = getMinSum(list);
        System.out.println("sumMax" + res);

    }


    public static int getMinSum(int[] list) {
        int res = 0;
        int temp = 0;
        for (int l : list) {
            temp += l;
        }

        int maxSum = temp / 2;
        //枚举每种可能的sum值
        for (int i = 0; i <= maxSum; i++) {
            use = new boolean[length];
            aim = i;
            System.out.println("tempAim" + i);
            for (int p = 0; p < length; p++) {
                if (DFS(0, 0, p)) {
                    if (res < i)
                        res = i;

                    System.out.println("sumMax" + res);
                    continue;
                }
            }

        }
        return res;
    }


    public static boolean DFS(int stick, int len, int pos) {
        //当前组合好的棍子数，已有长度，位置

        if (stick == 2) {
            return true;
        }
        for (int i = pos; i < length; ++i) {

            if (use[i]) {
                continue;
            }
            if (list[i] + len == aim) {
                use[i] = true;
                //满足一根找另一根
                boolean nextStick = false;
                for (int p = 0; p < length; p++) {
                    if (DFS(stick + 1, 0, p))
                        nextStick = true;
                }
                if (nextStick)
                    return true;
                //搜索失败不该用这根
                use[i] = false;
                return false;
            } else if (list[i] + len < aim) {
                use[i] = true;
                //继续找这一支棒
                if (DFS(stick, len + list[i], i))
                    return true;
                use[i] = false;
                if (len == 0)
                    return false;
            }

        }
        return false;
    }

}
