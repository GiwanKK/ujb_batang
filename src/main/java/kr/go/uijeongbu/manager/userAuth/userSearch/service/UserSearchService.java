package kr.go.uijeongbu.manager.userAuth.userSearch.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 관리자 > 부서/직위별 권한 조회 Service 클래스
* @author 전동표
* @since 2020. 07. 03.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
*  수정일			수정자			수정내용
*  -------    		-------------   ----------------------
*  2020.07.03.   	전동표          최초 생성
*   
* </pre>
*/


public interface UserSearchService {

	/**
	 * 사용자 조회	
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selectSearchList(Map<String, Object> param) throws IOException, SQLException;
	
	/**
	 * 로딩시 부서 목록 조회
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getDeptAllGetList() throws IOException, SQLException;
	
	/**
	 * 로딩시 직위 목록 조회
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> getPositionList() throws IOException, SQLException;
	
}
