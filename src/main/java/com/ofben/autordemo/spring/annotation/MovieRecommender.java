package com.ofben.autordemo.spring.annotation;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Map;
import java.util.Set;

/**
 * Bean
 *
 * @date 2021-09-27
 * @since 1.0.0
 */
public class MovieRecommender {

    @Autowired
    private ApplicationContext context;

    @Genre("active")
    private final CustomerPreferenceDao dao;

    @Autowired
    @Offline
    private final MovieCatalog log;

    private Map<String, MovieCatalog> movieCatalogMap;

    @Autowired
    public void setMovieCatalogMap(@Qualifier("main") Map<String, MovieCatalog> movieCatalogMap) {
        this.movieCatalogMap = movieCatalogMap;
    }

    @Autowired
    @MovieQualifier(format = Format.BLURAY, genre = "Action")
    private MyBean myBean;
    @Autowired
    @MovieQualifier(format = Format.DVD, genre = "Action")
    private MyBean myBean2;
    @Autowired
    @MovieQualifier(format = Format.VHS, genre = "Dev")
    private MyBean myBean3;
    @Autowired
    @MovieQualifier(format = Format.BLURAY, genre = "Main")
    private MyBean myBean4;

    @Autowired
    public MovieRecommender(@Nullable CustomerPreferenceDao dao, MovieCatalog log) {
        this.dao = dao;
        this.log = log;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CustomerPreferenceDao.class);
        context.register(MovieCatalog.class);
        context.register(MovieRecommender.class);
        context.register(MyBean.class);
        context.refresh();
        MovieRecommender bean = context.getBean(MovieRecommender.class);
        System.out.println(bean.dao);
        System.out.println(bean.log);
        System.out.println(bean.myBean);
        System.out.println("-------------");
        Set<String> keySet = bean.movieCatalogMap.keySet();
        for (String key : keySet) {
            System.out.println(key + "=" + bean.movieCatalogMap.get(key));
        }
        context.close();
    }
}
