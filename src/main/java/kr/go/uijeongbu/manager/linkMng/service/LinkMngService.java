package kr.go.uijeongbu.manager.linkMng.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Description		: 연계데이터 관리 Service
 * @Source        	: LinkMngService.java
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

public interface LinkMngService {
	
	/**
	 * 연계주기 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	List<Map<String, Object>> selectLinkList() throws IOException, SQLException;
	
	/**
	 * 연계상태 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	List<Map<String, Object>> selectLinkStatusList() throws IOException, SQLException;
	
	/**
	 * 연계 GRID 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	List<Map<String, Object>> selectLinkData(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 연계 데이터 로그 가져오기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	List<Map<String, Object>> selectLinkDataLog(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 연계 최근날짜 가져오기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	Map<String, Object> selectLinkDataDate(Map<String, Object> param) throws IOException, SQLException;
	
}
