package com.eethan.ineedu.constant;

public class MatchCondition {
	public static final int NOT_MATCH = 1;//未进行匹配
	public static final int MATCH_CHOOSE = 2;//匹配成功 正在选择
	public static final int MATCHING = 3;//匹配不成功 正在等待  只在进行匹配并成功后短暂存在
	public static final int MATCH_OK = 4;//匹配成功
	
	public static final int REMOVE_SUCCESS = 5;
	public static final int REMOVE_FAILED = 6;
}
