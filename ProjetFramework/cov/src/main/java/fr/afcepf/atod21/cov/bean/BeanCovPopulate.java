package fr.afcepf.atod21.cov.bean;

import java.lang.reflect.Method;
import java.util.Map;

public class BeanCovPopulate {
	public Object populateBean(Object obj, Map<String, String[]> requestParamsMap) {

		Class dynamicClass = obj.getClass();
		Object objectClass = null;

		try {
			objectClass = dynamicClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		for (String currentKey : requestParamsMap.keySet()) {
			try 
			{
				Method[] methodList = dynamicClass.getMethods();

				for (Method currentMethod : methodList) {
					if (currentMethod.getName().compareToIgnoreCase(
							"set" + currentKey) == 0) {
						currentMethod.invoke(objectClass, requestParamsMap.get(currentKey));
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
