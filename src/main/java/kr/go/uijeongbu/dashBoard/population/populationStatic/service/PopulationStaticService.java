package kr.go.uijeongbu.dashBoard.population.populationStatic.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 인구 - 인구통계 service 클래스
 * @author 김부권
 * @since 2021. 07. 19.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 07. 19.	        김 부 권              최초생성
 *   
 * </pre>
 */
public interface PopulationStaticService {
	
	/**
	 * 대시보드 인구 - 인구현황
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopStatus(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 인구현황 검색조건 
	 * @param param
	 * @return
	 */
	Map<String, Object> selectPopStaticDate();
	
	/**
	 * 대시보드 인구 - 총인구 추이 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopTotalTrend(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 연령별 인구현황 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopAgeStatus(Map<String, Object> param);

	List<Map<String, Object>> selectPopStatusDt(Map<String, Object> params);
	
	
}
