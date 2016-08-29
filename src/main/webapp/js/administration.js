function addTrailingZeroes(input, constantDigits) {
    input.setAttribute('type', 'text');
    if (input.value.length > constantDigits) {
        input.value = input.value.replace(/^0+/, '');
    }
    while (input.value.length < constantDigits) {
        input.value = "0" + input.value;
    }
}

var clickCather = document.getElementById("clickCather");

function toggleList(input) {
    var list = input.nextElementSibling;

    if (list.hasAttribute("hidden")) {
        list.removeAttribute("hidden");
        document.getElementById("clickCather").removeAttribute("hidden");
    }
    else {
        hideList(list);
    }
}

function hideList(list) {
    list.setAttribute("hidden", 1);
    clickCather.setAttribute("hidden", 1)
}

function hideAllLists() {
    var lists = document.getElementsByClassName("dropdown");
    for (var index in lists) {
        if (lists.hasOwnProperty(index)) {
            hideList(lists[index]);
        }
    }
}

function selectItemOnList(item) {
    var list = item.parentElement;
    var input = list.parentElement.firstElementChild;
    input.value = item.textContent;
    hideList(list);
}
