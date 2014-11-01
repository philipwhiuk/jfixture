package com.flextrade.jfixture.mockito.customisation;

import com.flextrade.jfixture.JFixture;
import com.flextrade.jfixture.mockito.customisation.MockitoCustomisation;
import com.flextrade.jfixture.mockito.testtypes.OrderAbstractClass;
import com.flextrade.jfixture.mockito.testtypes.OrderInterface;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestMockitoRelay {

    @Test
    public void mock_properties_are_stubbed_out_for_interfaces_using_fixture() {
        JFixture fixture = new JFixture();
        fixture.customise(new MockitoCustomisation());

        OrderInterface order = fixture.create(OrderInterface.class);
        assertNotNull(order.getSymbol());
        assertTrue(order.getSize() > 0);
        assertTrue(order.getPrice() > 0.0);
    }

    @Test
    public void mock_properties_are_stubbed_out_for_abstract_classes_using_fixture() {
        JFixture fixture = new JFixture();
        fixture.customise(new MockitoCustomisation());

        OrderAbstractClass order = fixture.create(OrderAbstractClass.class);
        assertNotNull(order.getSymbol());
        assertTrue(order.getSize() > 0);
        assertTrue(order.getPrice() > 0.0);
    }
}
