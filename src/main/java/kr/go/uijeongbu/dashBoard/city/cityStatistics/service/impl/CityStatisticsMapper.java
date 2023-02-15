package kr.go.uijeongbu.dashBoard.city.cityStatistics.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 도시 통계 지표 - 도시통계지표 mapper 클래스
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

@Repository("cityStatisticsMapper")
public class CityStatisticsMapper extends ComAbstractDAO {
	
	/**
	 * 대시보드 도시통계지표
	 * @return
	 */
	public List<Map<String, Object>> selectCityStatisticsData(Map<String, Object> param) {
		return selectList("CityStatisticsMapper.selectCityStatisticsData", param);
	}
	
	
	/**
	 * 대시보드 도시통계지표 갯수
	 * @return
	 */
	public int selectCityStatisticsCnt(Map<String, Object> param) {
		return selectOne("CityStatisticsMapper.selectCityStatisticsCnt",param);
	}
	
	
	/**
	 * 대시보드 도시통계지표 차트 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectCityStatisticsChart(Map<String, Object> param) {
		return selectList("CityStatisticsMapper.selectCityStatisticsChart", param);
	}


	public Map<String, Object> selectCityStatisticstDate() {
		// TODO Auto-generated method stub
		return selectOne("CityStatisticsMapper.selectCityStatisticstDate");
	}
	

	

}
