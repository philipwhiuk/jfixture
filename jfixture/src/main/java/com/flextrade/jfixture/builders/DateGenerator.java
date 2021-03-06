package com.flextrade.jfixture.builders;

import com.flextrade.jfixture.NoSpecimen;
import com.flextrade.jfixture.SpecimenBuilder;
import com.flextrade.jfixture.SpecimenContext;
import com.flextrade.jfixture.utility.Clock;
import com.flextrade.jfixture.utility.TimeProvider;

import java.util.Date;
import java.util.Random;

class DateGenerator implements SpecimenBuilder {

    private final Random random = new Random();
    private final TimeProvider timeProvider;

    public DateGenerator() {
        this(new Clock());
    }

    public DateGenerator(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    @Override
    public Object create(Object request, SpecimenContext context) {

        if (!request.equals(Date.class)) {
            return new NoSpecimen();
        }

        long millisecondSinceEpoch = this.timeProvider.getCurrentTimeInMilliseconds();
        long randomMillisecondsUpToNow = (long) (random.nextDouble() * millisecondSinceEpoch);

        return new Date(randomMillisecondsUpToNow);
    }
}
