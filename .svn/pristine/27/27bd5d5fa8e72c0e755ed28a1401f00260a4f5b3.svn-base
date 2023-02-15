package kr.go.uijeongbu.dashBoard.complain.complainAnalysis.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.complain.complainAnalysis.service.ComplainAnalysisService;

/**
 * 대시보드 인구 - 민원분석  ServiceImpl클래스
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

@Service("complainAnalysisService")
public class ComplainAnalysisServiceImpl implements ComplainAnalysisService {
	
	@Resource(name = "complainAnalysisMapper")
	private ComplainAnalysisMapper complainAnalysisMapper;

	@Override
	public Map<String, Object> selectCompAnalysisDate() {
		// TODO Auto-generated method stub
		return complainAnalysisMapper.selectCompAnalysisDate();
	}

	@Override
	public List<Map<String, Object>> selectCompAnalysisStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return complainAnalysisMapper.selectCompAnalysisStatus(param);
	}

	@Override
	public List<Map<String, Object>> selectCompAnalysisRank(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return complainAnalysisMapper.selectCompAnalysisRank(param);
	}

	@Override
	public List<Map<String, Object>> selectCompAnalysisDay(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return complainAnalysisMapper.selectCompAnalysisDay(param);
	}

	@Override
	public List<Map<String, Object>> selectCompAnalysisNp(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return complainAnalysisMapper.selectCompAnalysisNp(param);
	}

	@Override
	public List<Map<String, Object>> selectCompAnalysisRelate(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return complainAnalysisMapper.selectCompAnalysisRelate(param);
	}


}
