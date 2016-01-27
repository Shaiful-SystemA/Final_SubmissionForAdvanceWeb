/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sa41.ca.uno.CreateGroup;

import sa41.ca.uno.LogInOut.Member;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MemberBean {
        @PersistenceContext private EntityManager em;
        
 
    public void addMember(Member m){
               
        try{
        em.persist(m);   
        } catch (Throwable t){
        t.printStackTrace();
        } 
    }
    
    
}
