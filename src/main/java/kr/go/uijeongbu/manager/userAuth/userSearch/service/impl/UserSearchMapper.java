package kr.go.uijeongbu.manager.userAuth.userSearch.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

@Repository("userSearchMapper")
public class UserSearchMapper extends ComAbstractDAO  {
	
	/**
	 * 부서조회	
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectSearchList(Map<String, Object> param) throws IOException, SQLException  {
		return selectList("UserSearchManage.selectSearchList", param);
	}
	
	/**
	 * 로딩시 부서 목록 가져오기
	 * **/
	public List<Map<String, Object>> getDeptAllGetList() throws IOException, SQLException  {
		return selectList("UserSearchManage.getDeptAllGetList");
	}
	
	/**
	 * 로딩시 직위 목록 가져오기
	 * **/
	public List<Map<String, Object>> getPositionList() throws IOException, SQLException  {
		return selectList("UserSearchManage.getPositionList");
	}
}
