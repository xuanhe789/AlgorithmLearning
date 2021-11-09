package leetcode每日一题;

import java.util.HashMap;

public class _299_猜数字游戏_med {
    public String getHint(String secret, String guess) {
        int ACount=0,BCount=0;
        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < guessChars.length; i++) {
            if (secretChars[i]==guessChars[i]){
                ACount++;
            }else {
                map.put(secretChars[i],map.getOrDefault(secretChars[i],0));
            }
        }

        for (int i = 0; i < guessChars.length; i++) {
            if (secretChars[i]==guessChars[i]){
                continue;
            }else {
                Integer value = map.getOrDefault(guessChars[i], 0);
                if (value >0){
                    BCount++;
                    map.put(guessChars[i],value-1);
                }
            }
        }

        return ACount+"A"+BCount+"B";
    }
}
