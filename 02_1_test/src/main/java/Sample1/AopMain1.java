package Sample1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain1 {

	public static void main(String[] args) {
    System.out.println("상품주문하기");
	
//    Login1 login = new Login1();
//    login.login1();
//    
//    Order1 or = new OrderImpl1();
//    or.order1();
//	
//    Dao1 dao = new Dao1();
//    dao.dao1();
//    
//    Logout1 log = new Logout1();
//    log.logout1();
    
    AbstractApplicationContext context = new GenericXmlApplicationContext("app1.xml");
    
    Order1 myorder = (Order1)context.getBean("order1");
    myorder.order1();
    
    System.out.println("===================================");
    
    Board1 bd = (Board1)context.getBean("board1");
    bd.board1();

	}

}
