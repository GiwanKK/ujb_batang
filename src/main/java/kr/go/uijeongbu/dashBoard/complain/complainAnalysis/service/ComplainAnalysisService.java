package kr.go.uijeongbu.dashBoard.complain.complainAnalysis.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 인구 - 민원분석 service 클래스
 * @author 김부권
 * @since 2021. 07. 28.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 07. 28.	        김 부 권              최초생성
 *   
 * </pre>
 */
public interface ComplainAnalysisService {
	
	/**
	 * 대시보드 민원 - 민원분석 검색기간
	 * @param param
	 * @return
	 */
	Map<String, Object> selectCompAnalysisDate();
	
	/**
	 * 대시보드 민원 - 민원 현황
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCompAnalysisStatus(Map<String, Object> param);
	
	/**
	 * 대시보드 민원 - 행정동별 민원 상위
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCompAnalysisRank(Map<String, Object> param);
	
	/**
	 * 대시보드 민원 - 일별 언급량 추이
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCompAnalysisDay(Map<String, Object> param);
	
	/**
	 * 대시보드 민원 - 긍정 부정분석
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCompAnalysisNp(Map<String, Object> param);
	
	/**
	 * 대시보드 민원 - 연관어 분석 
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCompAnalysisRelate(Map<String, Object> param);
	
	
}
