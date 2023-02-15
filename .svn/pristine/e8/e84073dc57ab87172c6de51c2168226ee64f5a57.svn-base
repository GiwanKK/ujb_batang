package kr.go.uijeongbu.manager.logMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;
/**
 * @Description		: 로그 관리 Mapper
 * @Source        	: LogMapper.java
 * @author 김부권
 * @since 2021. 08. 25.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일			수정자			수정내용
 *  -------    		-------------   ----------------------
 *  2021.08.25.   	김부권          최초 생성
 *   
 * </pre>
 */
@Repository("logMapper")
public class LogMapper extends ComAbstractDAO {
	
	/**
	 * 사용자 로그 insert
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createUserLog(Map<String, Object> param) throws IOException, SQLException{
		return insert("LogManageDAO.createUserLog", param);
	}
	
	/**
	 * 메뉴 로그 insert
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int createMenuLog(Map<String, Object> param) throws IOException, SQLException{
		return insert("LogManageDAO.createMenuLog", param);
	}
	
	/**
	 * 로그 관리 날짜 가져오기
	 * @return
	 * @throws IOException, SQLException
	 */
	public Map<String, Object> selectLogDate() throws IOException, SQLException {
		return selectOne("LogManageDAO.selectLogDate");
	}
	
	/**
	 * 누적 방문자수 통계
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public Map<String, Object> selectLogTotalVisitor() throws IOException, SQLException {
		return selectOne("LogManageDAO.selectLogTotalVisitor");
	}
	
	/**
	 * 누적 방문횟수 통계
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public Map<String, Object> selectLogTotalCnt() throws IOException, SQLException {
		return selectOne("LogManageDAO.selectLogTotalCnt");
	}
	
	/**
	 * 누적 페이지뷰 통계
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public Map<String, Object> selectLogTotalView() throws IOException, SQLException {
		return selectOne("LogManageDAO.selectLogTotalView");
	}
	
	/**
	 * 사용자 유저(월별) 로그 CNT
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectLogUserMonthCnt(Map<String, Object> param) throws IOException, SQLException {
		return selectList("LogManageDAO.selectLogUserMonthCnt", param);
	}
	
	/**
	 * 
	 * 사용자 유저(요일별) 로그 CNT
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectLogUserDayCnt(Map<String, Object> param) throws IOException, SQLException {
		return selectList("LogManageDAO.selectLogUserDayCnt", param);
	}
	
	/**
	 * 사용자 유저 로그(페이지 방문 현황) 데이터 조회 
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectLogUserPageView(Map<String, Object> param) throws IOException, SQLException {
		return selectList("LogManageDAO.selectLogUserPageView", param);
	}
	
	/**
	 * 사용자 유저 로그 디테일 데이터 조회 
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectLogDetailView(Map<String, Object> param) throws IOException, SQLException {
		return selectList("LogManageDAO.selectLogDetailView", param);
	}
	
	
}
