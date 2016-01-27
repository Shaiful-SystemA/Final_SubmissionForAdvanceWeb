/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sa41.ca.uno.CreateGroup;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import sa41.ca.uno.LogInOut.Member;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findById", query = "SELECT g FROM Groups g WHERE g.id = :id"),
    @NamedQuery(name = "Groups.findByGroupid", query = "SELECT g FROM Groups g WHERE g.groupid = :groupid"),
    @NamedQuery(name = "Groups.findByName", query = "SELECT g FROM Groups g WHERE g.name = :name")})
public class Groups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "groupid")
    private String groupid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    private List<Member> members = new LinkedList<>();
    private Member member = new Member();

    @PostConstruct
    private void init() {
        System.out.println(">>> in post construct");
    }

    @PreDestroy
    private void cleanup() {
        System.out.println(">>>in pre destroy");
    }

    public void add() {
        System.out.println(">>> @Inject member: " + member.getClass().getName());
        System.out.println(">> copy: " + member.copy().getClass().getName());
        if (name == null) {
            name = member.getGroupid();
        }
        members.add(member.copy());
    }

    public void add(Member member) {
        if (name == null) {
            name = member.getGroupid();
        }
        members.add(member.copy());
    }

    public Groups() {
    }

    public Groups(String groupid, String name) {
        this.groupid = groupid;
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

        
    @Id
    @OneToMany(mappedBy = "groupid")
    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
