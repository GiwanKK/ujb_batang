package kr.go.uijeongbu.dashBoard.revenue.revenueOverdue.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 세입현황 - 세납 및 체납 현황 service 클래스
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


public interface RevenueOverdueService {
	
	/**
	 * 대시보드 체납 수납 현황 검색기간
	 * @param param
	 * @return
	 */
	Map<String, Object> selectRevnOverdueDate();
	
	/**
	 * 대시보드 체납 및 수납 현황 - 연도별 체납/수납 현황
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectRevnOverdueYear(Map<String, Object> param);
	
	/**
	 * 대시보드 체납 및 수납 현황 - 체납 및 수납 현황 지도 범례값
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectRevnOverdueMapRange(Map<String, Object> param);
	
	/**
	 * 대시보드 체납 및 수납 현황 - 체납 및 수납 현황 지도 테이블
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectRevnOverdueTable(Map<String, Object> param);
	
	/**
	 * 대시보드 체납 및 수납 현황 지도 
	 * @param param
	 * @return
	 */
	Map<String, Object> selectRevnOverdueMap(Map<String, Object> param);
	
	/**
	 * 대시보드 체납 및 수납 현황 - 세목별 체납/수납 현황
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectRevnOverdueStatus(Map<String, Object> param);
	
	
	
}
