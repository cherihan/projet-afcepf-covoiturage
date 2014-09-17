package fr.afcepf.atod21.cov.bean;

import java.lang.reflect.Method;
import java.util.Map;

public class BeanCovPopulate {
    private String foo;
    public String getFoo() {
        return foo;
    }
    public void setFoo(String paramFoo) {
        foo = paramFoo;
    }

    public Object populateBean(Object obj, Map<String, String[]> requestParamsMap){
		Class dynamicClass = obj.getClass();
		Object objectClass = null;
		try {
            objectClass = dynamicClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
		for (String currentKey : requestParamsMap.keySet()) {
            Method[] methodList = dynamicClass.getMethods();
            
            for (Method currentMethod : methodList) {
                if (currentMethod.getName().compareToIgnoreCase("set" + currentKey) == 0) {
                    try {
                        currentMethod.invoke(objectClass, requestParamsMap.get(currentKey));
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e);
                    }
                }
            }
        }
		return null;
	}
}
