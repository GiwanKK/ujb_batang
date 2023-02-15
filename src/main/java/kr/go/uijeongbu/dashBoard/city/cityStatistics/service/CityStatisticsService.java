package kr.go.uijeongbu.dashBoard.city.cityStatistics.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 도시통계지표 - 도시통계지표 service 클래스
 * @author 김부권
 * @since 2021. 08. 18.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 18.	        김 부 권              최초생성
 *   
 * </pre>
 */


public interface CityStatisticsService {
	
	/**
	 * 대시보드 대시보드 도시통계지표 - 대시보드 도시통계지표  데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCityStatisticsData(Map<String, Object> param);
	
	/**
	 * 대시보드 대시보드 도시통계지표 - 대시보드 도시통계지표  데이터 갯수 조회
	 * @param param
	 * @return
	 */
	int selectCityStatisticsCnt(Map<String, Object> param);
	
	
	/**
	 * 대시보드 도시통계지표 - 도시통계지표 차트 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCityStatisticsChart(Map<String, Object> param);
	
	/**
	 * 대시보드 도시통계지표 - 검색조건 날짜
	 * @param param
	 * @return
	 */
	Map<String, Object> selectCityStatisticstDate();
	
	
}
