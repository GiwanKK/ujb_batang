package kr.go.uijeongbu.dashBoard.population.populationFlow.web;

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
import kr.go.uijeongbu.dashBoard.population.populationFlow.service.PopulationFlowService;
import kr.go.uijeongbu.dashBoard.population.populationMove.service.PopulationMoveService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 유동인구 대시보드 controller
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
public class PopulationFlowController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PopulationFlowController.class);
	@Resource(name = "populationFlowService")
	private PopulationFlowService populationFlowService;
	
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
	@RequestMapping(value = "/dashBoard/population/populationFlow.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String populationFlow(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		
		//유동인구 검색기간 넣기
		Map<String, Object> date = populationFlowService.selectPopFlowDate();
		model.addAttribute("date",date);		
		//메뉴코드
		String menuCode = "MENU_00022";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/population/populationFlow";
		
    }
	
	/**
	 * 유동인구 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/population/populationFlowData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView populationFlowData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		Map<String, Object> popEmdTime = populationFlowService.selectPopEmdTime(params);
		List<Map<String, Object>> popDayFlow = populationFlowService.selectPopDayFlow(params);
		List<Map<String, Object>> popEmdTimeRange = populationFlowService.selectPopEmdTimeRange(params);
		List<Map<String, Object>> popGenderFlow = populationFlowService.selectPopGenderFlow(params);
		List<Map<String, Object>> popRegService = populationFlowService.selectPopRegService(params);
		//Map<String, Object> popMoveDefaultMap = populationMoveService.selectPopMoveDefaultMap(params);
		Map<String, Object> sum = new HashMap<String, Object>();
		int sumMan = 0;
		int sumWoman = 0;
		
		for( int i = 0 ; i < popGenderFlow.size(); i++ ) {
			sumMan += Integer.parseInt(popGenderFlow.get(i).get("atrb01").toString());
			sumWoman += Integer.parseInt(popGenderFlow.get(i).get("atrb02").toString());
		}
		sum.put("sumMan", sumMan);
		sum.put("sumWoman", sumWoman);
		
		
		modelAndView.addObject("popEmdTime", popEmdTime);
		modelAndView.addObject("popEmdTimeRange", popEmdTimeRange);
		modelAndView.addObject("popDayFlow", popDayFlow);
		modelAndView.addObject("popGenderFlow", popGenderFlow);
		modelAndView.addObject("popRegService", popRegService);
		modelAndView.addObject("sum", sum);
		//modelAndView.addObject("popMoveDefaultMap", popMoveDefaultMap);
		//modelAndView.addObject("page", data.get("page"));
		
		return modelAndView;
		
	}
	
	/**
	 * 유동인구 행정동 선택 및 검색 조건 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/population/populationFlowSearchData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView populationFlowSearchData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		//Map<String, Object> popEmdTime = populationFlowService.selectPopEmdTime(params);
		List<Map<String, Object>> popDayFlow = populationFlowService.selectPopDayFlow(params);
		List<Map<String, Object>> popEmdTimeRange = populationFlowService.selectPopEmdTimeRange(params);
		List<Map<String, Object>> popGenderFlow = populationFlowService.selectPopGenderFlow(params);
		List<Map<String, Object>> popRegService = populationFlowService.selectPopRegService(params);
		
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
		
	}
	
}
