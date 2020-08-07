
package com.mycompany.mavenproject6.resource;

import com.mycompany.mavenproject6.entity.Student;
import com.mycompany.mavenproject6.pojoclass.StudentClass;
import com.mycompany.mavenproject6.service.StudentService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/students")
public class StudentResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getStudent(@PathParam("id") long id) {
        Student student;
        StudentService service = new StudentService();
        student = StudentService.getStudent(id);
        StudentClass s = new StudentClass();
        s.setFname(student.getFname());
        s.setLname(student.getLname());
        s.setEmail(student.getEmail());
        s.setBalance(student.getBalance());
        s.setGno(student.getGno());
        s.setId(student.getId());
//String json="{\"id\":"+student.getId()+",\"fname\":\""+student.getFname()+"\",\"lname\":\""+student.getLname()+"\",\"email\":\""+student.getEmail()+"\",\"gno\":\""+student.getGno()+"\"}";
//return Response.ok(json, MediaType.APPLICATION_JSON).build();
        return Response.status(Response.Status.CREATED).entity(s).build();

    }

//   public Student getStudent(@PathParam("id") long id)
//   {
//       Student student;
//       StudentService service =new StudentService();
//       student=StudentService.getStudent(id);
//       return student;
////       return "hi";
//   }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/students")
    public Student getStudents(@PathParam("id") long id) {
        Student student = new Student();
               return student;

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateStudent(@PathParam("id") long id, Student student) {
        StudentService.changeStudent(student);
        String json = "{'id':" + student.getId() + ",'Fname':'" + student.getFname() + "','Lname':'" + student.getLname() + "','email':'" + student.getEmail() + "','gno':'" + student.getGno() + "','balance':'"+student.getBalance()+"'}";
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void removeStudent(@PathParam("id") long id) {
        StudentService.deleteStudent(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStudent(Student student) {
        System.out.println("   student  " + student.getEmail() + student.getFname() + student.getLname() + student.getGno()+student.getBalance());
        StudentService service = new StudentService();
        service.addStudent(student);

//        return Response.status(Response.Status.CREATED).entity(student).build();
//        return student;
    }

}
