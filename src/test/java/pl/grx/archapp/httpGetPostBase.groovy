package pl.grx.archapp

import spock.lang.Specification

import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class httpGetPostBase extends Specification {

    def requestMock = Mock(HttpServletRequest)
    def requestDispatcherAdminMock = Mock(RequestDispatcher)
    def requestDispatcherIndexMock = Mock(RequestDispatcher)
    def requestDispatcherScoreMock = Mock(RequestDispatcher)
    def responseMock = Mock(HttpServletResponse)
    List<String> parameterNames

    def setup() {
        requestMock.getRequestDispatcher({it.contains("admin")} as String) >> requestDispatcherAdminMock
        requestMock.getRequestDispatcher({it.contains("index")} as String) >> requestDispatcherIndexMock
        requestMock.getRequestDispatcher({it.contains("score.jsp")} as String) >> requestDispatcherScoreMock
        requestMock.getParameterNames() >> new Enumeration<String>() {
            int index = 0
            @Override
            boolean hasMoreElements() {
                return index < parameterNames.size()
            }

            @Override
            String nextElement() {
                return parameterNames.get(index++)
            }
        }
    }
}