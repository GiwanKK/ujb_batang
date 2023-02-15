package kr.go.uijeongbu.dashBoard.complain.complainPublic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 인구 - 여론분석 mapper 클래스
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

@Repository("complainPublicMapper")
public class ComplainPublicMapper extends ComAbstractDAO {
	
	/**
	 * 대시보드 여론분석 - 여론분석 검색기간
	 * @return
	 */
	public Map<String, Object> selectCompPublicDate() {
		return selectOne("ComplainPublicMapper.selectCompPublicDate");
	}
	

	/**
	 * 대시보드 여론분석 - 여론 현황
	 * @return
	 */
	public List<Map<String, Object>> selectCompPublicStatus(Map<String, Object> param) {
		return selectList("ComplainPublicMapper.selectCompPublicStatus", param);
	}
	
	/**
	 * 대시보드 여론분석 - 여론 키워드 관련글
	 * @return
	 */
	public List<Map<String, Object>> selectCompPublicKeyword(Map<String, Object> param) {
		return selectList("ComplainPublicMapper.selectCompPublicKeyword", param);
	}
	
	/**
	 * 대시보드 여론분석 - 일별 언급량 추이
	 * @return
	 */
	public List<Map<String, Object>> selectCompPublicDay(Map<String, Object> param) {
		return selectList("ComplainPublicMapper.selectCompPublicDay", param);
	}
	
	/**
	 * 대시보드 여론분석 - 워드 클라우드
	 * @return
	 */
	public List<Map<String, Object>> selectCompPublicWordcloud(Map<String, Object> param) {
		return selectList("ComplainPublicMapper.selectCompPublicWordcloud", param);
	}
	
	/**
	 * 대시보드 여론분석 - 연관어 분석
	 * @return
	 */
	public List<Map<String, Object>> selectCompPublicRelate(Map<String, Object> param) {
		return selectList("ComplainPublicMapper.selectCompPublicRelate", param);
	}

	

}
