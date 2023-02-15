package kr.go.uijeongbu.dashBoard.population.populationStatic.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.population.populationStatic.service.PopulationStaticService;

/**
 * 대시보드 인구 - 인구통계 serviceImpl 클래스
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

@Service("populationService")
public class PopulationStaticServiceImpl implements PopulationStaticService {
	
	@Resource(name = "populationStaticMapper")
	private PopulationStaticMapper populationStaticMapper;

	@Override
	public List<Map<String, Object>> selectPopStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationStaticMapper.selectPopStatus(param);
	}
	
	@Override
	public Map<String, Object> selectPopStaticDate() {
		// TODO Auto-generated method stub
		return populationStaticMapper.selectPopStaticDate();
	}

	@Override
	public List<Map<String, Object>> selectPopTotalTrend(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationStaticMapper.selectPopTotalTrend(param);
	}

	@Override
	public List<Map<String, Object>> selectPopAgeStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationStaticMapper.selectPopAgeStatus(param);
	}

	@Override
	public List<Map<String, Object>> selectPopStatusDt(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return populationStaticMapper.selectPopStatusDt(params);
	}
	



}
