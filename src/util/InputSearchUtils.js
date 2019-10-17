

function stopPropagation (e) {
    e = window.event || e
    if (document.all) {
        e.cancelBubble = true
    } else {
        e.stopPropagation()
    }
}

var input = document.getElementById('#search')
var datalist = document.getElementById('#datalist')
var listArray = ['aa', 'aab', 'abc']

function generatelist (array) {
    var _innerHTML = ''
    for (var i = 0; i < array.length; i++) {
        _innerHTML += '<li>' + array[i] + '</li>'
    }
    datalist.innerHTML = _innerHTML
}

function findInArray (s) {
    var filterArray = []
    if (s !== '') {
        for (var i = 0; i < listArray.length; i++) {
            if (listArray[i].indexOf(s) === 0) {
                filterArray.push(listArray[i])
            }
        }
    }
    return filterArray
}

input.onkeyup = function () {
    var newArray = findInArray(this.value)
    generatelist(newArray)
    if (newArray.length > 0) {
        setTimeout(function () {
            datalist.style.visibility = 'visible'
        }, 0)
    } else {
        setTimeout(function () {
            datalist.style.visibility = 'hidden'
        }, 0)
    }
}
EventUtil.on(document.body, 'click', function (e) {
    stopPropagation(e)
    if (EventUtil.getTarget(e).nodeName === 'BODY') {
        datalist.style.visibility = 'hidden'
        datalist.innerHTML = ''
    }
    if (EventUtil.getTarget(e).nodeName === 'LI') {
        input.value = EventUtil.getTarget(e).innerHTML
        datalist.style.visibility = 'hidden'
        datalist.innerHTML = ''
    }
})
