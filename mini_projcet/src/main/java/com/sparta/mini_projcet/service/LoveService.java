package com.sparta.mini_projcet.service;

import com.sparta.mini_projcet.dto.LoveDto;
import com.sparta.mini_projcet.model.Loves;
import com.sparta.mini_projcet.model.Member;
import com.sparta.mini_projcet.model.Notice;
import com.sparta.mini_projcet.repository.LoveRepository;
import com.sparta.mini_projcet.repository.MemberRepository;
import com.sparta.mini_projcet.repository.NoticeRepository;
import com.sparta.mini_projcet.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoveService {


    private final NoticeRepository noticeRepository;
    private final MemberRepository memberRepository;
    private final LoveRepository loveRepository;
    public boolean loveUp(Long noticeId, Long memberId) {
        Notice notice = getNotice(noticeId);
        Member member = getMember(memberId);

        //서버에 반환해줄 불리언
        boolean toggleLike;

        LoveDto loveDto = new LoveDto(notice, member);
        Loves loves = new Loves(loveDto);
        int loveCnt = loves.getNotice().getLoveCnt();

        //지금 로그인 되어있는 사용자가 해당 포스트에 좋아요를 누른적이 있냐 없냐.
        Loves findHeart = loveRepository.findByNoticeAndMember(notice, member).orElse(null);

        if(findHeart == null){
            loves.getNotice().setLoveCnt(loveCnt+1);

            loveRepository.save(loves);
            toggleLike = true;
        }
        else{
            loves.getNotice().setLoveCnt(loveCnt-1);

            loveRepository.deleteById(findHeart.getId());
            toggleLike = false;
        }
        return toggleLike;
    }

    private Notice getNotice(Long noticeId) {
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(
                ()->new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        return notice;
    }

    private Member getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("사용자 정보가 존재하지 않습니다.")
        );
        return member;
    }



}
