package login.controller;
import login.view.LoginView;
import login.model.LoginModel;
public class LoginController {
	private LoginView view;
    private LoginModel model;

    public LoginController(LoginView view){
        this.view = view;
        model = new LoginModel();
    }

    public void checkCredentials(String username, String password){
        model.setUsername(username);
        model.getCredentials();
        if(password.equals(model.getPassword())){
            view.setErrorMessage("Login Success!");
        }
        else{
            view.setErrorMessage("Login Failed!");
        }
    }
}

