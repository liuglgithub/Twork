package com.liugl.alltest.annotation.defindbutterknife;

import android.app.Activity;
import android.view.View;

import com.liugl.alltest.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by liugl on 2017/2/6.
 * View解析类，主要用于解析含有注解的View成员变量
 */

public class ViewBinderParser {

    /**
     * @param object
     */
    public static void inject(Object object) {

        ViewBinderParser parser = new ViewBinderParser();
        try {
            parser.parser(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param object
     */
    public static void inject(Object object,String str) {

        ViewBinderParser parser = new ViewBinderParser();
        try {
            parser.parserMethod(object.getClass(),object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserMethod(Class<?> clazz, final Object object) throws Exception {
        View view = null;
        // 获取目标对象定义的成员方法
        Method[] methods = clazz.getDeclaredMethods();
        // 循环遍历成员变量
        for (final Method method : methods) {
            if (method.isAnnotationPresent(OnClick.class)) {
                OnClick inject = method.getAnnotation(OnClick.class);
                int id = inject.id();
                if (id < 0) {
                    throw new Exception("id must not be null!!!");
                }
                if (id > 0) {
                    if (object instanceof View) {
                        view = ((View) object).findViewById(id);
                    } else if (object instanceof Activity) {
                        view = ((Activity) object).findViewById(id);
                    }
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
//                                method.invoke(object, null);
                                method.invoke(object,new  Object[]{});
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }



    public void parser(final Object object) throws Exception {

        View view = null;
        //获取目标对象字节码
        final Class<?> clazz = object.getClass();

        //获取目标对象的成员变量
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ViewBinder.class)) {
                ViewBinder inject = field.getAnnotation(ViewBinder.class);
                int id = inject.id();
                if (id < 0) {
                    throw new Exception("id must not be null");
                }
                if (id > 0) {
                    field.setAccessible(true);
                    if (object instanceof View) {
                        view = (View) ((View) object).findViewById(id);
                    } else if (object instanceof Activity) {
                        view = (View) ((Activity) object).findViewById(id);
                    }
                    //给我们要找的字段设置id
                    field.set(object, view);
                }

            }
        }

    }

}
