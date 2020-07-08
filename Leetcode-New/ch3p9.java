class ch3p9 {
    static int[] nums;
    static int length;
    public static void main(String[] args) {
        nums = new int[]{-1,2};
        length = nums.length;

        System.out.println("Result");

        System.out.println("Result : " + checkLoop());
    }

    // Let i be the index of the array
    public static int advance(int i) {
        i += nums[i];
        // Lesser than 0
        if (i < 0) {
            i+= length;
        }
        // Greater than the length of the array
        if (i >= length) {
            i %= length;
        }
        return i;
    }

    public static boolean checkLoop() {
        // Lets iterate over the loop and chedck for various starting points
        for (int i = 0; i < length; i++) {

            if (nums[i] == 0) continue;

            // slow pointer
            int slow = i;
            int fast = advance(slow);

            // directionality
            while(nums[i] * nums[fast] > 0 && nums[i] * nums[advance(fast)] > 0) {
                if (slow == fast) {
                    if (slow == advance(slow)) break;  // single element loop
                    return true;
                }

                slow = advance(slow);
                fast = advance(advance(fast));
            }

            slow = i;
            int sgn = nums[i];
            while (sgn * nums[slow] > 0) {
                int tmp = advance(slow);
                nums[slow] = 0;
                slow = tmp;
            }

        }
        return false;
    }
}