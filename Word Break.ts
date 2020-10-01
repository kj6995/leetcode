function wordBreak(s: string, wordDict: string[]): boolean {
    /*ex: 
        s: "abra | ka | dabra", wordDict = ["abra", "ka", "dabra"]
            ^
        dp       =  [t,f,f,f,t,f,t,f,f,f, f, t]
        dp_index =  [0,1,2,3,4,5,6,7,8,9,10,11]
        
        Q1) How are we going to define our dp?
            dp[i] is true when substring(0,i) is inside wordDict
    
        Q2)Base case for that DP?
            dp[0] = true
            
        pi = 3
        j = 0
        
        dp[0] & abr => false
        dp[1] & br =>false
        dp[2] & r => false
        
        pi = 4
        j = 0
        
        dp[0] & abra => True; 
        
        pi= 5
        j = 0
        
        dp[0] & abrak => false
        dp[1] & brak => false
        .
        .
        dp[4] % k => false
        
        
        pi= 6
        j = 0
        
        dp[0] & abraka => false
        dp[1] =>f
        dp[2] =>f
        dp[3] =>f
        dp[4] & ka => true
        

        Time Complexity : O(N^2)
        Space Complexity: O(N)
        
    */
    
    const dp = new Array(s.length + 1).fill(false);
    dp[0] = true;
    
    const newWordDict = new Set(wordDict);
    
    
    for(let pi = 1; pi < s.length +1; pi++){
        for(let j = 0 ; j < pi; j++){
            const word = s.slice(j, pi);
            if(dp[j] && newWordDict.has(word)){
                dp[pi] = true;
                break;
            }
        }
    }
    
    
    return dp[s.length]
    
};