package kr.go.uijeongbu.dashBoard.weather.weatherStatus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 기상대기현황 - mapper 클래스
 * @author 김혜림
 * @since 2021. 08. 05.
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

@Repository("weatherStatusMapper")
public class WeatherStatusMapper extends ComAbstractDAO {


	//데이터 존재하는 기간 조회
	public Map<String, Object> selectWthrStatusDate() {
		return selectOne("WeatherStatusMapper.selectWthrStatusDate");
	}
	
	//기온 조회
	public Map<String, Object> selectTemperatureData(Map<String, Object> params) {
		return selectOne("WeatherStatusMapper.selectTemperatureData", params);
	}
	
	//강수량 조회
	public Map<String, Object> selectPrecipitationData(Map<String, Object> params) {
		return selectOne("WeatherStatusMapper.selectPrecipitationData", params);
	}
	
	//기타 데이터 조회
	public Map<String, Object> selectAirData(Map<String, Object> params) {
		return selectOne("WeatherStatusMapper.selectAirData", params);
	}
	
	//미세먼지, 초미세먼지 그리드 데이터 조회
	public List< Map<String, Object>> selectAirGridData(Map<String, Object> params) {
		return selectList("WeatherStatusMapper.selectAirGridData", params);
	}
	
	//미세먼지 관측소 조회
	public List< Map<String, Object>> selectPm10Obsrvty(Map<String, Object> params) {
		return selectList("WeatherStatusMapper.selectPm10Obsrvty", params);
	}

	//초미세먼지 관측소 조회
	public List< Map<String, Object>> selectPm25Obsrvty(Map<String, Object> params) {
		return selectList("WeatherStatusMapper.selectPm25Obsrvty", params);
	}
	
	//미세먼지 관측소 날짜 조회
	public List< Map<String, Object>> selectPm10ObsrDate(Map<String, Object> params) {
		return selectList("WeatherStatusMapper.selectPm10ObsrDate", params);
	}
	
	//초미세먼지 관측소 날짜 조회
	public List< Map<String, Object>> selectPm25ObsrDate(Map<String, Object> params) {
		return selectList("WeatherStatusMapper.selectPm25ObsrDate", params);
	}
	
	
}
