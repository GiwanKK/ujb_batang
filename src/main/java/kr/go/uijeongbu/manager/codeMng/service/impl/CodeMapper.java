package kr.go.uijeongbu.manager.codeMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 관리자 > 공통코드 관리 Mapper 클래스
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
@Repository("codeMapper")
public class CodeMapper extends ComAbstractDAO {

	/**
	 * 공통코드 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectCodeList(Map<String, Object> param) throws IOException, SQLException {
		return selectList("CodeManageDAO.selectCodeList", param);
	}
	
	
	/**
	 * 공통코드 정보 저장하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertCodeInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("CodeManageDAO.insertCodeInfo", param);
	}
	
	
	/**
	 * 공통코드 정보 수정하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int updateCodeInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("CodeManageDAO.updateCodeInfo", param);
	}
	
	
	/**
	 * 공통코드 정보 삭제하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deleteCodeInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return delete("CodeManageDAO.deleteCodeInfo", param);
	}
	
}
