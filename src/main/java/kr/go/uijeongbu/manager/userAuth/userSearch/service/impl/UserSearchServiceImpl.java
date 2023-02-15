package kr.go.uijeongbu.manager.userAuth.userSearch.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.manager.userAuth.userSearch.service.UserSearchService;

@Service("userSearchService")
public class UserSearchServiceImpl implements UserSearchService{
	
	@Resource( name = "userSearchMapper")
	private UserSearchMapper usersearchMapper;
	
	/**
	 * 부서/직위별 권한 전 조회	
	 */
	@Override
	public List<Map<String, Object>> selectSearchList(Map<String, Object> param) throws IOException, SQLException  {
		// TODO Auto-generated method stub
		return usersearchMapper.selectSearchList(param);
	}
	/**
	 * 로딩시 부서 검색조건 가져오기
	 */
	@Override
	public List<Map<String, Object>> getDeptAllGetList() throws IOException, SQLException  {
		// TODO Auto-generated method stub
		return usersearchMapper.getDeptAllGetList();
	}
	
	/**
	 * 로딩시 직위 검색조건 가져오기
	 */
	@Override
	public List<Map<String, Object>> getPositionList() throws IOException, SQLException  {
		// TODO Auto-generated method stub
		return usersearchMapper.getPositionList();
	}
	
}
