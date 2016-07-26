package pl.grx.archapp

import spock.lang.Specification

class CompetitionInstanceTest extends Specification {
    def "IsFirstRun should return true"() {
        expect:
        Competition.isFirstRun()
    }

    def "GetInstance should change isFirstRun to false"() {
        given:
        def competitionSingleton = Competition.getInstance();

        expect:
        !competitionSingleton.isFirstRun()
    }
}
