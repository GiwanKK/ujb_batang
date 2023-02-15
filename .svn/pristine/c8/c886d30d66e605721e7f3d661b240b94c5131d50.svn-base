package kr.go.uijeongbu.dashBoard.organization.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 조직도 service 클래스
 * @author 김부권
 * @since 2021. 07. 02.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 07. 02	        김 부 권              최초생성
 *   
 * </pre>
 */
public interface OrganizationService {
	
	/**
	 * 조직도 공석체크
	 * @return 
	 */
	List<Map<String, Object>> selectOrgCnt();
	
	/**
	 * 조직도 공석 넣기
	 * @return 
	 */
	int insertOrgData();
	
	/**
	 * 조직도 공석 지우기
	 * @return 
	 */
	int deleteOrgData();
	
	/**
	 * 조직도 데이터 조히
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectOrganization(Map<String, Object> param);
	
	/**
	 * 조직도 서브 데이터 조히
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectSubOrganization(Map<String, Object> param);
	
	/**
	 * 조직원 데이터 조히
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectDetailMember(Map<String, Object> param);
	
	
}
