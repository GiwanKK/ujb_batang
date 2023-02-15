package kr.go.uijeongbu.dashBoard.population.populationMove.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.population.populationMove.service.PopulationMoveService;

/**
 * 대시보드 인구 - 전입전출 인구 serviceImpl 클래스
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

@Service("populationMoveService")
public class PopulationMoveServiceImpl implements PopulationMoveService {
	
	@Resource(name = "populationMoveMapper")
	private PopulationMoveMapper populationMoveMapper;

	@Override
	public List<Map<String, Object>> selectPopMoveStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopMoveStatus(param);
	}
	
	@Override
	public Map<String, Object> selectPopMoveDate() {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopMoveDate();
	}

	@Override
	public List<Map<String, Object>> selectPopIncomeStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopIncomeStatus(param);
	}

	@Override
	public List<Map<String, Object>> selectPopOutcomeStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopOutcomeStatus(param);
	}

	@Override
	public List<Map<String, Object>> selectPopMoveYearStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopMoveYearStatus(param);
	}
	
	@Override
	public List<Map<String, Object>> selectPopMoveMapData(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopMoveMapData(param);
	}
	
	@Override
	public Map<String, Object> selectPopMoveMap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopMoveMap(param);
	}
	
	@Override
	public Map<String, Object> selectPopMoveSgguMap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopMoveSgguMap(param);
	}
	
	@Override
	public Map<String, Object> selectPopMoveDefaultMap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopMoveDefaultMap(param);
	}
	
	@Override
	public Map<String, Object> selectPopMoveUjbMap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopMoveUjbMap(param);
	}
	
	@Override
	public List<Map<String, Object>> selectPopMoveMapRange(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopMoveMapRange(param);
	}
	
	@Override
	public List<Map<String, Object>> selectPopMoveMapSggRange(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return populationMoveMapper.selectPopMoveMapSggRange(param);
	}
	
	

}
