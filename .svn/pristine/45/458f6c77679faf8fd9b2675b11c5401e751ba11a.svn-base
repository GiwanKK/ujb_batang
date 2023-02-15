package kr.go.uijeongbu.dashBoard.economy.card.web;

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
import kr.go.uijeongbu.dashBoard.economy.card.service.CardEconomyService;
import kr.go.uijeongbu.manager.logMng.service.LogService;
/**
 * 지역경제(상권) 카드 매출 분석 controller
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
public class CardEconomyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CardEconomyController.class);
	
	@Resource(name = "cardEconomyService")
	private CardEconomyService cardEconomyService;

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
	@RequestMapping(value = "/dashBoard/economy/cardEconomy.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String cardEconomy(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		model.addAttribute("date", cardEconomyService.selectCardEconomyMaxDate());
		
		//메뉴코드
		String menuCode = "MENU_00043";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/economy/cardEconomy";
    }
	
	/**
	 * 카드 매출 분석 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/economy/cardEconomyData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView cardEconomyData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		List<Map<String, Object>> cardEconomyAgeCategory = cardEconomyService.selectCardEconomyAgeCategory(params);
		List<Map<String, Object>> cardEconomyEmd = cardEconomyService.selectCardEconomyEmd(params);
		List<Map<String, Object>> cardEconomyWeek = cardEconomyService.selectCardEconomyWeek(params);
		List<Map<String, Object>> cardEconomyMonth = cardEconomyService.selectCardEconomyMonth(params);

		modelAndView.addObject("cardEconomyAgeCategory", cardEconomyAgeCategory);
		modelAndView.addObject("cardEconomyEmd", cardEconomyEmd);
		modelAndView.addObject("cardEconomyWeek", cardEconomyWeek);
		modelAndView.addObject("cardEconomyMonth", cardEconomyMonth);
		
		return modelAndView;
	}
	
}
