package com.ptteng.service.impl;

import com.ptteng.dao.InvestmentContractMapper;
import com.ptteng.model.InvestmentContract;
import com.ptteng.service.InvestmentContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InvestmentContractServiceImpl implements InvestmentContractService {
@Resource
    InvestmentContractMapper investmentContractMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return investmentContractMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(InvestmentContract record) {
        return this.investmentContractMapper.insert(record);
    }

    @Override
    public int insertSelective(InvestmentContract record) {
        return investmentContractMapper.insertSelective(record);
    }

    @Override
    public InvestmentContract selectByPrimaryKey(Long id) {
        return investmentContractMapper.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKeySelective(InvestmentContract record) {
        return investmentContractMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(InvestmentContract record) {
        return investmentContractMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<InvestmentContract> selectByUserId(Long userId, Long a, Long b) {
        return investmentContractMapper.selectByUserId(userId,a,b);
    }

    @Override
    public Long selectCount(Long userId) {
        return this.investmentContractMapper.selectCount(userId);
    }
}