import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.di.phonebook.config.JavaConfig;
import com.di.phonebook.domain.Contact;
import com.di.phonebook.service.PhoneService;

public class MainApplication {

	public static void main(String args[]){
		ApplicationContext context =new AnnotationConfigApplicationContext(JavaConfig.class);
		PhoneService ps = (PhoneService) context.getBean(PhoneService.class);
		for(Contact c : ps.getAllContacts().values()){
			System.out.println(c.getPhone());
		}
	}
}
