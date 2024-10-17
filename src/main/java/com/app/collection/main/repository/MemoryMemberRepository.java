package com.app.collection.main.repository;

import com.app.collection.main.dao.Member;

import java.util.*;

public class MemoryMemberRepository implements  MemberRepository{
    // ID와 객체를 담기위해 <Long, Member>로 만들어준다.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 0,1,2... 생성해주는 변수

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 1 증가
        store.put(member.getId(), member); // Map에 값 넣기
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // return store.get(id) 하지만 Null이라면? 해결책으로 나온게 아랫줄
        // Optional로 감싸면 Null도 감싸을수있고, 클라이언트도 사용가능하다.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // values() : map의 value 목록을 Collection 형태로 리턴
        // stream() : 컬렉션에 저장되어 있는 엘리먼트들을 하나씩 순회하면서 처리(Iterator와 같은 역할)
        // Filter() : 스트림내 요소에 대해서 필터링하는 작업,
        // findAny() : 조건에 일치하는 요소 1개를 리턴
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // 같은 이름일때
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store.values -> Member 반환
    }

    // HashMap에 저장된 모든 객체를 제거
    public void clearStore(){
        store.clear();
    }
}
