package kr.go.uijeongbu.dashBoard.water.waterQuality.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 수질현황 - 수질 현황 service 클래스
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


public interface WaterQualityService {
	
	
	/**
	 * 대시보드 수질 현황 - 수질현황 지도
	 * @param param
	 * @return
	 */
	Map<String, Object> selectWaterQualityMap(Map<String, Object> param);
	
	/**
	 * 대시보드 수질 현황 - 수질 현황
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectWaterQualityStatus(Map<String, Object> param);
	
	/**
	 * 대시보드 수질 현황 - 누적 통계 수질
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectWaterQualityTotal(Map<String, Object> param);
	
	
}
