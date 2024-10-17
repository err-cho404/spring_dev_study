package com.mysite.yangdoll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.yangdoll.entity.Members;
import com.mysite.yangdoll.repository.MemberRepository;


@Service
public class MemberServiceJPAImpl implements MemberService{
	
	@Autowired
	MemberRepository repository;

	@Override
	public Members getMember(Integer memId) {
		return repository.findById(memId).get();
//		return repository.getById(memId);-->가능하나 권장하지는 않음
	}

	@Override
	public List<Members> getMemberAll() {
		
		return repository.findAll();
	}

	@Override
	public void updateMember(Members mem) {
		//DB에 저장도니 수정할 자료 하나를 가져오고
		Members member = repository.findById(mem.getMemId()).get();
		//가져온 자료에 수정할 내용을 넣음
		member.setCount(mem.getCount());
		member.setEmail("yayayaya");
		member.setMemPwd(mem.getMemPwd());
		//DB에 수정된 자료(entity)를 저장(새로운 저장이 아니라 기존값을 변경)시킨다.
		repository.save(member);
	}
	
	@Override
	public int registerMember(Members member) {
		Members result = repository.save(member);
		if(result == null ) return 0; //저장값이 없으면(null) 저장하지말고(return 0;) 저장값이 있다면 저장함
		return 1;
	}

	@Override
	public void updateCondition() {
		repository.updateConditionalAll();
	}

}
