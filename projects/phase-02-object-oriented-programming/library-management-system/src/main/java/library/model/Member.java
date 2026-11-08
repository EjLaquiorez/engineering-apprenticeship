package library.model;

public class Member {
    private final int memberId;
    private String name;
    private MemberStatus status;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.status = MemberStatus.ACTIVE;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberStatus getStatus() {
        return status;
    }
}

