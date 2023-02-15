package kr.go.uijeongbu.dashBoard.calamity.calamityStatus.web;

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
import kr.go.uijeongbu.dashBoard.calamity.calamityStatus.service.CalamityStatusService;
import kr.go.uijeongbu.dashBoard.population.populationMove.service.PopulationMoveService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 재난현황 대시보드 controller
 * @author 김부권
 * @since 2021. 08. 17.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 17.	        김 부 권              최초생성
 *   
 * </pre>
 */
@Controller
public class CalamityStatusController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalamityStatusController.class);
	@Resource(name = "calamityStatusService")
	private CalamityStatusService calamityStatusService;
	
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
	@RequestMapping(value = "/dashBoard/calamity/calamityStatus.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String businessStatus(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		//메뉴코드
		String menuCode = "MENU_00035";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/calamity/calamityStatus";
		
    }
	
	/**
	 * 재난 현황 대시보드 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/calamity/calamityStatusData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView calamityStatusData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		//의정부시 행정동 경계 데이터 조회
		Map<String, Object> calaAdmdMap = calamityStatusService.selectCalaAdmdMap(params);
		//재난 돌발상황정보 데이터 조회
		Map<String, Object> calaStatusMap = calamityStatusService.selectCalaStatusMap(params);
		//재난 돌발상황정보 텍스트 데이터 조회
		List<Map<String, Object>> calaStatusData = calamityStatusService.selectCalaStatusData(params);
		//재난 유형별 구조수 데이터 조회
		List<Map<String, Object>> calaCaseCnt = calamityStatusService.selectCalaCaseCnt(params);
		//재난 발화장소별 화재 발생 누적현황 데이터 조회
		List<Map<String, Object>> calaPlaceTotal = calamityStatusService.selectCalaPlaceTotal(params);
		//재난 발화요인별 화재 발생 누적현황 데이터 조회
		List<Map<String, Object>> calaFactorTotal = calamityStatusService.selectCalaFactorTotal(params);
		
		Map<String, Object> defaultMap = populationMoveService.selectPopMoveDefaultMap(params);
		modelAndView.addObject("calaStatusMap", calaStatusMap);
		modelAndView.addObject("calaAdmdMap", calaAdmdMap);
		modelAndView.addObject("defaultMap", defaultMap);
		modelAndView.addObject("calaStatusData", calaStatusData);
		modelAndView.addObject("calaCaseCnt", calaCaseCnt);
		modelAndView.addObject("calaPlaceTotal", calaPlaceTotal);
		modelAndView.addObject("calaFactorTotal", calaFactorTotal);
		
		return modelAndView;
		
	}
	
}
