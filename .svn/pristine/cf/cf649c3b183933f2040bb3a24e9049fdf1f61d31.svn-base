package kr.go.uijeongbu.dashBoard.water.waterQuality.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.water.waterQuality.service.WaterQualityService;

/**
 * 대시보드 수질현황 - 수질 현황 ServiceImpl클래스
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

@Service("waterQualityService")
public class WaterQualityServiceImpl implements WaterQualityService {
	
	@Resource(name = "waterQualityMapper")
	private WaterQualityMapper waterQualityMapper;

	@Override
	public Map<String, Object> selectWaterQualityMap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return waterQualityMapper.selectWaterQualityMap(param);
	}
	
	@Override
	public List<Map<String, Object>> selectWaterQualityTotal(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return waterQualityMapper.selectWaterQualityTotal(param);
	}

	@Override
	public List<Map<String, Object>> selectWaterQualityStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return waterQualityMapper.selectWaterQualityStatus(param);
	}

	

}
