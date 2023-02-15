package kr.go.uijeongbu.dashBoard.company.companyTrend.web;

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
import kr.go.uijeongbu.dashBoard.company.companyTrend.service.CompanyTrendService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 기업동향 대시보드 controller
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
public class CompanyTrendController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyTrendController.class);
	
	@Resource(name = "companyTrendService")
	private CompanyTrendService companyTrendService;

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
	@RequestMapping(value = "/dashBoard/company/companyTrend.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String companyTrend(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		//메뉴코드
		String menuCode = "MENU_00038";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/company/companyTrend";
    }
	
	/**
	 * 기업동향 전체 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/company/companyTrendData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView productionTrendData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		List<Map<String, Object>> emdCompanyRange = companyTrendService.selectEmdCompanyRange();
//		Map<String, Object> emdCompanyDefaultMap = companyTrendService.selectEmdCompanyDefaultMap();
		Map<String, Object> emdCompanyCnt = companyTrendService.selectEmdCompanyCnt();
		Map<String, Object> param = new HashMap<>();
		param.put("dongCd", "4115000000");
		List<Map<String, Object>> yearCompanySales = companyTrendService.selectYearCompanySales(param);
		List<Map<String, Object>> emdCompanyStats = companyTrendService.selectEmdCompanyStats();
		List<Map<String, Object>> industryRate = companyTrendService.selectIndustryRate();
		List<Map<String, Object>> industryProfit = companyTrendService.selectIndustryProfit();

		modelAndView.addObject("emdCompanyRange", emdCompanyRange);
//		modelAndView.addObject("emdCompanyDefaultMap", emdCompanyDefaultMap);
		modelAndView.addObject("emdCompanyCnt", emdCompanyCnt);
		modelAndView.addObject("yearCompanySales", yearCompanySales);
		modelAndView.addObject("emdCompanyStats", emdCompanyStats);
		modelAndView.addObject("industryRate", industryRate);
		modelAndView.addObject("industryProfit", industryProfit);
		
		return modelAndView;
	}
	
	/**
	 * 기업동향 전체 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/company/companyTrendCompanySalesData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView companyTrendCompanySalesData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		modelAndView.addObject("yearCompanySales", companyTrendService.selectYearCompanySales(params));
		return modelAndView;
	}
}
