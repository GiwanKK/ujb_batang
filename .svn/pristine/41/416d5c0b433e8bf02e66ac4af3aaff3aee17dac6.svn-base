package kr.go.uijeongbu.manager.userAuth.userAuthMng.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 관리자 > 부서 관리용 Mapper 클래스
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
@Repository("userAuthMngMapper")
public class UserAuthMngMapper extends ComAbstractDAO {

	/**
	 * 부서 목록 조회하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectDeptList(Map<String, Object> param) throws IOException, SQLException {
		return selectList("UserAuthMngDAO.selectDeptList", param);
	}
	
	
	/**
	 * 부서 정보 저장하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertDeptInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("UserAuthMngDAO.insertDeptInfo", param);
	}
	
	
	/**
	 * 부서 정보 수정하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int updateDeptInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("UserAuthMngDAO.updateDeptInfo", param);
	}
	
	
	/**
	 * 부서 정보 삭제하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deleteDeptInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return delete("UserAuthMngDAO.deleteDeptInfo", param);
	}
	
	
	/**
	 * 부서별 권한 목록 가져오기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public List<Map<String, Object>> selectDeptRoleList(Map<String, Object> param) throws IOException, SQLException {
		return selectList("UserAuthMngDAO.selectDeptRoleList", param);
	}
	
	
	/**
	 * 부서별 설정 권한 정보 삭제하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int deleteDeptRoleInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return delete("UserAuthMngDAO.deleteDeptRoleInfo", param);
	}
	
	
	
	/**
	 * 부서별 설정 권한 정보 추가하기
	 * @param param
	 * @return
	 * @throws IOException, SQLException
	 */
	public int insertDeptRoleInfo(Map<String, Object> param) throws IOException, SQLException {
		
		return insert("UserAuthMngDAO.insertDeptRoleInfo", param);
	}
	
	
}
