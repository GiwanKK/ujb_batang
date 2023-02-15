package kr.go.uijeongbu.dashBoard.water.waterQuality.web;

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
import kr.go.uijeongbu.dashBoard.population.populationMove.service.PopulationMoveService;
import kr.go.uijeongbu.dashBoard.water.waterQuality.service.WaterQualityService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 세납 및 체납 대시보드 controller
 * @author 김부권
 * @since 2021. 08. 09.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 09.	        김 부 권              최초생성
 *   
 * </pre>
 */
@Controller
public class WaterQualityController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WaterQualityController.class);
	@Resource(name = "waterQualityService")
	private WaterQualityService waterQualityService;
	@Resource(name = "populationMoveService")
	private PopulationMoveService populationMoveService;
	
	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	@Autowired
	private MappingJackson2JsonView jsonView;
	
	/**
	 * 메인 화면
	 * @param 
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dashBoard/water/waterQuality.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String waterQuality(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		
		//메뉴코드
		String menuCode = "MENU_00032";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/water/waterQuality";
		
    }
	
	/**
	 * 수질현황 대시보드 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/water/waterQualityData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView waterQualityData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		//수질현황 지도  데이터 조회
		Map<String, Object> waterQualityMap = waterQualityService.selectWaterQualityMap(params);
		//수질 현황 데이터 조회
		List<Map<String, Object>> waterQualityStatus = waterQualityService.selectWaterQualityStatus(params);
		//수질 누적 통계 데이터 조회
		List<Map<String, Object>> waterQualityTotal = waterQualityService.selectWaterQualityTotal(params);
		//Map<String, Object> defaultMap = populationMoveService.selectPopMoveDefaultMap(params);
		modelAndView.addObject("waterQualityMap", waterQualityMap);
		modelAndView.addObject("waterQualityStatus", waterQualityStatus);
		modelAndView.addObject("waterQualityTotal", waterQualityTotal);
		//modelAndView.addObject("defaultMap", defaultMap);
		
		return modelAndView;
		
	}
	
	/**
	 * 수질현황 대시보드 데이터 검색 조건 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/water/waterQualitySearchData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView waterQualitySearchData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);

		//수질 누적 통계 데이터 조회
		List<Map<String, Object>> waterQualityTotal = waterQualityService.selectWaterQualityTotal(params);
		modelAndView.addObject("waterQualityTotal", waterQualityTotal);
		
		return modelAndView;
		
	}
	
}
