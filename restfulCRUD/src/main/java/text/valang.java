package text;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

import com.symbio.valang.MembershipVoValidator;
import com.symbio.vo.MembershipVo;

public class valang {

	@Test
	public void test() {
		MembershipVo m = new MembershipVo();
		m.setLastName("11111111111111");
		m.setFirstName("222");
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("/membershipValang.xml");

		 MembershipVoValidator test = (MembershipVoValidator) ctx.getBean("membershipVoValidator");

	       BindException errors= new BindException(m, "target");

	       test.validate(m, errors);

	       for (Object obj : errors.getAllErrors()){

	           System.out.println(((FieldError)obj).getDefaultMessage());

	       }
	}

}
