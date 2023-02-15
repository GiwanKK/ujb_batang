package kr.go.uijeongbu.dashBoard.population.populationStatic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 인구 - 인구통계 mapper 클래스
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
@Repository("populationStaticMapper")
public class PopulationStaticMapper extends ComAbstractDAO {
	
	/**
	 * 대시보드 인구 - 인구현황
	 * @return
	 */
	public List<Map<String, Object>> selectPopStatus(Map<String, Object> param) {
		return selectList("PopulationStaticMapper.selectPopStatus", param);
	}
	
	/**
	 * 대시보드 인구 - 인구현황 검색조건
	 * @return
	 */
	public Map<String, Object> selectPopStaticDate() {
		return selectOne("PopulationStaticMapper.selectPopStaticDate");
	}
	
	/**
	 * 대시보드 인구 - 총인구 추이
	 * @return
	 */
	public List<Map<String, Object>> selectPopTotalTrend(Map<String, Object> param) {
		return selectList("PopulationStaticMapper.selectPopTotalTrend", param);
	}
	
	/**
	 * 대시보드 인구 - 연령별 인구현황
	 * @return
	 */
	public List<Map<String, Object>> selectPopAgeStatus(Map<String, Object> param) {
		return selectList("PopulationStaticMapper.selectPopAgeStatus", param);
	}

	public List<Map<String, Object>> selectPopStatusDt(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return selectList("PopulationStaticMapper.selectPopStatusDt", params);
	}

	

}
