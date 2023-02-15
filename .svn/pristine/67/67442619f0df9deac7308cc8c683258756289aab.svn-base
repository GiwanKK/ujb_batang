package kr.go.uijeongbu.manager.menuMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 관리자 > 메뉴관리용 Mapper 클래스
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
@Repository("menuMapper")
public class MenuMapper extends ComAbstractDAO {

	/**
	 * 메뉴 목록 조회하기
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectMenuList(Map<String, Object> param) throws IOException, SQLException {
		return selectList("MenuManageDAO.selectMenuList", param);
	}
	
	
	/**
	 * 메뉴 정보 저장하기
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int insertMenuInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("MenuManageDAO.insertMenuInfo", param);
	}
	
	
	/**
	 * 메뉴 정보 수정하기
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int updateMenuInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("MenuManageDAO.updateMenuInfo", param);
	}
	
	
	/**
	 * 메뉴 정보 삭제하기
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int deleteMenuInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return delete("MenuManageDAO.deleteMenuInfo", param);
	}
	
}
