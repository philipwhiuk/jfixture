package com.flextrade.jfixture.behaviours.recursion;

import com.flextrade.jfixture.SpecimenBuilder;
import com.flextrade.jfixture.SpecimenContext;

import java.util.Stack;

class RecursionGuard implements SpecimenBuilder {

    private final Stack<Object> monitoredRequests = new Stack<Object>();
    private final SpecimenBuilder builder;
    private final RecursionHandler recursionHandler;

    public RecursionGuard(SpecimenBuilder builder, RecursionHandler recursionHandler) {
        this.builder = builder;
        this.recursionHandler = recursionHandler;
    }

    @Override
    public Object create(Object request, SpecimenContext context) {

        for (Object monitoredRequest : this.monitoredRequests) {
            if(request.equals(monitoredRequest)) {
                return this.handleRecursiveRequest(request);
            }
        }

        this.monitoredRequests.push(request);
        Object specimen = this.builder.create(request, context);
        this.monitoredRequests.pop();
        return specimen;
    }

    public SpecimenBuilder builder() {
        return this.builder;
    }

    public RecursionHandler handler() {
        return this.recursionHandler;
    }

    private Object handleRecursiveRequest(Object request) {
        return this.recursionHandler.handleRecursiveRequest(request, this.monitoredRequests);
    }
}
