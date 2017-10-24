package com.xingyun.smartsite.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PageSplitter {
	private final Log log = LogFactory.getLog(PageSplitter.class);
	
	public static final int PAGE_PER_ROW_COUNT = 10;
	public static final int GROUP_PER_PAGE_COUNT = 10;
	
	private List<Map<String,Object>> resultList = null;
	private int totalRowCount = 0;
	private int pageNo = 0;
	public PageSplitter(List<Map<String,Object>> resultList, int totalRowCount, int pageNo){
		this.resultList = resultList;
		this.totalRowCount = totalRowCount;
		this.pageNo = pageNo;
	}
	
	public List<Map<String,Object>> getNumberingResultList(){
		
		//log.debug("totalRowCount    =>"+ totalRowCount);
		//log.debug("resultList size  =>"+ resultList.size());
		List<Map<String,Object>> newMapList = new ArrayList<Map<String,Object>>();
		
		int base = (pageNo-1) * PAGE_PER_ROW_COUNT;
		int until = base + PAGE_PER_ROW_COUNT;
		//log.debug("base :"+ base + "  until:"+ until);
		//log.debug("===============");
		
		int seq=0;
		for(Map<String,Object> resultMap : resultList ){
			int no = totalRowCount - (base+ seq);
			//log.debug("resultMap.getIndex :"+ resultMap.get("user_index")  + "   no:" +(no));
			seq++;
			resultMap.put("no", no);
			newMapList.add(resultMap);
		}
		return newMapList;
		
	}
	public Map<String,String> getPageNavigationInfo(){
		int totalPageCount = totalRowCount / PAGE_PER_ROW_COUNT + (totalRowCount % PAGE_PER_ROW_COUNT > 0 ? 1 : 0);
		if(pageNo > totalPageCount){
			pageNo = totalPageCount;
		}
		int group_no = pageNo / GROUP_PER_PAGE_COUNT + ( pageNo % GROUP_PER_PAGE_COUNT>0 ? 1 : 0);
		int endNum = group_no * GROUP_PER_PAGE_COUNT;		
		int startNum = endNum - (GROUP_PER_PAGE_COUNT - 1);
		
		if(endNum > totalPageCount){
			endNum = totalPageCount;
		}
		int prevPageNum = startNum - GROUP_PER_PAGE_COUNT; 
		int nextPageNum = startNum + GROUP_PER_PAGE_COUNT;
		
		if(prevPageNum < 1){
			prevPageNum = 1;
		}
		
		if(nextPageNum > totalPageCount){	
			nextPageNum = totalPageCount / GROUP_PER_PAGE_COUNT * GROUP_PER_PAGE_COUNT + 1;
		}
		
		log.debug("pageNo : "+ pageNo);
		log.debug("totalPageCount :"+ totalPageCount);
		log.debug("startNum : "+ startNum);
		log.debug("endNum   : "+ endNum);
		log.debug("prevPageNum :"+ prevPageNum);
		log.debug("nextPageNum :"+ nextPageNum);
		
		Map<String,String> getPageNavigationInfo = new HashMap<String, String>();
		getPageNavigationInfo.put("currentPageNo", String.valueOf(pageNo));
		getPageNavigationInfo.put("totalPageCount", String.valueOf(totalPageCount));
		getPageNavigationInfo.put("startNum", String.valueOf(startNum));
		getPageNavigationInfo.put("endNum", String.valueOf(endNum));
		getPageNavigationInfo.put("prevPageNum", String.valueOf(prevPageNum));
		getPageNavigationInfo.put("nextPageNum", String.valueOf(nextPageNum));
		return getPageNavigationInfo;
	}
//	public void test(){
//		int record_end_no = pageNo * page_per_record_cnt;
//		int record_start_no = record_end_no - (page_per_record_cnt -1);
//		if(record_end_no > total_record){
//			record_end_no = total_record;
//		}
//		int total_page = total_record / page_per_record_cnt + (total_record % page_per_record_cnt>0 ? 1 : 0);
//		if(pageNo>total_page){
//			pageNo = total_page;
//		}
//		int group_no = pageNo/group_per_page_cnt+( pageNo%group_per_page_cnt>0 ? 1:0);
//		int page_eno = group_no*group_per_page_cnt;		
//		int page_sno = page_eno-(group_per_page_cnt-1);
//		if(page_eno>total_page){
//			page_eno=total_page;
//		}
//		int prev_pageno = page_sno-group_per_page_cnt; 
//		int next_pageno = page_sno + group_per_page_cnt;
//		if(prev_pageno < 1){
//			prev_pageno = 1;
//		}
//		
//		if(next_pageno>total_page){	
//			next_pageno=total_page/group_per_page_cnt*group_per_page_cnt+1;
//		}
//		
//		log.debug("pageNo:"+ pageNo);
////		log.debug("total_record :"+ total_record);
////		log.debug("page_per_record_cnt:"+ page_per_record_cnt);
////		log.debug("group_per_page_cnt:"+ group_per_page_cnt);
//		
//		
//		//log.debug("record_start_no : "+ record_start_no);
//		//log.debug("record_end_no : "+ record_end_no);
//		log.debug("total_page :"+ total_page);
//		
//		//log.debug("group_no[current_pageNo] :"+ group_no);
//		log.debug("group_no[start] :"+ page_sno);
//		log.debug("group_no[end] :"+ page_eno);
//		log.debug("prev_pageno :"+ prev_pageno);
//		log.debug("next_pageno :"+ next_pageno);
//	}
	
//	public List<Map<String,Object>> getNumberingResultList(){
//		
//		System.out.println("total_record    =>"+ total_record);
//		System.out.println("resultList size =>"+ resultList.size());
//		List<Map<String,Object>> newMapList = new ArrayList<Map<String,Object>>();
//		
////		int record_end_no = pageNo * page_per_record_cnt;
////		int record_start_no = record_end_no - (page_per_record_cnt -1);
////		System.out.println("record_end_no :"+ record_end_no);
////		System.out.println("record_start_no :"+ record_start_no);
////		
////		int seq=0;
////		for(int i= record_start_no; i <= record_end_no; i++){
////			
////			int no =  (total_record - (i-1));
////			
////			
////			seq = no - no +1;
////			System.out.println("no =>"+ no +   "   seq:"+ seq);
////			
////		}
////		
////		System.out.println("=================================");
////		int start_no = total_record - ((pageNo -1) * page_per_record_cnt);
////		int end_no = start_no -( page_per_record_cnt-1);
////		System.out.println("start_no =>"+ start_no);
////		System.out.println("end_no =>"+ end_no);
//		
////		System.out.println("0 =>"+ list.get(0).get("user_index"));
//		
//		
//		
//		int base = (pageNo-1) * page_per_record_cnt;
//		int until = base + page_per_record_cnt;
//		System.out.println("base :"+ base + "  until:"+ until);
//		System.out.println("===============");
//		
//		
////		for(int i=base; i < until; i++){
////			int no = total_record - i ;
////			System.out.println("base :"+ i +   " no =>"+ no);
////			
////			Map<String, Object> tmpMap = list.get(i);
////			long userIndex = (long) (tmpMap.get("user_index"));
////			System.out.println((userIndex) +  "   user_id =>" + tmpMap.get("user_id"));
////			
////			tmpMap.put("no", no);
////			newMapList.add(tmpMap);
////		}
////		for(Map<String,Object> tmp : newMapList){
////			System.out.println("tmp =>  "+ tmp.get("no") + " / "+ tmp.get("user_index") + " / " + tmp.get("user_id"));
////		}
//		
//		
//		int seq=0;
//		for(Map<String,Object> resultMap : resultList ){
//			int no = total_record - (base+ seq);
//			System.out.println("resultMap.getIndex :"+ resultMap.get("user_index")  + "   no:" +(no));
//			seq++;
//			resultMap.put("no", no);
//			newMapList.add(resultMap);
//		}
//		
//		test();
//		return newMapList;
//		
//	}
}
