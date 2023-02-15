package kr.go.uijeongbu.dashBoard.calamity.calamityStatus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.business.businessStatus.service.BusinessStatusService;
import kr.go.uijeongbu.dashBoard.calamity.calamityStatus.service.CalamityStatusService;

/**
 * 대시보드 재난 - 재난 현황 ServiceImpl클래스
 * @author 김부권
 * @since 2021. 08. 17.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 17.	        김 부 권              최초생성
 *   
 * </pre>
 */

@Service("calamityStatusService")
public class CalamityStatusServiceImpl implements CalamityStatusService {
	
	@Resource(name = "calamityStatusMapper")
	private CalamityStatusMapper calamityStatusMapper;

	
	@Override
	public Map<String, Object> selectCalaAdmdMap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return calamityStatusMapper.selectCalaAdmdMap(param);
	}

	@Override
	public Map<String, Object> selectCalaStatusMap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return calamityStatusMapper.selectCalaStatusMap(param);
	}
	
	@Override
	public List<Map<String, Object>> selectCalaStatusData(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return calamityStatusMapper.selectCalaStatusData(param);
	}

	@Override
	public List<Map<String, Object>> selectCalaCaseCnt(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return calamityStatusMapper.selectCalaCaseCnt(param);
	}

	@Override
	public List<Map<String, Object>> selectCalaPlaceTotal(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return calamityStatusMapper.selectCalaPlaceTotal(param);
	}

	@Override
	public List<Map<String, Object>> selectCalaFactorTotal(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return calamityStatusMapper.selectCalaFactorTotal(param);
	}




	


}
