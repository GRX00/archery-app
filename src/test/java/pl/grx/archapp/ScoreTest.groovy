package pl.grx.archapp

import pl.grx.archapp.factories.DisplayHelperFactory
import pl.grx.archapp.model.Participants

class ScoreTest extends httpGetPostBase {
    def displayHelperFactoryMock = Mock(DisplayHelperFactory)
    def participantsMock = Mock(Participants)

    def "test doGet"() {
        given:
        def score = new Score(displayHelperFactoryMock, participantsMock);
        when:
        score.doGet(requestMock, responseMock)
        then:
        score.doGet(requestMock, responseMock)
    }

    def "test doPost"() {
        given:
        def score = new Score(displayHelperFactoryMock, participantsMock);
        when:
        score.doGet(requestMock, responseMock)
        then:
        score.doGet(requestMock, responseMock)
    }

    def "test getParticipant"() {
        given:
        def score = new Score(displayHelperFactoryMock, participantsMock);
        when:
        score.doGet(requestMock, responseMock)
        then:
        score.doGet(requestMock, responseMock)
    }

    def "test getScoreDisplayHelper"() {
        given:
        def score = new Score(displayHelperFactoryMock, participantsMock);
        when:
        score.doGet(requestMock, responseMock)
        then:
        score.doGet(requestMock, responseMock)
    }
}
