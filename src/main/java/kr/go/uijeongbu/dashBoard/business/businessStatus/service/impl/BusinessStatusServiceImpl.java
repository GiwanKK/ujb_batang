package kr.go.uijeongbu.dashBoard.business.businessStatus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.business.businessStatus.service.BusinessStatusService;

/**
 * 대시보드 사업추진 - 사업추진 현황 ServiceImpl클래스
 * @author 김부권
 * @since 2021. 08. 09.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  ----------9.	        김 부 권              최초생성
 *   
 * </pre>
 */

@Service("businessStatusService")
public class BusinessStatusServiceImpl implements BusinessStatusService {
	
	@Resource(name = "businessStatusMapper")
	private BusinessStatusMapper businessStatusMapper;

	@Override
	public Map<String, Object> selectBusiStatusDate() {
		// TODO Auto-generated method stub
		return businessStatusMapper.selectBusiStatusDate();
	}

	@Override
	public List<Map<String, Object>> selectBusiStatusHoep(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return businessStatusMapper.selectBusiStatusHoep(param);
	}

	@Override
	public List<Map<String, Object>> selectBusiStatusTrans(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return businessStatusMapper.selectBusiStatusTrans(param);
	}

	@Override
	public List<Map<String, Object>> selectBusiStatusEducation(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return businessStatusMapper.selectBusiStatusEducation(param);
	}

	@Override
	public List<Map<String, Object>> selectBusiStatusWelfare(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return businessStatusMapper.selectBusiStatusWelfare(param);
	}

	@Override
	public List<Map<String, Object>> selectBusiStatusPublic(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return businessStatusMapper.selectBusiStatusPublic(param);
	}
	
	@Override
	public Map<String, Object> selectBusiStatusLoad(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return businessStatusMapper.selectBusiStatusLoad(param);
	}



	


}
