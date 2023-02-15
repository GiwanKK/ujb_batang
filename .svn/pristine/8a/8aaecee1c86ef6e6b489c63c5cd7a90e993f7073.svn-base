package kr.go.uijeongbu.dashBoard.population.populationFlow.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 인구 - 유동인구 service 클래스
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
public interface PopulationFlowService {
	
	/**
	 * 대시보드 인구 - 유동인구 행정동별 시간대별 인구 조회
	 * @param param
	 * @return
	 */
	Map<String, Object> selectPopEmdTime(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 유동인구 검색기간
	 * @param param
	 * @return
	 */
	Map<String, Object> selectPopFlowDate();
	
	/**
	 * 대시보드 인구 - 유동인구 행정동별 시간대별 인구 RANGE 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopEmdTimeRange(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 유동인구 요일별 인구 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopDayFlow(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 유동인구 성 연령별 유동 인구 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopGenderFlow(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 유동인구 행정동별 시간대별 인구 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopRegService(Map<String, Object> param);
	
	
}
