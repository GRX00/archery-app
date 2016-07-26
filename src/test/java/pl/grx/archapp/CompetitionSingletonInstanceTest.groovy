package pl.grx.archapp

import spock.lang.Specification

class CompetitionSingletonInstanceTest extends Specification {
    def "IsFirstRun should return true"() {
        expect:
        CompetitionSingleton.isFirstRun()
    }

    def "GetInstance should change isFirstRun to false"() {
        given:
        def competitionSingleton = CompetitionSingleton.getInstance();

        expect:
        !competitionSingleton.isFirstRun()
    }
}
