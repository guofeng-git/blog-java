package blog;


import java.util.*;

import com.sjf.util.UuidUtil;

public class Test {
//	int x=5;
	public static void main(String args[]) {
		
//		Test t = new Test();
//		System.out.println(t.x);
		
//		Map<String,String> map = new HashMap<String,String>();
//		
//		map.put("a", "1");
//		map.put("b", "2");
//		map.put("c", "3");
//		map.put("d", "4");
//		
//		Set<String> set = map.keySet();
//		
//		for(String s : set) {
//			System.out.println(map.get(s));
//		}
		String s = UuidUtil.get32UUID();
		System.out.println(s);
		
	}

}
