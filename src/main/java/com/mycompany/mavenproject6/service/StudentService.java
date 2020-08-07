/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject6.service;


import com.mycompany.mavenproject6.entity.Student;
import com.mycompany.mavenproject6.pojoclass.StudentClass;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
 
public class StudentService {
    
    @PersistenceContext
      
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("trial1");
    
   
    public  void addStudent(Student student) {
     
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
       
        EntityTransaction et = null;
 
        try {
     
            et = em.getTransaction();
            et.begin();
 
              em.persist(student);
            et.commit();
        }catch (Exception ex) {
           if (et != null) {
                et.rollback();
            }
             ex.printStackTrace();
        } finally {
           em.close();
        }
  
      }
 
    public static Student getStudent(long id) {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	String query = "SELECT s FROM Student s WHERE s.id = :id";
    	TypedQuery<Student> tq = em.createQuery(query, Student.class);
    	tq.setParameter("id", id);
        Student stud = null;
    	try {
    		stud = tq.getSingleResult();
    		System.out.println(stud.getFname() + " " + stud.getLname());
    	}
    	catch(NoResultException ex) {
            ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
        return stud;
    }
    
    public static String  getStudents() {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	
    	String strQuery = "SELECT c FROM Student c WHERE c.id IS NOT NULL";
    	
    	TypedQuery<Student> tq = em.createQuery(strQuery, Student.class);
    	List<Student> studs;
        StudentClass s;
        String json = null;
    	try {
//            Iterator<String> iterator = listStrings.iterator();
//while (iterator.hasNext()) {
//    System.out.println(iterator.next());
//}
    		studs = tq.getResultList();
//    		studs.forEach(stud->System.out.println(stud.getFname() + " " + stud.getLname()));
              int i=studs.size();
              for(int a=0;a<i;a++)
              {studs.iterator();
//                 json="{'id':"+studs.getId()+",'Fname':'"+studs.getFname()+"','Lname':'"+studs.getLname()+"','email':'"+studs.getEmail()+"','gno':'"+studs.getGno()+"',''balance':"+studs.getBalance+"'}";
              }
              
    	}
    	catch(NoResultException ex) {
             ex.printStackTrace();
    	}
    	finally {
    		em.close();
                return json;
    	}
    }
    
    public static void changeStudent(Student student) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        
    	Student stud = null;
 
        try {
            et = em.getTransaction();
            et.begin();
 
            stud = em.find(Student.class, student.getId());
            stud.setFname(student.getFname());
            stud.setLname(student.getLname());
            stud.setEmail(student.getEmail());
            stud.setGno(student.getGno());
            stud.setBalance(student.getBalance());
            em.persist(stud);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }
//    
    public static void deleteStudent(long id) {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Student stud = null;
 
        try {
            et = em.getTransaction();
            et.begin();
            stud = em.find(Student.class, id);
            em.remove(stud);
            et.commit();
        } catch (Exception ex) {
          ex.printStackTrace();
            if (et != null) {
                et.rollback();
            }
        } finally {
           
            em.close();
        }
    }
}