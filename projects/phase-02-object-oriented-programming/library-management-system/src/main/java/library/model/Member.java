package library.model;

public class Member {
    private final int memberId;
    private String name;
    private MemberStatus status;

    Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.status = MemberStatus.ACTIVE;
    }

}

