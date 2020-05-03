package com.lu.list;


/**
 * @author 小卢
 */
public interface List<E> {
    static final int ELEMENT_NOT_FOUND = -1;
    /**
     * 元素的数量
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 添加一个元素
     */
    void add(E element);

    /**
     * 获取下标位index的元素
     * @param index
     * @return
     */
    E get(int index);


    /**
     * 将一个元素放到index下标位置
     * @param index
     * @param element
     * @return
     */
    E set(int index, E element);

    /**
     * 添加一个元素到index下标位置
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 返回element所在下标,没有返回-1
     * @param element
     * @return
     */
    int indexOf(E element);

    /**
     * 清空list
     */
    void clear();

}
