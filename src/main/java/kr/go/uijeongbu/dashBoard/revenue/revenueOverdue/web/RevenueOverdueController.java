package kr.go.uijeongbu.dashBoard.revenue.revenueOverdue.web;

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
import kr.go.uijeongbu.dashBoard.revenue.revenueOverdue.service.RevenueOverdueService;
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
public class RevenueOverdueController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RevenueOverdueController.class);
	@Resource(name = "revenueOverdueService")
	private RevenueOverdueService revenueOverdueService;
	
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
	@RequestMapping(value = "/dashBoard/revenue/revenueOverdue.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String businessStatus(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		
		//검색기간 넣기
		Map<String, Object> date = revenueOverdueService.selectRevnOverdueDate();
		model.addAttribute("date",date);
		
		//메뉴코드
		String menuCode = "MENU_00031";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/revenue/revenueOverdue";
		
    }
	
	/**
	 * 세납 및 체납 대시보드 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/revenue/revenueOverdueData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView revenueOverdueData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		//체납 및 수납 현황 지도  데이터 조회
		Map<String, Object> revnOverdueMap = revenueOverdueService.selectRevnOverdueMap(params);
		//체납 및 수납 현황 테이블 데이터 조회
		List<Map<String, Object>> revnOverdueMapRange = revenueOverdueService.selectRevnOverdueMapRange(params);
		//체납 및 수납 현황 테이블 데이터 조회
		List<Map<String, Object>> revnOverdueTable = revenueOverdueService.selectRevnOverdueTable(params);
		//연도별 체납/수납 현황 데이터 조회
		List<Map<String, Object>> revnOverdueYear = revenueOverdueService.selectRevnOverdueYear(params);
		//세목별 체납/수납 현황  데이터 조회
		List<Map<String, Object>> revnOverdueStatus = revenueOverdueService.selectRevnOverdueStatus(params);
		Map<String, Object> defaultMap = populationMoveService.selectPopMoveDefaultMap(params);
		
		modelAndView.addObject("revnOverdueMap", revnOverdueMap);
		modelAndView.addObject("revnOverdueTable", revnOverdueTable);
		modelAndView.addObject("revnOverdueYear", revnOverdueYear);
		modelAndView.addObject("revnOverdueStatus", revnOverdueStatus);
		modelAndView.addObject("defaultMap", defaultMap);
		modelAndView.addObject("revnOverdueMapRange", revnOverdueMapRange);
		
		return modelAndView;
		
	}
	
	/**
	 * 세납 및 체납 대시보드 선택 및 검색 조건 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/revenue/revenueOverdueSearchData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView revenueOverdueSearchData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		//Map<String, Object> popEmdTime = financeExecutionService.selectPopEmdTime(params);
		//체납 및 수납 현황 테이블 데이터 조회
		List<Map<String, Object>> revnOverdueTable = revenueOverdueService.selectRevnOverdueTable(params);
		//연도별 체납/수납 현황 데이터 조회 x
		List<Map<String, Object>> revnOverdueYear = revenueOverdueService.selectRevnOverdueYear(params);
		//세목별 체납/수납 현황  데이터 조회
		List<Map<String, Object>> revnOverdueStatus = revenueOverdueService.selectRevnOverdueStatus(params);
		modelAndView.addObject("revnOverdueTable", revnOverdueTable);
		modelAndView.addObject("revnOverdueYear", revnOverdueYear);//x
		modelAndView.addObject("revnOverdueStatus", revnOverdueStatus);
		return modelAndView;
		
	}
	
}
