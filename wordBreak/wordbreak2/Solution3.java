package wordbreak2;

import java.util.*;

public class Solution3 {
	List<String> ret;

	public List<String>  wordBreak(String s, Set<String> dict) {
	    String[] all = dict.toArray(new String[0]);
	    
	    ret = new ArrayList<String>();
	    
	    nextWord(0, s, all, "");
	    return ret;
	}

	void nextWord(int pos, String s, String[] all, String sent) {
	    if (pos == s.length()) {
	        ret.add(sent.trim());
	    }
	    
	    for (int i = 0; i < all.length; i++) {
	        if (s.indexOf(all[i], pos) == pos) {
	            String str = sent;
	            str += all[i] + " ";
	            nextWord(pos + all[i].length(), s, all, str);
	        }
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
