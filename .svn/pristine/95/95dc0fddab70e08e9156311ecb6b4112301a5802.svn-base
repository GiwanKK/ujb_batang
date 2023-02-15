package kr.go.uijeongbu.dashBoard.economy.local.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.economy.card.service.impl.CardEconomyMapper;
import kr.go.uijeongbu.dashBoard.economy.local.service.LocalEconomyService;

@Service("localEconomyService")
public class LocalEconomyServiceImpl implements LocalEconomyService {
	
	@Resource(name = "localEconomyMapper")
	private LocalEconomyMapper localEconomyMapper;

	@Override
	public Map<String, Object> selectLocalEconomyMaxDate() {
		return localEconomyMapper.selectLocalEconomyMaxDate();
	}

	@Override
	public List<Map<String, Object>> selectLocalEconomyRange() {
		return localEconomyMapper.selectLocalEconomyRange();
	}

	@Override
	public Map<String, Object> selectLocalEconomyDefaultMap() {
		return localEconomyMapper.selectLocalEconomyDefaultMap();
	}

	@Override
	public Map<String, Object> selectLocalEconomyCnt() {
		return localEconomyMapper.selectLocalEconomyCnt();
	}

	@Override
	public List<Map<String, Object>> selectLocalEconomyList() {
		return localEconomyMapper.selectLocalEconomyList();
	}

	@Override
	public List<Map<String, Object>> selectEmdEconomy(Map<String, Object> params) {
		return localEconomyMapper.selectEmdEconomy(params);
	}

	@Override
	public List<Map<String, Object>> selectEmdStore(Map<String, Object> params) {
		return localEconomyMapper.selectEmdStore(params);
	}

	@Override
	public List<Map<String, Object>> selectTypeStore(Map<String, Object> params) {
		return localEconomyMapper.selectTypeStore(params);
	}

	@Override
	public Map<String, Object> selectEmdEconomyDate(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return localEconomyMapper.selectEmdEconomyDate(params);
	}

	@Override
	public Map<String, Object> selectEmdStoreDate(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return localEconomyMapper.selectEmdStoreDate(params);
	}

	@Override
	public Map<String, Object> selectTypeStoreDate(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return localEconomyMapper.selectTypeStoreDate(params);
	}

	@Override
	public Map<String, Object> selectLocalEconomyListDate(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return localEconomyMapper.selectLocalEconomyListDate(params);
	}

}
