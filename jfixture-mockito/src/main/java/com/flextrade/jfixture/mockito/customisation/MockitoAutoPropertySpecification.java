package com.flextrade.jfixture.mockito.customisation;

import com.flextrade.jfixture.specifications.Specification;

import java.lang.reflect.Modifier;

class MockitoAutoPropertySpecification implements Specification {

    @Override
    public boolean isSatisfiedBy(Object request) {

        if(!(request instanceof Class)) {
            return false;
        }

        // No need to auto populate the properties of
        // an interface/abstract class because they'll be mocked
        Class<?> requestClass = (Class<?>)request;
        if(requestClass.isInterface() || Modifier.isAbstract(requestClass.getModifiers())) {
            return false;
        }

        String requestName = ((Class<?>)request).getName();
        Boolean isAMock = requestName.contains("Mockito");
        return !isAMock;
    }
}
