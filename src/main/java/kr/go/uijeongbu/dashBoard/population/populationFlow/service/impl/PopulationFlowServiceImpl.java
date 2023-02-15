package kr.go.uijeongbu.dashBoard.population.populationFlow.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.population.populationFlow.service.PopulationFlowService;

/**
 * 대시보드 인구 - 유동인구 ServiceImpl클래스
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

@Service("populationFlowService")
public class PopulationFlowServiceImpl implements PopulationFlowService {
	
	@Resource(name = "populationFlowMapper")
	private PopulationFlowMapper populationFlowMapper;

	@Override
	public Map<String, Object> selectPopEmdTime(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationFlowMapper.selectPopEmdTime(param);
	}
	
	@Override
	public Map<String, Object> selectPopFlowDate() {
		// TODO Auto-generated method stub
		return populationFlowMapper.selectPopFlowDate();
	}
	
	@Override
	public List<Map<String, Object>> selectPopEmdTimeRange(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationFlowMapper.selectPopEmdTimeRange(param);
	}

	@Override
	public List<Map<String, Object>> selectPopDayFlow(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationFlowMapper.selectPopDayFlow(param);
	}

	@Override
	public List<Map<String, Object>> selectPopGenderFlow(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationFlowMapper.selectPopGenderFlow(param);
	}

	@Override
	public List<Map<String, Object>> selectPopRegService(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationFlowMapper.selectPopRegService(param);
	}

}
