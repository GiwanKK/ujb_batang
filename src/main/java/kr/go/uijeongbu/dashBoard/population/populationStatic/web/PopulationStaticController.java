package kr.go.uijeongbu.dashBoard.population.populationStatic.web;

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
import kr.go.uijeongbu.dashBoard.population.populationStatic.service.PopulationStaticService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 대시보드 인구 - 인구통계 controller
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
public class PopulationStaticController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PopulationStaticController.class);
	@Resource(name = "populationService")
	private PopulationStaticService populationStaticService;

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
	@RequestMapping(value = "/dashBoard/population/populationStatic.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String populationStatic(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		Map<String, Object> date = populationStaticService.selectPopStaticDate();
		model.addAttribute("date", date);		
		//메뉴코드
		String menuCode = "MENU_00020";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/population/populationStatic";
		
    }
	
	/**
	 * 대시보드 인구 - 인구현황 페이지 데이터
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/population/populationStaticData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView populationStaticData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		List<Map<String, Object>> popStatus = populationStaticService.selectPopStatus(params);
		List<Map<String, Object>> popStatusDt = populationStaticService.selectPopStatusDt(params);
		List<Map<String, Object>> popTotalTrend = populationStaticService.selectPopTotalTrend(params);
		List<Map<String, Object>> popAgeStatus = populationStaticService.selectPopAgeStatus(params);
		Map<String, Object> sum = new HashMap<String, Object>();
		
		int sumMan = 0;
		int sumWoman = 0;
		
		for( int i = 0 ; i < popAgeStatus.size(); i++ ) {
			sumMan += Integer.parseInt(popAgeStatus.get(i).get("atrb02").toString());
			sumWoman += Integer.parseInt(popAgeStatus.get(i).get("atrb03").toString());
		}
		sum.put("sumMan", sumMan);
		sum.put("sumWoman", sumWoman);
		modelAndView.addObject("popStatus", popStatus);
		modelAndView.addObject("popStatusDt", popStatusDt);
		modelAndView.addObject("popTotalTrend", popTotalTrend);
		modelAndView.addObject("popAgeStatus", popAgeStatus);
		modelAndView.addObject("sum", sum);
		//modelAndView.addObject("list", data.get("list"));
		//modelAndView.addObject("page", data.get("page"));
		
		return modelAndView;
		
	}
	
}
