package pl.grx.archapp

import pl.grx.archapp.factories.DisplayHelperFactory
import pl.grx.archapp.model.Participant
import pl.grx.archapp.model.Participants

class ScoreTest extends httpGetPostBase {
    def displayHelperFactoryMock = Mock(DisplayHelperFactory)
    def participantsMock = Mock(Participants)

    def "test doGet without m parameter"() {
        given:
        def score = new Score(displayHelperFactoryMock, participantsMock)
        when:
        score.doGet(requestMock, responseMock)
        then:
        1 * requestDispatcherIndexMock.forward(requestMock, responseMock)
    }

    def "test doGet with m parameter incorrect"() {
        given:
        def score = new Score(displayHelperFactoryMock, participantsMock)
        requestMock.getParameter("m") >> "wrong_number"
        when:
        score.doGet(requestMock, responseMock)
        then:
        1 * requestDispatcherIndexMock.forward(requestMock, responseMock)
    }

    def "test doGet with m parameter correct"() {
        given:
        def score = new Score(displayHelperFactoryMock, participantsMock)
        requestMock.getParameter("m") >> "1"
        when:
        score.doGet(requestMock, responseMock)
        then:
        1 * requestDispatcherScoreMock.forward(requestMock, responseMock)
    }

    def "test doPost without score parameters"() {
        given:
        def score = new Score(displayHelperFactoryMock, participantsMock)
        requestMock.getParameter("m") >> "1"
        parameterNames = ["m"]
        when:
        score.doPost(requestMock, responseMock)
        then:
        1 * responseMock.sendRedirect({it.contains("score") && it.contains("?m=1")} as String)
    }

    def "test doPost with score parameters"() {
        given:
        def score = new Score(displayHelperFactoryMock, participantsMock)
        parameterNames = ["m",
                          "score%1:testParticipantA", "score%2:testParticipantA",
                          "score%1:testParticipantB", "score%2:testParticipantB"]
        requestMock.getParameter(_ as String) >>> ["1", "10", "9", "10"] >> ""
        def participantMock = Mock(Participant)
        participantsMock.getParticipantByName("testParticipantA") >> participantMock
        participantsMock.getParticipantByName("testParticipantB") >> participantMock
        when:
        score.doPost(requestMock, responseMock)
        then:
        2 * participantMock.saveScore(10, 0)
        1 * participantMock.saveScore(9, 1)
        1 * participantMock.saveScore(null, 1)
        1 * responseMock.sendRedirect({it.contains("score") && it.contains("?m=1")} as String)
    }

    def "test getParticipant"() {
        given:
        def score = new Score(displayHelperFactoryMock, participantsMock)
        when:
        score.getParticipant(1, 1)
        then:
        1 * participantsMock.getParticipant(1, 1);
    }

    def "test getScoreDisplayHelper"() {
        given:
        def participantMock = Mock(Participant)
        def score = new Score(displayHelperFactoryMock, participantsMock)
        when:
        score.getScoreDisplayHelper(participantMock)
        then:
        1 * displayHelperFactoryMock.buildScoreDisplayHelper(participantMock)
    }
}
