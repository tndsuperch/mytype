package cn.mytype.mvc.service;

public abstract class AbstractService<P, R> implements Service<P, R> {

    public R execute(P param) {
        R result = null;

        preDoExecute(param);

        result = doExecute(param);

        postDoExecute(param, result);

        return result;
    }

    protected abstract R doExecute(P param);

    protected void preDoExecute(P param){

    }

    protected void postDoExecute(P param, R result){

    }

}
