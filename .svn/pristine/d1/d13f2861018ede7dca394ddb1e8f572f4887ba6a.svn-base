package kr.go.uijeongbu.dashBoard.economy.local.web;

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
import kr.go.uijeongbu.dashBoard.economy.local.service.LocalEconomyService;
import kr.go.uijeongbu.manager.logMng.service.LogService;
/**
 * 지역경제(상권) 지역경제(상권) 분석 controller
 * @author 김성중
 * @since 2021. 08. 17.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 17.	        김 성 중              최초생성
 *   
 * </pre>
 */
@Controller
public class LocalEconomyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocalEconomyController.class);
	
	@Resource(name = "localEconomyService")
	private LocalEconomyService localEconomyService;

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
	@RequestMapping(value = "/dashBoard/economy/localEconomy.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String localEconomy(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		//검색기간 넣기
		model.addAttribute("date", localEconomyService.selectLocalEconomyMaxDate());
		
		//메뉴코드
		String menuCode = "MENU_00042";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/economy/localEconomy";
    }
	
	@ResponseBody
	@RequestMapping(value = "/dashBoard/economy/localEconomyData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView localEconomyData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		List<Map<String, Object>> localEconomyRange = localEconomyService.selectLocalEconomyRange();
		Map<String, Object> localEconomyDefaultMap = localEconomyService.selectLocalEconomyDefaultMap();
		Map<String, Object> localEconomyCnt = localEconomyService.selectLocalEconomyCnt();
		
		List<Map<String, Object>> localEconomyList = localEconomyService.selectLocalEconomyList();
		List<Map<String, Object>> emdEconomy = localEconomyService.selectEmdEconomy(params);
		List<Map<String, Object>> emdStore = localEconomyService.selectEmdStore(params);
		List<Map<String, Object>> typeStore = localEconomyService.selectTypeStore(params);
		
		Map<String, Object> dateLl = localEconomyService.selectLocalEconomyListDate(params);
		Map<String, Object> dateEc = localEconomyService.selectEmdEconomyDate(params);
		Map<String, Object> dateSt = localEconomyService.selectEmdStoreDate(params);
		Map<String, Object> dateTy = localEconomyService.selectTypeStoreDate(params);

		modelAndView.addObject("localEconomyRange", localEconomyRange);
		modelAndView.addObject("localEconomyDefaultMap", localEconomyDefaultMap);
		modelAndView.addObject("localEconomyCnt", localEconomyCnt);
		
		modelAndView.addObject("localEconomyList", localEconomyList);
		modelAndView.addObject("emdEconomy", emdEconomy);
		modelAndView.addObject("emdStore", emdStore);
		modelAndView.addObject("typeStore", typeStore);
		
		modelAndView.addObject("dateLl", dateLl);
		modelAndView.addObject("dateEc", dateEc);
		modelAndView.addObject("dateSt", dateSt);
		modelAndView.addObject("dateTy", dateTy);
		return modelAndView;
	}
}
