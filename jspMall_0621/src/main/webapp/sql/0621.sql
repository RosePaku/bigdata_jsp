-- board 테이블에서 모든 데이터를 선택합니다.
select * from board;

-- bno가 11인 행의 btitle을 '민지 444'로 업데이트합니다.
update board set btitle='민지 444' where bno=11;

-- bno가 11인 행의 btitle을 '민지아님1111'로, bcontent를 '걸그룹 아이즈원'으로 업데이트합니다.
update board 
set btitle='민지아님1111', bcontent='걸그룹 아이즈원'
where bno=11;

-- board 테이블에서 모든 데이터를 다시 선택합니다. 이전에 업데이트된 데이터가 반영됩니다.
select * from board;

-- 트랜잭션의 변경 사항을 커밋합니다. 변경 사항이 영구적으로 저장됩니다.
commit;

-- bno가 9인 행의 bhit 값을 1 증가시킵니다. 즉, bno가 9인 게시물의 조회수를 1 증가시킵니다.
update board set bhit=bhit+1 where bno=9;

-- board 테이블에서 bgroup을 내림차순으로 정렬하고, bstep을 오름차순으로 정렬하여 데이터를 선택합니다.
select * from board order by bgroup desc, bstep asc;
