package wac.mall.domain;

public class MemberCart {
    private Integer memberid;
    private Integer productid;
    private Integer pronumber;

    public MemberCart(Integer memberid, Integer productid, Integer pronumber) {
        this.memberid = memberid;
        this.productid = productid;
        this.pronumber = pronumber;
    }

    public MemberCart(Integer memberid, Integer productid) {
        this.memberid = memberid;
        this.productid = productid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getPronumber() {
        return pronumber;
    }

    public void setPronumber(Integer pronumber) {
        this.pronumber = pronumber;
    }

    @Override
    public String toString() {
        return "MemberCart{" +
                "memberid=" + memberid +
                ", productid=" + productid +
                ", pronumber=" + pronumber +
                '}';
    }
}
