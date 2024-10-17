package kr.co.yangdoll.persistence;

import org.apache.ibatis.annotations.Select;

public interface DateMapper {
	@Select("select sysdate from dual")
	String getServerDate();
	
	String getServerDate2(); //mapper 사용
}
