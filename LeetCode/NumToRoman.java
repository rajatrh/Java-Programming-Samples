class NumToRoman {
    int[] divStore = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,4,1}; 
    String [] romanStore = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V","IV","I"};

    public static void main(String[] args) {
        NumToRoman s = new NumToRoman();
        System.out.println(s.intToRoman(58));
    }
    public String intToRoman(int num) {
        return getConversion(num);
    }
    
    public String getConversion(int num) {
        if (num == 0) {
            return "";
        }
        
        int idx = getIndex(num);
        System.out.println(idx);
        return getConversion(num-divStore[idx]) + romanStore[idx];   
    }
    
    public int getIndex(int num) {
        for (int i=0; i<divStore.length; i++) {
            if (num%divStore[i] == 0) {
                return i;
            }
        }
        
        return -1;
    }
}