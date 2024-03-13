//package prak10.Java10prakSpring.src.main.java.com.ldf.java10prakspring;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class Java10prakSpringApplication {
//    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out.println("Введите название бина");
//            return;
//        }
//        String bean = args[0];
//
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        try {
//            Programmer programmer = (Programmer) context.getBean(bean);
//            programmer.doCoding();
//        } catch (Exception e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//    }
//
//}
