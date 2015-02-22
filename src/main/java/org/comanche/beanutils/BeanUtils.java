package main.java.org.comanche.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;

/**
 * Classe utilitaire permettant de manipuler des beans.
 * 
 * @author Hary.
 *
 */
public class BeanUtils {
	
	/**
	 * <p>Permet d'obtenir successivement la valeur d'une propri�t� d'instance.</p>
	 * 
	 * @param obj sur lequel la r�cup�ration est faite.
	 * @param properties � r�cup�rer successivement dans l'objet.
	 * @return la valeur de la derni�re propri�t� par parcours successif des propri�t�s sp�cifi�es.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T get(Object obj, String... properties) {
		Object o = obj;
		for(int i = 0 ; o != null && i < properties.length ; i++) {
			try {
				o = invokeGetter(o, properties[i]);
			} catch(IllegalArgumentException e) {
				o = null;
			}
		}
		return (T) o;
	}
	
	/**
	 * <p>R�cup�re la valeur de la propri�t� d'une instance en utilisant son getter.</p>
	 * 
	 * @param obj contenant la propri�t� dont la valeur est � extraire.
	 * @param property de l'objet dont la valeur sera r�cup�r�e.
	 * @return la valeur de l'attribut de l'objet.
	 */
	private static Object invokeGetter(Object obj, String property) {
		String getter = "get".concat(StringUtils.capitalize(property));
		try {
			Method method = obj.getClass().getDeclaredMethod(getter, new Class<?>[0]);
			if(!method.isAccessible()) {
				method.setAccessible(true);
			}
			return method.invoke(obj, new Object[0]);
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
		} catch (IllegalAccessException e) {
		} catch (IllegalArgumentException e) {
		} catch (InvocationTargetException e) {
		}
		return null;
	}
	
}
