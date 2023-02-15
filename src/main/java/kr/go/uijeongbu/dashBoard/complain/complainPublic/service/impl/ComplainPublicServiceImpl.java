package kr.go.uijeongbu.dashBoard.complain.complainPublic.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.complain.complainPublic.service.ComplainPublicService;

/**
 * 대시보드 인구 - 여론분석 ServiceImpl클래스
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

@Service("complainPublicService")
public class ComplainPublicServiceImpl implements ComplainPublicService {
	
	@Resource(name = "complainPublicMapper")
	private ComplainPublicMapper complainPublicMapper;

	@Override
	public Map<String, Object> selectCompPublicDate() {
		// TODO Auto-generated method stub
		return complainPublicMapper.selectCompPublicDate();
	}

	@Override
	public List<Map<String, Object>> selectCompPublicStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return complainPublicMapper.selectCompPublicStatus(param);
	}

	@Override
	public List<Map<String, Object>> selectCompPublicKeyword(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return complainPublicMapper.selectCompPublicKeyword(param);
	}

	@Override
	public List<Map<String, Object>> selectCompPublicDay(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return complainPublicMapper.selectCompPublicDay(param);
	}

	@Override
	public List<Map<String, Object>> selectCompPublicWordcloud(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return complainPublicMapper.selectCompPublicWordcloud(param);
	}

	@Override
	public List<Map<String, Object>> selectCompPublicRelate(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return complainPublicMapper.selectCompPublicRelate(param);
	}


}
