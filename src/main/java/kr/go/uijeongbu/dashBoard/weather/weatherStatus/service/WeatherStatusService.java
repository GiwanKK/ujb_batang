package kr.go.uijeongbu.dashBoard.weather.weatherStatus.service;

import java.util.List;
import java.util.Map;

/**
 * 대시보드 기상대기현황 - service 클래스
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
public interface WeatherStatusService {

	//데이터 존재하는 기간 조회
	Map<String, Object> selectWthrStatusDate();

	//기온 조회
	Map<String, Object> selectTemperatureData(Map<String, Object> params);

	//강수량 조회
	Map<String, Object> selectPrecipitationData(Map<String, Object> params);

	//기타 데이터 조회
	Map<String, Object> selectAirData(Map<String, Object> params);
	
	//미세먼지, 초미세먼지 그리드 데이터 조회
	List< Map<String, Object>> selectAirGridData(Map<String, Object> params);
	
	//미세먼지 관측소 조회
	List< Map<String, Object>> selectPm10Obsrvty(Map<String, Object> params);
	
	//초미세먼지 관측소 조회
	List< Map<String, Object>> selectPm25Obsrvty(Map<String, Object> params);
	
	//미세먼지 관측소 날짜 조회
	List< Map<String, Object>> selectPm10ObsrDate(Map<String, Object> params);
	
	//초미세먼지 관측소 날짜 조회
	List< Map<String, Object>> selectPm25ObsrDate(Map<String, Object> params);
	
}
