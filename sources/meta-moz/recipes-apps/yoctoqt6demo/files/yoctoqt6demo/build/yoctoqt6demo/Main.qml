import QtQuick 


Window {
    visible: true
    width: 640
    height: 480
    title: qsTr("Hello World")

    Rectangle{
        id:rect
        color:"red"
        width:parent.width
        height:parent.height
    }
}
