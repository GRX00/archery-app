package pl.grx.archapp

import pl.grx.archapp.model.Mats

class IndexTest extends httpGetPostBase {

    def "doGet forward to admin when not configured"() {
        given:
        def index = new Index(null)

        when:
        index.doGet(requestMock, responseMock)

        then:
        1 * requestDispatcherAdminMock.forward(requestMock, responseMock)
    }

    def "doGet called second time forward to index"() {
        given:
        def index = new Index(null)

        when:
        index.doGet(requestMock, responseMock)
        index.doGet(requestMock, responseMock)

        then:
        1 * requestDispatcherIndexMock.forward(requestMock, responseMock)
    }

    def "doGet forward to index when configured"() {
        given:
        def index = new Index(null)

        when:
        index.setConfigured()
        index.doGet(requestMock, responseMock)

        then:
        1 * requestDispatcherIndexMock.forward(requestMock, responseMock)
    }

    def "getMatsCount returns mats count"() {
        given:
        def mats = Mock(Mats);
        def index = new Index(mats)

        when:
        index.getMatsCount()

        then:
        1 * mats.getMatsCount()
    }
}
