package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("spring.xml");

        ApplicationContext context =
                new AnnotationConfigApplicationContext(beanConfig.class);

        // bean la class-ku path koduthu ipdi use pandra method
        Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();
        doctor.setQualification("MBBS");
        System.out.println(doctor);

        Doctor doctor1 = context.getBean(Doctor.class);
        System.out.println(doctor1);
//        System.out.println(doctor.getQualification());
//        System.out.println(doctor.getNurse());
//        doctor.getNurse().assist();

        // bean la id-ku value koduthu ipdi use pandra method
//        Nurse nurse = (Nurse) context.getBean("nurse");
//        nurse.assist();

//        Staff staff = context.getBean(Doctor.class);
//        staff.assist();


    }
}
