package sa41.ca.uno.LogInOut;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "member")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Member.findAll", query = "SELECT m FROM Member m"),
//    @NamedQuery(name = "Member.findByName", query = "SELECT m FROM Member m WHERE m.name = :name"),
//    @NamedQuery(name = "Member.findByEmail", query = "SELECT m FROM Member m WHERE m.email = :email"),
//    @NamedQuery(name = "Member.findByPassword", query = "SELECT m FROM  m WHERE m.password = :password"),
//    @NamedQuery(name = "Member.findByGroupid", query = "SELECT m FROM Member m WHERE m.groupid = :groupid")})
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 128)
    @Column(name="member_id")
    private Integer member_id;
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 128)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Id
    @ManyToOne
    @JoinColumn(name="groupid", referencedColumnName = "groupid")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "groupid")
    private String groupid;

    public Member() {
    }

    public Member(String name, String password, String groupid) {
       
        this.name = name;
        this.password = password;
        this.groupid = groupid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
    
    public Member copy() {
		Member m = new Member();
		m.name = name;
		m.email = email;
                m.password = password;
		m.groupid = groupid;
		return (m);
	}

        
}
