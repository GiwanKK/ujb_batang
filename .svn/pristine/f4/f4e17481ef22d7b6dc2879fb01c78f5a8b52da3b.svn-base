package kr.go.uijeongbu.dashBoard.population.populationMove.web;

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
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 대시보드 인구 - 전입전출 인구 controller
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
@Controller
public class PopulationMoveController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PopulationMoveController.class);
	@Resource(name = "populationMoveService")
	private PopulationMoveService populationMoveService;

	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	@Autowired
	private MappingJackson2JsonView jsonView;
	
	/**
	 * 대시보드 메인 전입전출  화면
	 * @param 
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dashBoard/population/populationMove.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String populationMove(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		Map<String, Object> date = populationMoveService.selectPopMoveDate();
		
		model.addAttribute("date", date);		
		//메뉴코드
		String menuCode = "MENU_00021";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/population/populationMove";
		
    }
	
	/**
	 * 대시보드 메인 전입전출  권외 버튼 팝업화면
	 * @param 
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dashBoard/population/populationMovePopup.do")
	public String populationMovePopup(HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		String sort = request.getParameter("sort");
		String startDate = request.getParameter("startDate");
		/*Map<String, Object> params = new HashMap<String, Object>();
		params.put("sort", sort);
		List<Map<String, Object>> popMoveMapData = populationMoveService.selectPopMoveMapData(params);
		Map<String, Object> popMoveMap = populationMoveService.selectPopMoveMap(params);
		List<Map<String, Object>> popMoveMapRange = populationMoveService.selectPopMoveMapRange(params);*/
		//String name = populationMoveService.selectFranchiseName(code);

		
		/*model.addAttribute("popMoveMap", popMoveMap);
		model.addAttribute("popMoveMapData", popMoveMapData);
		model.addAttribute("popMoveMapRange", popMoveMapRange);*/
		model.addAttribute("sort", sort);
		model.addAttribute("startDate", startDate);
		return "/dashBoard/population/populationMovePopup";
		
	}
	
	/**
	 * 대시보드 전입전출 페이지 데이터 로딩
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/population/populationMoveData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView populationMoveData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		List<Map<String, Object>> popMoveStatus = populationMoveService.selectPopMoveStatus(params);
		List<Map<String, Object>> popIncomeStatus = populationMoveService.selectPopIncomeStatus(params);
		List<Map<String, Object>> popOutcomeStatus = populationMoveService.selectPopOutcomeStatus(params);
		List<Map<String, Object>> popMoveYear = populationMoveService.selectPopMoveYearStatus(params);
		//List<Map<String, Object>> popMoveMapData = populationMoveService.selectPopMoveMapData(params);
		Map<String, Object> popMoveMap = populationMoveService.selectPopMoveMap(params);
		//Map<String, Object> popMoveDefaultMap = populationMoveService.selectPopMoveDefaultMap(params);
		List<Map<String, Object>> popMoveMapRange = populationMoveService.selectPopMoveMapRange(params);
		
		modelAndView.addObject("popMoveStatus", popMoveStatus);
		modelAndView.addObject("popIncomeStatus", popIncomeStatus);
		modelAndView.addObject("popOutcomeStatus", popOutcomeStatus);
		modelAndView.addObject("popMoveYear", popMoveYear);
		modelAndView.addObject("popMoveMap", popMoveMap);
		//modelAndView.addObject("popMoveDefaultMap", popMoveDefaultMap);
		//modelAndView.addObject("popMoveMapData", popMoveMapData);
		modelAndView.addObject("popMoveMapRange", popMoveMapRange);
		//modelAndView.addObject("list", data.get("list"));
		//modelAndView.addObject("page", data.get("page"));
		
		return modelAndView;
		
	}
	
	/**
	 * 대시보드 권내 전입전출 지도 부분 검색
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/population/populationMoveChange.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView populationMoveChange(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		//List<Map<String, Object>> popMoveMapData = populationMoveService.selectPopMoveMapData(params);
		Map<String, Object> popMoveMap = populationMoveService.selectPopMoveMap(params);
		List<Map<String, Object>> popMoveMapRange = populationMoveService.selectPopMoveMapRange(params);
		Map<String, Object> popMoveDefaultMap = populationMoveService.selectPopMoveUjbMap(params);
		modelAndView.addObject("popMoveMap", popMoveMap);
		modelAndView.addObject("popMoveDefaultMap", popMoveDefaultMap);
		modelAndView.addObject("popMoveMapRange", popMoveMapRange);
		//modelAndView.addObject("list", data.get("list"));
		//modelAndView.addObject("page", data.get("page"));
		
		return modelAndView;
		
	}
	
	/**
	 * 대시보드 권외 전입전출 지도 부분 검색
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/population/populationMoveSggChange.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView populationMoveSggChange(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		//List<Map<String, Object>> popMoveMapData = populationMoveService.selectPopMoveMapData(params);
		Map<String, Object> popMoveMap = populationMoveService.selectPopMoveSgguMap(params);
		List<Map<String, Object>> popMoveMapRange = populationMoveService.selectPopMoveMapSggRange(params);
		Map<String, Object> popMoveDefaultMap = populationMoveService.selectPopMoveUjbMap(params);
		modelAndView.addObject("popMoveMap", popMoveMap);
		modelAndView.addObject("popMoveDefaultMap", popMoveDefaultMap);
		modelAndView.addObject("popMoveMapRange", popMoveMapRange);
		//modelAndView.addObject("list", data.get("list"));
		//modelAndView.addObject("page", data.get("page"));
		
		return modelAndView;
		
	}
}
