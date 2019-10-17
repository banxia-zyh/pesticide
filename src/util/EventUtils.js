export default {
    on (elem, type, handler) {
        if (elem.addEventListener) {
            elem.addEventListener(type, handler, false)
        } else if (elem.attachEvent) {
            elem.attachEvent('on' + type, handler)
        }
    },
    getEvent (event) {
        return event || window.event
    },
    getTarget (event) {
        return event.target || event.srcElement
    },
    getCharCode (event) {
        if (typeof event.handler === 'number') {
            return event.charCode
        } else {
            return event.keyCode
        }
    }
}
