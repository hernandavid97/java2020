package logic;

import data.DataUsuario;
import entities.Usuario;

public class Login {
	private DataUsuario du;
	
	public Login() {
		 du=new DataUsuario();
	}
	
	public Usuario validate(Usuario u) {		
		return du.getByUser(u);
	}
	
	public String validaRegistro(Usuario u) {
		if (du.getByUser(u) == null) {
			u.setId(du.newUser(u));		
			return ("Usuario Creado: " + u.toString());
		}else return ("El usuario ya existe, utilice uno diferente");
	}
}
