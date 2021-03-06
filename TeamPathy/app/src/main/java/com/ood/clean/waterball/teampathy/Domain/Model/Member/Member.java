package com.ood.clean.waterball.teampathy.Domain.Model.Member;

import com.ood.clean.waterball.teampathy.Domain.Model.User;

import java.io.Serializable;

/**
 * Member presents the info of how the user participates the project.
 */
public class Member implements Serializable{
    private User user;
    private MemberDetails memberDetails;

    public Member(User user, MemberDetails memberDetails) {
        this.user = user;
        this.memberDetails = memberDetails;
    }

    public static Member create(User user, Position position){
        MemberDetails memberDetails = new MemberDetails(position,0);
        return new Member(user,memberDetails);
    }

    public int getUserId(){
        return user.getId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isNotManager(){
        return memberDetails.getPosition().isMember();
    }

    /**
     * @return the member is a leader or a manager
     */
    public boolean isManager(){
        return !memberDetails.getPosition().isMember();
    }

    public MemberDetails getMemberDetails() {
        return memberDetails;
    }

    public void setMemberDetails(MemberDetails memberDetails) {
        this.memberDetails = memberDetails;
    }
}
