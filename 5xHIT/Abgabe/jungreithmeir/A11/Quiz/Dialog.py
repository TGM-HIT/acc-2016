# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'NewQuestion.ui'
#
# Created: Wed Dec 21 21:22:16 2016
#      by: pyside-uic 0.2.15 running on PySide 1.2.4
#
# WARNING! All changes made in this file will be lost!

from PySide import QtCore, QtGui

class Ui_Dialog(object):
    def setupUi(self, Dialog):
        Dialog.setObjectName("Dialog")
        Dialog.resize(400, 300)
        self.gridLayout_2 = QtGui.QGridLayout(Dialog)
        self.gridLayout_2.setObjectName("gridLayout_2")
        self.buttonBox = QtGui.QDialogButtonBox(Dialog)
        self.buttonBox.setOrientation(QtCore.Qt.Horizontal)
        self.buttonBox.setStandardButtons(QtGui.QDialogButtonBox.Cancel|QtGui.QDialogButtonBox.Ok)
        self.buttonBox.setObjectName("buttonBox")
        self.gridLayout_2.addWidget(self.buttonBox, 3, 0, 1, 1)
        self.eQuestion = QtGui.QTextEdit(Dialog)
        self.eQuestion.setObjectName("eQuestion")
        self.gridLayout_2.addWidget(self.eQuestion, 1, 0, 1, 1)
        self.gridLayout = QtGui.QGridLayout()
        self.gridLayout.setObjectName("gridLayout")
        self.eAnswer2 = QtGui.QTextEdit(Dialog)
        self.eAnswer2.setObjectName("eAnswer2")
        self.gridLayout.addWidget(self.eAnswer2, 0, 1, 1, 1)
        self.eAnswer4 = QtGui.QTextEdit(Dialog)
        self.eAnswer4.setObjectName("eAnswer4")
        self.gridLayout.addWidget(self.eAnswer4, 1, 1, 1, 1)
        self.eAnswer1 = QtGui.QTextEdit(Dialog)
        self.eAnswer1.setStyleSheet(".QLineEdit, .QTextEdit\n"
"{\n"
"background-color: yellow;\n"
"}")
        self.eAnswer1.setObjectName("eAnswer1")
        self.gridLayout.addWidget(self.eAnswer1, 0, 0, 1, 1)
        self.eAnswer3 = QtGui.QTextEdit(Dialog)
        self.eAnswer3.setObjectName("eAnswer3")
        self.gridLayout.addWidget(self.eAnswer3, 1, 0, 1, 1)
        self.gridLayout_2.addLayout(self.gridLayout, 2, 0, 1, 1)

        self.retranslateUi(Dialog)
        QtCore.QObject.connect(self.buttonBox, QtCore.SIGNAL("accepted()"), Dialog.accept)
        QtCore.QObject.connect(self.buttonBox, QtCore.SIGNAL("rejected()"), Dialog.reject)
        QtCore.QMetaObject.connectSlotsByName(Dialog)

    def retranslateUi(self, Dialog):
        Dialog.setWindowTitle(QtGui.QApplication.translate("Dialog", "New Question with answers", None, QtGui.QApplication.UnicodeUTF8))

