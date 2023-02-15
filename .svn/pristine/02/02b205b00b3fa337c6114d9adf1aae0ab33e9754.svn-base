package kr.go.uijeongbu.dashBoard.water.waterQuality.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 수질현황 - 수질 현황 mapper 클래스
 * @author 김부권
 * @since 2021. 08. 11.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 11.	        김 부 권              최초생성
 *   
 * </pre>
 */

@Repository("waterQualityMapper")
public class WaterQualityMapper extends ComAbstractDAO {
	
	/**
	 * 대시보드 수질현황 지도
	 * @return
	 */
	public Map<String, Object> selectWaterQualityMap(Map<String, Object> param) {
		return selectOne("WaterQualityMapper.selectWaterQualityMap", param);
	}
	
	/**
	 * 대시보드 누적 통계 수질 
	 * @return
	 */
	public List<Map<String, Object>> selectWaterQualityTotal(Map<String, Object> param) {
		return selectList("WaterQualityMapper.selectWaterQualityTotal", param);
	}
	
	/**
	 * 대시보드 수질 현황 
	 * @return
	 */
	public List<Map<String, Object>> selectWaterQualityStatus(Map<String, Object> param) {
		return selectList("WaterQualityMapper.selectWaterQualityStatus", param);
	}
	
}
