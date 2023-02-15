package kr.go.uijeongbu.dashBoard.city.cityStatistics.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.city.cityStatistics.service.CityStatisticsService;

/**
 * 대시보드 도시 통계 지표 - 도시통계지표 ServiceImpl클래스
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

@Service("cityStatisticsService")
public class CityStatisticsServiceImpl implements CityStatisticsService {
	
	@Resource(name = "cityStatisticsMapper")
	private CityStatisticsMapper cityStatisticsMapper;

	@Override
	public List<Map<String, Object>> selectCityStatisticsData(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return cityStatisticsMapper.selectCityStatisticsData(param);
	}
	
	@Override
	public int selectCityStatisticsCnt(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return cityStatisticsMapper.selectCityStatisticsCnt(param);
	}
	
	@Override
	public List<Map<String, Object>> selectCityStatisticsChart(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return cityStatisticsMapper.selectCityStatisticsChart(param);
	}

	@Override
	public Map<String, Object> selectCityStatisticstDate() {
		// TODO Auto-generated method stub
		return cityStatisticsMapper.selectCityStatisticstDate();
	}



}
