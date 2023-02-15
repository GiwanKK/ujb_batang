package kr.go.uijeongbu.dashBoard.revenue.revenueStatus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 세입현황 - 세입현황 현황 mapper 클래스
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

@Repository("revenueStatusMapper")
public class RevenueStatusMapper extends ComAbstractDAO {
	
	/**
	 * 대시보드 세입징수현황  - 세입징수현황  대시보드 검색기간  조회
	 * @return
	 */
	public Map<String, Object> selectRevntatusDate() {
		return selectOne("RevenueStatusMapper.selectRevntatusDate");
	}
	
	
	/**
	 * 대시보드 세입징수현황 - 세입징수현황   데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectRevnStatus(Map<String, Object> param) {
		return selectList("RevenueStatusMapper.selectRevnStatus", param);
	}
	
	/**
	 * 대시보드 세입징수현황 - 세입징수현황차트   데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectRevnStatusChart(Map<String, Object> param) {
		return selectList("RevenueStatusMapper.selectRevnStatusChart", param);
	}
	
	/**
	 * 대시보드 세입징수현황 - 세입징수현황차트   데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectRevnStatusChartSub(Map<String, Object> param) {
		return selectList("RevenueStatusMapper.selectRevnStatusChartSub", param);
	}
	
	
	/**
	 * 대시보드 세입징수현황 - 연도별 세입징수 추이 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectRevnStatusYear(Map<String, Object> param) {
		return selectList("RevenueStatusMapper.selectRevnStatusYear", param);
	}
	
	
	/**
	 * 대시보드 세입징수현황 - 항목별 세입징수 현황 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectRevnStatusMain(Map<String, Object> param) {
		return selectList("RevenueStatusMapper.selectRevnStatusMain", param);
	}
	
	
	/**
	 * 대시보드 세입징수현황 - 전년대비 세목별 세입징수 현황  데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectRevnStatusSub(Map<String, Object> param) {
		return selectList("RevenueStatusMapper.selectRevnStatusSub", param);
	}
	

	

}
