package kr.go.uijeongbu.dashBoard.company.innovationTrend.web;

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
import kr.go.uijeongbu.dashBoard.company.innovationTrend.service.InnovationTrendService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 혁신동향 대시보드 controller
 * @author 김성중
 * @since 2021. 08. 09.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 09.	        김 성 중              최초생성
 *   
 * </pre>
 */
@Controller
public class InnovationTrendController {

	private static final Logger LOGGER = LoggerFactory.getLogger(InnovationTrendController.class);

	@Resource(name = "innovationTrendService")
	private InnovationTrendService innovationTrendService;

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
	@RequestMapping(value = "/dashBoard/company/innovationTrend.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String innovationTrend(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {

		//메뉴코드
		String menuCode = "MENU_00041";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/company/innovationTrend";
    }
	
	@ResponseBody
	@RequestMapping(value = "/dashBoard/company/innovationTrendData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView productionTrendData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		List<Map<String, Object>> companyInnovation = innovationTrendService.selectCompanyInnovation();
		List<Map<String, Object>> companyInvestment = innovationTrendService.selectCompanyInvestment();
		List<Map<String, Object>> companyRnd = innovationTrendService.selectCompanyRnd();

		modelAndView.addObject("companyInnovation", companyInnovation);
		modelAndView.addObject("companyInvestment", companyInvestment);
		modelAndView.addObject("companyRnd", companyRnd);
		
		return modelAndView;
		
	}
}
