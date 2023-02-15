package kr.go.uijeongbu.dashBoard.mainDetail.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 메인페이지 상세보기  mapper 클래스
 * @author 김부권
 * @since 2021. 10. 15.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 10. 15.	        김부권                         최초생성
 *   
 * </pre>
 */

@Repository("mainDetailMapper")
public class MainDetailMapper extends ComAbstractDAO {

	
	//수목 조회
	public Map<String, Object> selectMainTreeDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainTreeDetail", param);
	}
	
	//공원수목 조회
	public Map<String, Object> selectMainTreeParkDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainTreeParkDetail", param);
	}
	
	//어린이집 조회
	public Map<String, Object> selectMainChildrenDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainChildrenDetail", param);
	}
	
	//신호등 조회
	public Map<String, Object> selectMainTrafficDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainTrafficDetail", param);
	}
	
	//횡단보도 조회
	public Map<String, Object> selectMainCrosswalkDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainCrosswalkDetail", param);
	}
	
	//안전표지 조회
	public Map<String, Object> selectMainSafetySignDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainSafetySignDetail", param);
	}
	
	//안전비상벨 조회
	public Map<String, Object> selectMainEmergencyBellDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainEmergencyBellDetail", param);
	}
	
	//CCTV 조회
	public Map<String, Object> selectMainCctvDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainCctvDetail", param);
	}
	
	//무료와이파이 조회
	public Map<String, Object> selectMainWifiDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainWifiDetail", param);
	}
	
	//주차장 조회
	public Map<String, Object> selectMainParkingDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainParkingDetail", param);
	}
	
	//소방용수시설 조회
	public Map<String, Object> selectMainFirefightingDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainFirefightingDetail", param);
	}
	
	//어린이보호구역 조회
	public Map<String, Object> selectMainChildrenSanctuaryDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainChildrenSanctuaryDetail", param);
	}
	
	//안내표지 조회
	public Map<String, Object> selectMainGuideSignDetail(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectMainGuideSignDetail", param);
	}
	
	//행정동 센터포인트
	public Map<String, Object> selectDongCenterPoint(Map<String, Object> param) {
		return selectOne("MainDetailMapper.selectDongCenterPoint", param);
	}
	
	//행정동 경계
	public Map<String, Object> selectAdmdAreaLine() {
		return selectOne("MainDetailMapper.selectAdmdAreaLine");
	}
	
	//행정동 
	public List<Map<String, Object>> selectDongList() {
		return selectList("MainDetailMapper.selectDongList");
	}

	
}
