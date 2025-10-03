/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
/**
 *
 * @author User
 */
public class StudentTable {
        private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("HW5PU");

    public static Student findStudentById(int id) {
        EntityManager em = emf.createEntityManager();
        try{
        Student student = em.find(Student.class, id);
        return student;
        }finally{
        em.close();
        }
    }

    public static List<Student> findAllStudents() {
        EntityManager em = emf.createEntityManager();
        List<Student> studentList = null;
        try {
            TypedQuery<Student> query = em.createNamedQuery("Student.findAll", Student.class);
            studentList = query.getResultList();
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean insertStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        int existing = student.getId();
        if (findStudentById(existing) != null) {
            em.close();
            return false; // student already exists
        }
        em.getTransaction().begin();
        try{
            em.persist(student);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }finally{
           em.close(); 
        }
    }
}