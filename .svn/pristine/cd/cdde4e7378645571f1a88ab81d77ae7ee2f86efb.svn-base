package kr.go.uijeongbu.dashBoard.revenue.revenueStatus.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 세입현황 - 세입 현황 service 클래스
 * @author 김부권
 * @since 2021. 08. 09.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 09.	        김 부 권              최초생성
 *   
 * </pre>
 */


public interface RevenueStatusService {
	
	/**
	 * 대시보드 세입징수현황 - 세입징수현황 대시보드 검색기간  조회
	 * @param param
	 * @return
	 */
	Map<String, Object> selectRevntatusDate();
	
	/**
	 * 대시보드 세입징수현황 - 세입징수현황차트  데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectRevnStatusChart(Map<String, Object> param);
	
	/**
	 * 대시보드 세입징수현황 - 세입징수현황차트  데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectRevnStatusChartSub(Map<String, Object> param);
	
	/**
	 * 대시보드 세입징수현황 - 세입징수현황  데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectRevnStatus(Map<String, Object> param);
	
	/**
	 * 대시보드 세입징수현황 - 연도별 세입징수 추이 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectRevnStatusYear(Map<String, Object> param);
	
	/**
	 * 대시보드 세입징수현황 - 항목별 세입징수 현황 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectRevnStatusMain(Map<String, Object> param);
	
	/**
	 * 대시보드 세입징수현황 - 전년대비 세목별 세입징수 현황 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectRevnStatusSub(Map<String, Object> param);
	
	
	
}
