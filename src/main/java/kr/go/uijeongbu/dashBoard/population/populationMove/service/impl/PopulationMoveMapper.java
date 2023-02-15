package kr.go.uijeongbu.dashBoard.population.populationMove.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 인구 - 전입전출 인구 mapper 클래스
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

@Repository("populationMoveMapper")
public class PopulationMoveMapper extends ComAbstractDAO {
	
	/**
	 * 대시보드 인구 - 전입전출 순이동 현황
	 * @return
	 */
	public List<Map<String, Object>> selectPopMoveStatus(Map<String, Object> param) {
		return selectList("PopulationMoveMapper.selectPopMoveStatus", param);
	}
	
	/**
	 * 대시보드 인구 - 전입전출 검색기간
	 * @return
	 */
	public Map<String, Object> selectPopMoveDate() {
		return selectOne("PopulationMoveMapper.selectPopMoveDate");
	}
	
	/**
	 * 대시보드 인구 - 전입 현황
	 * @return
	 */
	public List<Map<String, Object>> selectPopIncomeStatus(Map<String, Object> param) {
		return selectList("PopulationMoveMapper.selectPopIncomeStatus", param);
	}
	
	/**
	 * 대시보드 인구 - 전출 현황
	 * @return
	 */
	public List<Map<String, Object>> selectPopOutcomeStatus(Map<String, Object> param) {
		return selectList("PopulationMoveMapper.selectPopOutcomeStatus", param);
	}
	
	/**
	 * 대시보드 인구 - 10년 전입, 전출 현황
	 * @return
	 */
	public List<Map<String, Object>> selectPopMoveYearStatus(Map<String, Object> param) {
		return selectList("PopulationMoveMapper.selectPopMoveYearStatus", param);
	}
	
	/**
	 * 대시보드 인구 -  전입, 전출 지도
	 * @return
	 */
	public List<Map<String, Object>> selectPopMoveMapData(Map<String, Object> param) {
		return selectList("PopulationMoveMapper.selectPopMoveMapData", param);
	}
	
	/**
	 * 대시보드 인구 -  전입, 전출 지도 네추럴 브레이크
	 * @return
	 */
	public Map<String, Object> selectPopMoveMap(Map<String, Object> param) {
		return selectOne("PopulationMoveMapper.selectPopMoveMap", param);
	}
	
	
	/**
	 * 대시보드 인구 -  전입, 전출 지도 네추럴 브레이크
	 * @return
	 */
	public Map<String, Object> selectPopMoveSgguMap(Map<String, Object> param) {
		return selectOne("PopulationMoveMapper.selectPopMoveSgguMap", param);
	}
	
	
	/**
	 * 대시보드 인구 -  전입, 전출 지도 네추럴 브레이크
	 * @return
	 */
	public Map<String, Object> selectPopMoveDefaultMap(Map<String, Object> param) {
		return selectOne("PopulationMoveMapper.selectPopMoveDefaultMap", param);
	}
	
	/**
	 * 대시보드 인구 -  전입, 전출 지도 네추럴 브레이크
	 * @return
	 */
	public Map<String, Object> selectPopMoveUjbMap(Map<String, Object> param) {
		return selectOne("PopulationMoveMapper.selectPopMoveUjbMap", param);
	}
	
	/**
	 * 대시보드 인구 -  전입, 전출 지도
	 * @return
	 */
	public List<Map<String, Object>> selectPopMoveMapRange(Map<String, Object> param) {
		return selectList("PopulationMoveMapper.selectPopMoveMapRange", param);
	}
	
	/**
	 * 대시보드 인구 - 권외 전입, 전출 지도
	 * @return
	 */
	public List<Map<String, Object>> selectPopMoveMapSggRange(Map<String, Object> param) {
		return selectList("PopulationMoveMapper.selectPopMoveMapSggRange", param);
	}

	

}
