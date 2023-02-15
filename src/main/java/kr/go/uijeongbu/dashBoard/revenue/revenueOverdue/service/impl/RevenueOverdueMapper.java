package kr.go.uijeongbu.dashBoard.revenue.revenueOverdue.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 세입현황 - 체납 및 수납 현황 mapper 클래스
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

@Repository("revenueOverdueMapper")
public class RevenueOverdueMapper extends ComAbstractDAO {
	
	/**
	 * 대시보드 체납 수납 현황 검색기간
	 * @return
	 */
	public Map<String, Object> selectRevnOverdueDate() {
		return selectOne("RevenueOverdueMapper.selectRevnOverdueDate");
	}
	
	
	/**
	 * 대시보드 체납 및 수납 현황 지도 구간값
	 * @return
	 */
	public List<Map<String, Object>> selectRevnOverdueMapRange(Map<String, Object> param) {
		return selectList("RevenueOverdueMapper.selectRevnOverdueMapRange", param);
	}
	
	/**
	 * 대시보드 체납 및 수납 현황 지도 
	 * @return
	 */
	public Map<String, Object> selectRevnOverdueMap(Map<String, Object> param) {
		return selectOne("RevenueOverdueMapper.selectRevnOverdueMap", param);
	}
	
	
	/**
	 * 대시보드 체납 및 수납 현황 테이블 
	 * @return
	 */
	public List<Map<String, Object>> selectRevnOverdueTable(Map<String, Object> param) {
		return selectList("RevenueOverdueMapper.selectRevnOverdueTable", param);
	}
	
	
	/**
	 * 대시보드 체납 및 수납 현황 - 연도별 체납/수납 현황
	 * @return
	 */
	public List<Map<String, Object>> selectRevnOverdueYear(Map<String, Object> param) {
		return selectList("RevenueOverdueMapper.selectRevnOverdueYear", param);
	}
	
	
	/**
	 * 대시보드 체납 및 수납 현황 - 세목별 체납/수납 현황
	 * @return
	 */
	public List<Map<String, Object>> selectRevnOverdueStatus(Map<String, Object> param) {
		return selectList("RevenueOverdueMapper.selectRevnOverdueStatus", param);
	}
	
	
	
	

	

}
