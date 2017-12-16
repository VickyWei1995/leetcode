class Solution {
public:
    bool isPalindrome(int x) {
        int y = 0;
        int tmp = x;
        if (tmp < 0)
        {
            return false;
        }
        else
        {
           while(x){
                y = y*10 + x %10;
                x /= 10;
            } 
            return (tmp == y);
        }    
    }
};

class Solution1 {
public:
    bool isPalindrome(int x) {
        int y = 0;
        int tmp = x;
        while(x){
            y = y*10 + x %10;
            x /= 10;
        }
        return y<0 ? false : (tmp == y);
    }
};
