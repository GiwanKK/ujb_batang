package kr.go.uijeongbu.dashBoard.welfare.welfareStatus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 복지현황 - mapper 클래스
 * @author 김혜림
 * @since 2021. 08. 05.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 05.	        김 혜 림              최초생성
 *   
 * </pre>
 */

@Repository("welfareStatusMapper")
public class WelfareStatusMapper extends ComAbstractDAO {

	//의정부 행정동 경계 조회
	public List<Map<String, Object>> selectAdmdArea(Map<String, Object> params) {
		return selectList("WelfareStatusMapper.selectAdmdArea");
	}

	//데이터 존재하는 기간 조회
	public Map<String, Object> selectWfStatusDate() {
		return selectOne("WelfareStatusMapper.selectWfStatusDate");
	}

	//보육시설 현황 조회
	public List<Map<String, Object>> selectChildFacilStatus(Map<String, Object> params) {
		return selectList("WelfareStatusMapper.selectChildFacilStatus");
	}

	//노인복지시설 현황 조회
	public List<Map<String, Object>> selectOldWfFacilStatus(Map<String, Object> params) {
		return selectList("WelfareStatusMapper.selectOldWfFacilStatus");
	}
	
	//노인복지시설 종류별 비율 조회
	public List<Map<String, Object>> selectOldWfFacilRatio(Map<String, Object> params) {
		return selectList("WelfareStatusMapper.selectOldWfFacilRatio");
	}

	//유형별 유치원 정원 수 조회
	public List<Map<String, Object>> selectKndgnLimit(Map<String, Object> params) {
		return selectList("WelfareStatusMapper.selectKndgnLimit");
	}
	
	//유형별 어린이집 정원 수 조회
	public List<Map<String, Object>> selectNurseryLimit(Map<String, Object> params) {
		return selectList("WelfareStatusMapper.selectNurseryLimit");
	}
	
	//장애 정도별 수급자 수 조회
	public List<Map<String, Object>> selectDisDegreeCnt(Map<String, Object> params) {
		return selectList("WelfareStatusMapper.selectDisDegreeCnt");
	}
	
	//연령별 수급자 수 조회
	public List<Map<String, Object>> selectDisAgeCnt(Map<String, Object> params) {
		return selectList("WelfareStatusMapper.selectDisAgeCnt");
	}

	//배경지도 조회
	public Map<String, Object> selectDefaultMap(Map<String, Object> params) {
		return selectOne("WelfareStatusMapper.selectDefaultMap");
	}
	
}
