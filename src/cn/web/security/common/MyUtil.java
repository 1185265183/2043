package cn.web.security.common;

public class MyUtil {
	
	/**
	 * 
	 * @param ofclass
	 * @return
	 */
	public static String getclassname(String ofclass) {
		String classname= new String();
		String father = new String();
		if(ofclass.contains("(")) {
			//先拿出类名
			classname = ofclass.split("\\(")[0];
			//判断是结构还是类
			if(ofclass.contains("(class")) {
				//判断是否有父类
				if(ofclass.split("class\\)")[1].equals(" ")) {
					//没有父类
				}else {
					//有父类
					father = ofclass.split("\\) ")[1];
				}
			}else if(ofclass.contains("(struct)")) {
				
			}else {
				
			}
		}else {
			//直接就是类名，不需要处理
			classname = ofclass;
		}
		return classname;
	}

}
