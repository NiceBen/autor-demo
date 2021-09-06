package com.ofben.autordemo.test.poker.mock;

import java.util.List;

/**
 * 对象、集合深拷贝
 *
 * @date 2021-09-06
 * @since 1.0.0
 */
public class BeanUtils {
    /**
     * @param orig  源对象
     * @param dest  目标对象
     */
    public static void copyProperties(final Object orig,final Object dest){
        try{
            org.springframework.beans.BeanUtils.copyProperties(orig, dest);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * @Description：拷贝list元素对象，将origs中的元素信息，拷贝覆盖至dests中
     * @param origs 源list对象
     * @param dests 目标list对象
     * @param origsElementTpe 源list元素类型对象
     * @param destElementTpe 目标list元素类型对象
     * @param <T1> 源list元素类型
     * @param <T2> 目标list元素类型
     */
    public static <T1,T2> void copyListProperties(final List<T1> origs, final List<T2> dests, Class<T1> origsElementTpe, Class<T2> destElementTpe){
        if(origs==null||dests==null){
            return ;
        }
        if(dests.size()!=0){
            //防止目标对象被覆盖，要求必须长度为零
            throw new RuntimeException("目标对象存在值");
        }
        try{
            for (T1 orig: origs) {
                T2 t = destElementTpe.newInstance();
                dests.add(t);
                copyProperties(orig,t);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
