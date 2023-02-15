package kr.go.uijeongbu.dashBoard.organization.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 조직도 mapper 클래스
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

@Repository("organizationMapper")
public class OrganizationMapper extends ComAbstractDAO {
	
	/**
	 * 조직도 공석체크
	 * @return 
	 */
	public List<Map<String, Object>> selectOrgCnt() {
		return selectList("OrganizationMapper.selectOrgCnt");
	}

	/**
	 * 조직도 공석 넣기
	 * @return 
	 */
	public int insertOrgData() {
		return insert("OrganizationMapper.insertOrgData");
	}
	
	/**
	 * 조직도 공석 지우기
	 * @return 
	 */
	public int deleteOrgData() {
		return delete("OrganizationMapper.deleteOrgData");
	}
	
	/**
	 * 조직도 데이터 조회
	 * @return 
	 */
	public List<Map<String, Object>> selectOrganization(Map<String, Object> param) {
		return selectList("OrganizationMapper.selectOrganization", param);
	}
	
	
	/**
	 * 조직도 하위 데이터 조회
	 * @return 
	 */
	public List<Map<String, Object>> selectSubOrganization(Map<String, Object> param) {
		return selectList("OrganizationMapper.selectSubOrganization", param);
	}
	
	/**
	 * 조직도 하위 데이터 조회
	 * @return 
	 */
	public List<Map<String, Object>> selectDetailMember(Map<String, Object> param) {
		return selectList("OrganizationMapper.selectDetailMember", param);
	}
	

}
