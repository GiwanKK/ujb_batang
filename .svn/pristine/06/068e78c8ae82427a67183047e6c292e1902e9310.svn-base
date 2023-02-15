package kr.go.uijeongbu.dashBoard.weather.weatherStatus.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.population.populationMove.service.PopulationMoveService;
import kr.go.uijeongbu.dashBoard.weather.weatherStatus.service.WeatherStatusService;
import kr.go.uijeongbu.dashBoard.welfare.welfareStatus.service.WelfareStatusService;

/**
 * 대시보드 기상대기현황 - serviceImpl 클래스
 * @author 김혜림
 * @since 2021. 08. 11.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 11.	        김 혜 림              최초생성
 *   
 * </pre>
 */

@Service("weatherStatusService")
public class WeatherStatusServiceImpl implements WeatherStatusService {
	
	@Resource(name = "weatherStatusMapper")
	private WeatherStatusMapper weatherStatusMapper;


	@Override
	public Map<String, Object> selectWthrStatusDate() {
		return weatherStatusMapper.selectWthrStatusDate();
	}


	@Override
	public Map<String, Object> selectTemperatureData(Map<String, Object> params) {
		return weatherStatusMapper.selectTemperatureData(params);
	}


	@Override
	public Map<String, Object> selectPrecipitationData(Map<String, Object> params) {
		return weatherStatusMapper.selectPrecipitationData(params);
	}

	@Override
	public Map<String, Object> selectAirData(Map<String, Object> params) {
		return weatherStatusMapper.selectAirData(params);
	}
	
	@Override
	public List< Map<String, Object>> selectAirGridData(Map<String, Object> params) {
		return weatherStatusMapper.selectAirGridData(params);
	}
	
	@Override
	public List< Map<String, Object>> selectPm10Obsrvty(Map<String, Object> params) {
		return weatherStatusMapper.selectPm10Obsrvty(params);
	}
	
	@Override
	public List< Map<String, Object>> selectPm25Obsrvty(Map<String, Object> params) {
		return weatherStatusMapper.selectPm25Obsrvty(params);
	}
	
	@Override
	public List< Map<String, Object>> selectPm10ObsrDate(Map<String, Object> params) {
		return weatherStatusMapper.selectPm10ObsrDate(params);
	}
	
	@Override
	public List< Map<String, Object>> selectPm25ObsrDate(Map<String, Object> params) {
		return weatherStatusMapper.selectPm25ObsrDate(params);
	}
}
