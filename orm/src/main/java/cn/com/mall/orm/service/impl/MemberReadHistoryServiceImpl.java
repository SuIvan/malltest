package cn.com.mall.orm.service.impl;

import cn.com.mall.orm.nosql.mongodb.document.MemberReadHistory;
import cn.com.mall.orm.nosql.mongodb.repository.MemberReadHistoryRepository;
import cn.com.mall.orm.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;


    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> readHistories = new ArrayList<>();
        ids.stream().forEach(id-> {
            readHistories.add(new MemberReadHistory(id));
        });
        memberReadHistoryRepository.deleteAll(readHistories);
        return readHistories.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
