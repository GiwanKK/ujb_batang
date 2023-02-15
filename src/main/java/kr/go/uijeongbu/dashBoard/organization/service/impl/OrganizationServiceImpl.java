package kr.go.uijeongbu.dashBoard.organization.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.organization.service.OrganizationService;

/**
 * 조직도 serviceImpl 클래스
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

@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {
	
	@Resource(name = "organizationMapper")
	private OrganizationMapper organizationMapper;
	
	
	@Override
	public List<Map<String, Object>> selectOrganization(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return organizationMapper.selectOrganization(param);
	}
	
	@Override
	public List<Map<String, Object>> selectSubOrganization(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return organizationMapper.selectSubOrganization(param);
	}
	
	@Override
	public List<Map<String, Object>> selectDetailMember(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return organizationMapper.selectDetailMember(param);
	}

	@Override
	public List<Map<String, Object>> selectOrgCnt() {
		// TODO Auto-generated method stub
		return organizationMapper.selectOrgCnt();
	}

	@Override
	public int insertOrgData() {
		// TODO Auto-generated method stub
		return organizationMapper.insertOrgData();
	}

	@Override
	public int deleteOrgData() {
		// TODO Auto-generated method stub
		return organizationMapper.deleteOrgData();
	}


}
