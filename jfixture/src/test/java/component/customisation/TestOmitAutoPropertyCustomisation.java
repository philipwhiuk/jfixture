package component.customisation;

import com.flextrade.jfixture.JFixture;
import com.flextrade.jfixture.customisation.OmitAutoPropertyCustomisation;
import org.junit.Test;
import testtypes.TypeWithFields;
import testtypes.TypeWithProperties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TestOmitAutoPropertyCustomisation {

    @Test
    public void when_set_globally_generates_types_with_no_properties_set() {
        JFixture fixture = new JFixture();
        fixture.customise(new OmitAutoPropertyCustomisation());

        TypeWithProperties type = fixture.create(TypeWithProperties.class);
        assertNull(type.getSymbol());
        assertEquals(0, type.getSize());
    }

    @Test
    public void when_set_globally_generates_types_with_no_fields_set() {
        JFixture fixture = new JFixture();
        fixture.customise(new OmitAutoPropertyCustomisation());

        TypeWithFields type = fixture.create(TypeWithFields.class);
        assertNull(type.symbol);
        assertEquals(0, type.size);
    }

    @Test
    public void when_set_for_specific_class_generates_types_with_no_fields_set() {
        JFixture fixture = new JFixture();
        fixture.customise(new OmitAutoPropertyCustomisation(TypeWithFields.class));

        TypeWithFields type = fixture.create(TypeWithFields.class);
        assertNull(type.symbol);
        assertEquals(0, type.size);
    }

    @Test
    public void when_set_for_specific_class_generates_types_with_fields_set_for_other_types() {
        JFixture fixture = new JFixture();
        fixture.customise(new OmitAutoPropertyCustomisation(TypeWithFields.class));

        TypeWithProperties type = fixture.create(TypeWithProperties.class);
        assertNotNull(type.getSymbol());
        assertTrue(type.getSize() > 0);
    }
}
