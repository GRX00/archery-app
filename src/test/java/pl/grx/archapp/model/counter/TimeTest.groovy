package pl.grx.archapp.model.counter

import spock.lang.Specification

class TimeTest extends Specification {
    def "test time set"() {
        given:
        def time = new Time(0, 0);
        when:
            time.set(1,1)
        then:
            time.get() == 61
    }

    def "test minus time set"() {
        given:
        def time = new Time(0, 0);
        when:
        time.set(-1,-1)
        then:
        time.get() == 0
    }
}
