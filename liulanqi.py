#encoding=utf-8

import sys

from PyQt4.QtGui import QApplication

from PyQt4.QtCore import QUrl

from PyQt4.QtWebKit import QWebView



class Browser(QWebView):

        def __init__(self):

                QWebView.__init__(self)

                self.loadFinished.connect(self._result_availiable)

                

        def _result_availiable(self, ok):

                frame = self.page().mainFrame()

                dom = unicode(frame.toHtml()).encode('utf-8')

                parseDom(dom)



def parseDom(dom):        

        #print 'dom', dom

        pass # TODO



if __name__ == '__main__':

        app = QApplication(sys.argv)

        view = Browser()

        url = 'http://www.baidu.com'

        view.load(QUrl(url))

        view.show()

        app.exec_()
