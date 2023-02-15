package kr.go.uijeongbu.dashBoard.welfare.welfareStatus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.population.populationMove.service.PopulationMoveService;
import kr.go.uijeongbu.dashBoard.welfare.welfareStatus.service.WelfareStatusService;

/**
 * 대시보드 복지현황 - serviceImpl 클래스
 * @author 김혜림
 * @since 2021. 08. 05.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 05.	        김 혜 림              최초생성
 *   
 * </pre>
 */

@Service("welfareStatusService")
public class WelfareStatusServiceImpl implements WelfareStatusService {
	
	@Resource(name = "welfareStatusMapper")
	private WelfareStatusMapper welfareStatusMapper;
	
	@Override
	public List<Map<String, Object>> selectAdmdArea(Map<String, Object> params) {
		return welfareStatusMapper.selectAdmdArea(params);
	}

	@Override
	public Map<String, Object> selectWfStatusDate() {
		return welfareStatusMapper.selectWfStatusDate();
	}

	@Override
	public List<Map<String, Object>> selectChildFacilStatus(Map<String, Object> params) {
		return welfareStatusMapper.selectChildFacilStatus(params);
	}

	@Override
	public List<Map<String, Object>> selectOldWfFacilStatus(Map<String, Object> params) {
		return welfareStatusMapper.selectOldWfFacilStatus(params);
	}

	@Override
	public List<Map<String, Object>> selectOldWfFacilRatio(Map<String, Object> params) {
		return welfareStatusMapper.selectOldWfFacilRatio(params);
	}

	@Override
	public List<Map<String, Object>> selectKndgnLimit(Map<String, Object> params) {
		return welfareStatusMapper.selectKndgnLimit(params);
	}

	@Override
	public List<Map<String, Object>> selectNurseryLimit(Map<String, Object> params) {
		return welfareStatusMapper.selectNurseryLimit(params);
	}

	@Override
	public List<Map<String, Object>> selectDisDegreeCnt(Map<String, Object> params) {
		return welfareStatusMapper.selectDisDegreeCnt(params);
	}

	@Override
	public List<Map<String, Object>> selectDisAgeCnt(Map<String, Object> params) {
		return welfareStatusMapper.selectDisAgeCnt(params);
	}

	@Override
	public Map<String, Object> selectDefaultMap(Map<String, Object> params) {
		return welfareStatusMapper.selectDefaultMap(params);
	}


}
