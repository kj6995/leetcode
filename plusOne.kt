class Solution {
    fun plusOne(digits: IntArray): IntArray {
        
        var n = digits.size
        digits[n-1] = digits[n-1] + 1
        var carry =  digits[n-1]/10
        digits[n-1] = digits[n-1] % 10
        
        if(carry == 1){
            for(i in n-2 downTo 0){
                if(carry == 1){
                    digits[i] = digits[i] + 1
                    carry =  digits[i]/10
                    digits[i] = digits[i] % 10
                }
            }
        }
        var ans = digits
        if(carry == 1){
            var newdigit = digits.toMutableList()
            newdigit.add(0,1)
            ans = newdigit.toIntArray()
            println(newdigit)
        }
        
        return ans
    }
}