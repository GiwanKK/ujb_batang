package kr.go.uijeongbu.dashBoard.complain.complainPublic.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 인구 - 여론분석 service 클래스
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
public interface ComplainPublicService {
	
	/**
	 * 대시보드 여론분석 - 여론분석 검색기간
	 * @param param
	 * @return
	 */
	Map<String, Object> selectCompPublicDate();
	
	/**
	 * 대시보드 여론분석 - 여론 현황
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCompPublicStatus(Map<String, Object> param);
	
	/**
	 * 대시보드 여론분석 - 여론 키워드 관련글
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCompPublicKeyword(Map<String, Object> param);
	
	/**
	 * 대시보드 여론분석 - 일별 언급량 추이
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCompPublicDay(Map<String, Object> param);
	
	/**
	 * 대시보드 여론분석 - 워드 클라우드
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCompPublicWordcloud(Map<String, Object> param);
	
	/**
	 * 대시보드 여론분석 - 연관어 분석
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectCompPublicRelate(Map<String, Object> param);
	
	
}
