package kr.go.uijeongbu.dashBoard.population.populationFlow.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 인구 - 유동인구 mapper 클래스
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

@Repository("populationFlowMapper")
public class PopulationFlowMapper extends ComAbstractDAO {
	
	/**
	 * 대시보드 인구 - 유동인구 행정동별 시간대별 인구 조회
	 * @return
	 */
	public Map<String, Object> selectPopEmdTime(Map<String, Object> param) {
		return selectOne("PopulationFlowMapper.selectPopEmdTime", param);
	}
	
	/**
	 * 대시보드 인구 - 유동인구검색 기간
	 * @return
	 */
	public Map<String, Object> selectPopFlowDate() {
		return selectOne("PopulationFlowMapper.selectPopFlowDate");
	}
	
	/**
	 * 대시보드 인구 - 유동인구 행정동별 시간대별 인구 RANGE 조회
	 * @return
	 */
	public List<Map<String, Object>> selectPopEmdTimeRange(Map<String, Object> param) {
		return selectList("PopulationFlowMapper.selectPopEmdTimeRange", param);
	}
	
	/**
	 * 대시보드 인구 - 유동인구 요일별 유동인구 조회
	 * @return
	 */
	public List<Map<String, Object>> selectPopDayFlow(Map<String, Object> param) {
		return selectList("PopulationFlowMapper.selectPopDayFlow", param);
	}
	
	/**
	 * 대시보드 인구 - 유동인구 성 연령별 유동 인구 조회
	 * @return
	 */
	public List<Map<String, Object>> selectPopGenderFlow(Map<String, Object> param) {
		return selectList("PopulationFlowMapper.selectPopGenderFlow", param);
	}
	
	/**
	 * 대시보드 인구 - 유동인구 행정동별 시간대별 인구 조회
	 * @return
	 */
	public List<Map<String, Object>> selectPopRegService(Map<String, Object> param) {
		return selectList("PopulationFlowMapper.selectPopRegService", param);
	}

	

}
