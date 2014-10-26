package cn.mytype.mvc.service;

public interface Service<P, R> {
    public R execute(P param);
}
