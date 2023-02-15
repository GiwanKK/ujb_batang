package kr.go.uijeongbu.dashBoard.revenue.revenueStatus.web;

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
import kr.go.uijeongbu.dashBoard.revenue.revenueStatus.service.RevenueStatusService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 세입현황 대시보드 controller
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
public class RevenueStatusController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RevenueStatusController.class);
	@Resource(name = "revenueStatusService")
	private RevenueStatusService revenueStatusService;

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
	@RequestMapping(value = "/dashBoard/revenue/revenueStatus.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String businessStatus(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		
		//검색기간 넣기
		Map<String, Object> date = revenueStatusService.selectRevntatusDate();
		model.addAttribute("date",date);		
		//메뉴코드
		String menuCode = "MENU_00030";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/revenue/revenueStatus";
		
    }
	
	/**
	 * 세입현황 대시보드 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/revenue/revenueStatusData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView revenueStatusData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		//세입징수현황차트  데이터 조회
		List<Map<String, Object>> revnStatusChart = revenueStatusService.selectRevnStatusChart(params);
		
		if( revnStatusChart.size() > 0 ) {
			for( int i = 0 ; i < revnStatusChart.size(); i++ ) {
				params.remove("code");
				params.put("code", revnStatusChart.get(i).get("code").toString());
				List<Map<String, Object>> revnStatusChartSub = revenueStatusService.selectRevnStatusChartSub(params);
				revnStatusChart.get(i).put("sub", revnStatusChartSub);
			}
			
		}
		
		
		//세입징수현황  데이터 조회
		List<Map<String, Object>> revnStatus = revenueStatusService.selectRevnStatus(params);
		//연도별 세입징수 추이 데이터 조회
		List<Map<String, Object>> revnStatusYear = revenueStatusService.selectRevnStatusYear(params);
		//항목별 세입징수 현황 데이터 조회
		List<Map<String, Object>> revnStatusMain = revenueStatusService.selectRevnStatusMain(params);
		//세입징수현황 - 전년대비 세목별 세입징수 현황 데이터 조회
		List<Map<String, Object>> revnStatusSub = revenueStatusService.selectRevnStatusSub(params);
		
		
		modelAndView.addObject("revnStatusChart", revnStatusChart);
		modelAndView.addObject("revnStatus", revnStatus);
		modelAndView.addObject("revnStatusYear", revnStatusYear);
		modelAndView.addObject("revnStatusMain", revnStatusMain);
		modelAndView.addObject("revnStatusSub", revnStatusSub);
		
		return modelAndView;
		
	}
	
	/**
	 * 유동인구 행정동 선택 및 검색 조건 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	/*@ResponseBody
	@RequestMapping(value = "/dashBoard/population/populationFlowSearchData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView populationFlowSearchData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		//Map<String, Object> popEmdTime = financeExecutionService.selectPopEmdTime(params);
		List<Map<String, Object>> popDayFlow = financeExecutionService.selectPopDayFlow(params);
		List<Map<String, Object>> popEmdTimeRange = financeExecutionService.selectPopEmdTimeRange(params);
		List<Map<String, Object>> popGenderFlow = financeExecutionService.selectPopGenderFlow(params);
		List<Map<String, Object>> popRegService = financeExecutionService.selectPopRegService(params);
		
		Map<String, Object> sum = new HashMap<String, Object>();
		
		int sumMan = 0;
		int sumWoman = 0;
		
		for( int i = 0 ; i < popGenderFlow.size(); i++ ) {
			sumMan += Integer.parseInt(popGenderFlow.get(i).get("atrb01").toString());
			sumWoman += Integer.parseInt(popGenderFlow.get(i).get("atrb02").toString());
		}
		sum.put("sumMan", sumMan);
		sum.put("sumWoman", sumWoman);
		
		
		//modelAndView.addObject("popEmdTime", popEmdTime);
		modelAndView.addObject("popEmdTimeRange", popEmdTimeRange);
		modelAndView.addObject("popDayFlow", popDayFlow);
		modelAndView.addObject("popGenderFlow", popGenderFlow);
		modelAndView.addObject("popRegService", popRegService);
		modelAndView.addObject("sum", sum);
		//modelAndView.addObject("list", data.get("list"));
		//modelAndView.addObject("page", data.get("page"));
		
		return modelAndView;
		
	}*/
	
}
