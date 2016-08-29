package pl.grx.archapp

import spock.lang.Specification

import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class httpGetPostBase extends Specification {

    def requestMock = Mock(HttpServletRequest)
    def requestDispatcherAdminMock = Mock(RequestDispatcher)
    def requestDispatcherIndexMock = Mock(RequestDispatcher)
    def responseMock = Mock(HttpServletResponse)

    def setup() {
        requestMock.getRequestDispatcher({it.contains("admin")} as String) >> requestDispatcherAdminMock
        requestMock.getRequestDispatcher({it.contains("index")} as String) >> requestDispatcherIndexMock
    }
}