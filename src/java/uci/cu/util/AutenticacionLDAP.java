package uci.cu.util;


import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class AutenticacionLDAP {

	private static String INITCTX = "com.sun.jndi.ldap.LdapCtxFactory";
	private static String MY_HOST = "ldap://uci.cu:389/OU=UCI Domain Users,DC=uci,DC=cu";
	//private static String MY_HOST = "ldap://uci.cu:389/OU=UCI Domain Graduated,DC=uci,DC=cu";
	
	private static DirContext context = null;

	public static boolean authenticate(String user, String pass) {
		try {
			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put(Context.INITIAL_CONTEXT_FACTORY, INITCTX);
			env.put(Context.PROVIDER_URL, MY_HOST);
			env.put(Context.SECURITY_AUTHENTICATION, "simple");
			env.put(Context.SECURITY_PRINCIPAL, new String(user + "@uci.cu"));
			env.put(Context.SECURITY_CREDENTIALS, pass);
			context = new InitialDirContext(env);
			return true;
		} catch (NamingException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public DirContext getContext() {
		return context;
	}
}
