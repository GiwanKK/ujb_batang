package kr.go.uijeongbu.manager.linkMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;
/**
 * @Description		: 연계 데이터 관리 Mapper
 * @Source        	: LinkMngMapper.java
 * @author 김부권
 * @since 2021. 09. 23.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일			수정자			수정내용
 *  -------    		-------------   ----------------------
 *  2021.09.23.   	김부권          최초 생성
 *   
 * </pre>
 */
@Repository("linkMngMapper")
public class LinkMngMapper extends ComAbstractDAO {
	
	/**
	 * 연계주기 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectLinkList() throws IOException, SQLException{
		return selectList("LinkMngDAO.selectLinkList");
	}
	
	
	/**
	 * 연계상태 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectLinkStatusList() throws IOException, SQLException{
		return selectList("LinkMngDAO.selectLinkStatusList");
	}
	
	/**
	 * 연계 GRID 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectLinkData(Map<String, Object> param) throws IOException, SQLException{
		return selectList("LinkMngDAO.selectLinkData", param);
	}
	
	/**
	 * 연계 데이터 로그 가져오기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectLinkDataLog(Map<String, Object> param) throws IOException, SQLException{
		return selectList("LinkMngDAO.selectLinkDataLog", param);
	}
	
	
	/**
	 * 연계 최근날짜 가져오기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public Map<String, Object> selectLinkDataDate(Map<String, Object> param) throws IOException, SQLException{
		return selectOne("LinkMngDAO.selectLinkDataDate", param);
	}
	
	
	
}
