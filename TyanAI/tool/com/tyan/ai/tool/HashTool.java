package com.tyan.ai.tool;

public class HashTool {
	
	public static long BKDRHash(String str){
		//BKDR Hash Function
		long seed =131313131L;
		long hash = 0L;
		
		for(int i=0; i<str.length(); i++){
			hash = hash * seed + str.charAt(i);
		}
		return (hash);
	}
	
	// AP Hash Function
	public static long APHash(String str){
		 long hash = 0;
		 int i;
		 for(i=0; i<str.length(); i++){
			 if ((i & 1) == 0)
		        {
		            hash ^= ((hash << 7) ^ ( str.charAt(i) ) ^ (hash >> 3));
		        }
		        else
		        {
		            hash ^= (~((hash << 11) ^ ( str.charAt(i) ) ^ (hash >> 5)));
		        }
		 }
		 return (hash & 0x7FFFFFFF);
	}
	
	public static long MixHash(String str){
		long ap = APHash(str);
		long bkd = BKDRHash(str);
		long mh = Long.parseLong( (ap + "" + bkd).substring(0, 18) );
		return mh;
	}
	
	
	public static void main(String[] args) {
		System.out.println(BKDRHash("w"
				+ "wxxxxwxx"));
		System.out.println("xxxxxx".hashCode());
	}
	

}
