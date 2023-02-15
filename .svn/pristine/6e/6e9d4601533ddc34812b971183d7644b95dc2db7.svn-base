package kr.go.uijeongbu.dashBoard.weather.weatherStatus.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import kr.go.uijeongbu.cmm.util.CommonUtil;
import kr.go.uijeongbu.cmm.vo.LoginVO;
import kr.go.uijeongbu.dashBoard.weather.weatherStatus.service.WeatherStatusService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 대시보드 기상대기현황 - controller 클래스
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
@Controller
public class WeatherStatusController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherStatusController.class);
	
	@Resource(name = "weatherStatusService")
	private WeatherStatusService weatherStatusService;

	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	@Autowired
	private MappingJackson2JsonView jsonView;
	
	/**
	 * 기상대기현황  화면
	 * @param 
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dashBoard/weather/weatherStatus.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String populationMove(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		
		//데이터 존재하는 기간 조회
		Map<String, Object> date = weatherStatusService.selectWthrStatusDate();
		
		model.addAttribute("date", date);
		
		//메뉴코드
		String menuCode = "MENU_00027";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/weather/weatherStatus";
    }
	
	
	/**
	 * 대시보드 기상대기현황 페이지 데이터 로딩
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/weather/weatherStatusData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView weatherStatusData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);

		
		//기온 조회
		Map<String, Object> temperature = weatherStatusService.selectTemperatureData(params);
		//강수량 조회
		Map<String, Object> precipitation = weatherStatusService.selectPrecipitationData(params);
		//기타 데이터 조회
		Map<String, Object> airData = weatherStatusService.selectAirData(params);
		//미세먼지, 초미세먼지 그리드 데이터 조회
		List< Map<String, Object>> airGridData = weatherStatusService.selectAirGridData(params);
		//미세먼지 관측소 조회
		List< Map<String, Object>> pm10Obsrvty = weatherStatusService.selectPm10Obsrvty(params);
		//초미세먼지 관측소 조회
		List< Map<String, Object>> pm25Obsrvty = weatherStatusService.selectPm25Obsrvty(params);
		//미세먼지 관측소 날짜 조회
		List< Map<String, Object>> pm10ObsrDate = weatherStatusService.selectPm10ObsrDate(params);
		//초미세먼지 관측소 날짜 조회
		List< Map<String, Object>> pm25ObsrDate = weatherStatusService.selectPm25ObsrDate(params);
		
		modelAndView.addObject("temperature", temperature);
		modelAndView.addObject("precipitation", precipitation);
		modelAndView.addObject("airData", airData);
		modelAndView.addObject("airGridData", airGridData);
		modelAndView.addObject("pm10Obsrvty", pm10Obsrvty);
		modelAndView.addObject("pm25Obsrvty", pm25Obsrvty);
		modelAndView.addObject("pm10ObsrDate", pm10ObsrDate);
		modelAndView.addObject("pm25ObsrDate", pm25ObsrDate);
		
		return modelAndView;
		
	}
}
