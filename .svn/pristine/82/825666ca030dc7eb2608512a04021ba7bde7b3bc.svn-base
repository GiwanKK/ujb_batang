package kr.go.uijeongbu.dashBoard.population.populationMove.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 인구 - 전입전출 인구 service 클래스
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
public interface PopulationMoveService {
	
	/**
	 * 대시보드 인구 - 전입,전출 순이동 현황
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopMoveStatus(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 전입,전출 기간 검색
	 * @param param
	 * @return
	 */
	Map<String, Object> selectPopMoveDate();
	
	/**
	 * 대시보드 인구 - 전입 현황
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopIncomeStatus(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 전출 현황
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopOutcomeStatus(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 10년전 전입 전출 현황
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopMoveYearStatus(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 전입 전출 지도
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopMoveMapData(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 전입 전출 지도
	 * @param param
	 * @return
	 */
	Map<String, Object> selectPopMoveMap(Map<String, Object> param);
	
	
	/**
	 * 대시보드 인구 - 권외 전입 전출 지도
	 * @param param
	 * @return
	 */
	Map<String, Object> selectPopMoveSgguMap(Map<String, Object> param);
	
	
	/**
	 * 대시보드 인구 - 배경기본 지도
	 * @param param
	 * @return
	 */
	Map<String, Object> selectPopMoveDefaultMap(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 배경기본 지도
	 * @param param
	 * @return
	 */
	Map<String, Object> selectPopMoveUjbMap(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 전입 전출 지도 네추럴브레이크
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopMoveMapRange(Map<String, Object> param);
	
	/**
	 * 대시보드 인구 - 권외 전입 전출 지도 네추럴브레이크
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectPopMoveMapSggRange(Map<String, Object> param);
	
	
}
