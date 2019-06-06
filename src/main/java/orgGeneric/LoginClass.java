package orgGeneric;

public class LoginClass extends BaseClass {
	public void login()
	{
		CommonMethodgeneric.setText("Username",BaseClass.config.getProperty("UN") );
		CommonMethodgeneric.setText("Password",BaseClass.config.getProperty("PW") );
				
		
	}
	

}
